#
# Cookbook Name:: elasticsearch
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
include_recipe "es-server::set-proxy"
include_recipe "java::default"
include_recipe "java::default_java_symlink"
include_recipe "es-server::install-elasticsearch"

# Replace the plugin script with one that contains
# proxy settings.
template "/usr/share/elasticsearch/bin/plugin" do
  source "usr/share/elasticsearch/bin/plugin.erb"
  action :create
end

# Install mysql and the river plugin
include_recipe "es-server::install-mysql"
include_recipe "es-server::install-es-river-jdbc"

# Copy database installation file 
cookbook_file "mysqlsampledatabase.sql" do
  path "#{Chef::Config[:file_cache_path]}/mysqlsampledatabase.sql"
  action :create_if_missing
end

# Install sample database
execute "Installing sample database" do
   command "mysql -u root -p" + node['mysql']['server_root_password'] + " < " + "#{Chef::Config[:file_cache_path]}/mysqlsampledatabase.sql"
end

# Install river for sample db.
template "#{Chef::Config[:file_cache_path]}/createriver.sh" do
  source "createriver.sh.erb"
  mode "0755"
  action :create
end

# Wait for elastic serach to be ready
execute "wait foe elasticsearch" do
  command "sleep 20"
  action :run
end

bash "create river" do
  code "#{Chef::Config[:file_cache_path]}/createriver.sh"
end
