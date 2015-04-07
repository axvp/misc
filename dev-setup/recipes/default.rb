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

remote_file "#{Chef::Config[:file_cache_path]}/eclipse.tar.gz" do
  source node['dev-setup']['eclipse-download-url']
end
