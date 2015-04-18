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

bash 'install eclipse' do
  code <<-EOH
    tar xzf #{eclipse_archive} -C #{eclipse_install_dir}
    EOH
  not_if { ::File.exists?("/opt/eclipse") }
end
