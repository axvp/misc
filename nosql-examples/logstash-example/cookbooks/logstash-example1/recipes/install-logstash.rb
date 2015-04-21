#
# Cookbook Name:: logstash-server
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

remote_file "#{Chef::Config[:file_cache_path]}/logstash-" + node['logstash-version'] + ".tar.gz" do
  source "https://download.elasticsearch.org/logstash/logstash/logstash-" + node['logstash-version'] + ".tar.gz"
end

# Extract tar
# Better way: https://github.com/gofullstack/tar-cookbook
execute "Unzipping logstash" do
  command "tar -C /opt -xzf " + "#{Chef::Config[:file_cache_path]}/logstash-" + node['logstash-version'] + ".tar.gz"
end

directory "/opt/logstash-" + node['logstash-version'] do
  owner "root"
  group "root"
  recursive true
end
