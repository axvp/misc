remote_file "#{Chef::Config[:file_cache_path]}/elasticsearch-" + node['elasticsearch']['version'] + ".noarch.rpm" do
    source "https://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-" + node['elasticsearch']['version'] + ".noarch.rpm"
    action :create
end

rpm_package "elasticsearch" do
    source "#{Chef::Config[:file_cache_path]}/elasticsearch-" + node['elasticsearch']['version'] + ".noarch.rpm"
    action :install
end

# Replace the plugin script with one that contains
# proxy settings.
template "/usr/share/elasticsearch/bin/plugin" do
  source "usr/share/elasticsearch/bin/plugin.erb"
  action :create
end

service "elasticsearch" do
   action :start
end

