#
# Cookbook Name:: logstash-example1
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

remote_file "#{Chef::Config[:file_cache_path]}/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64.tar.gz" do
  source "https://download.elasticsearch.org/kibana/kibana/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64.tar.gz"
end

# Extract tar
# Better way: https://github.com/gofullstack/tar-cookbook
execute "Unzipping kibnan" do
  command "tar -C /opt -xzf " + "#{Chef::Config[:file_cache_path]}/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64.tar.gz"
end

directory "/opt/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64" do
  owner "root"
  group "root"
  recursive true
end

log "/opt/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64" do
  level :info
end

execute "Waiting for elasticsearch" do
  command "sleep 10"
end


# TODO: Start kibana as a service
bash 'start kibana' do
  user 'root'
  cwd "/opt/kibana-" + node['logstash-example1']['kibana_version'] + "-linux-x64"
  code <<-EOH
  /opt/kibana-4.0.2-linux-x64/bin/kibana > kibana.log 2>&1 &
  EOH
end
