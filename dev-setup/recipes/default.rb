#
# Cookbook Name:: dev-setup
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

include_recipe "java::default"
include_recipe "java::default_java_symlink"

include_recipe "maven::default"

#
# Eclipse installation. See: https://docs.chef.io/resource_remote_file.html
#
eclipse_archive = "#{Chef::Config[:file_cache_path]}/eclipse.tar.gz"
eclipse_install_dir = "/opt"

remote_file eclipse_archive do
  source node['dev-setup']['eclipse-download-url']
end

bash "install eclipse" do
  code <<-EOH
    tar xzf #{eclipse_archive} -C #{eclipse_install_dir}
    EOH
  not_if { ::File.exists?("/opt/eclipse") }
end

#
# Create link to eclipse. See https://docs.chef.io/resource_link.html#examples
#
link "/usr/bin/eclipse" do
  to "/opt/eclipse/eclipse"
  not_if { ::File.exists?("/usr/bin/eclipse") }
end

#
# Install vim
#
package "vim" do
  action :install
end

#
# terminator installation
#
package "terminator" do
  action :install
end

#
# Set vim as default editor in /etc/bashrc
# alias vi='vim'. See:
# http://stackoverflow.com/questions/16879469/using-a-chef-recipe-to-append-multiple-lines-to-a-config-file
# http://stackoverflow.com/questions/14848110/how-i-can-change-a-file-with-chef/19167106#19167106
#
ruby_block "set vim as default editor in /etc/bashrc" do
  block do
    fe = Chef::Util::FileEdit.new("/etc/bashrc")
    fe.insert_line_if_no_match(/alias vi='vim'/,
                               "alias vi='vim'")
    fe.write_file
  end
end

#
# Gradle installation
#
gradle_archive = "#{Chef::Config[:file_cache_path]}/gradle.zip"
gradle_install_dir = "/opt"

remote_file gradle_archive do
  source node['dev-setup']['gradle-download-url']
end

#
# TODO: Assign name of gradle folder to variable.
# See: http://stackoverflow.com/questions/17082791/chef-how-to-get-the-output-of-a-command-to-a-ruby-variable
#      https://github.com/chef/mixlib-shellout
#
bash "install gradle" do
  code <<-EOH
    unzip #{gradle_archive} -d #{gradle_install_dir}
    EOH
  not_if { ::File.exists?("#{gradle_install_dir}/gradle-2.3") }
end

#
# Create link to gradle.
#
link "/usr/bin/gradle" do
  to "#{gradle_install_dir}/gradle-2.3/bin/gradle"
  not_if { ::File.exists?("/usr/bin/gradle") }
end