directory "/data" do
  owner 'root'
  group 'root'
  mode '0755'
  action :create
end

node.set['mysql']['server_root_password'] = 'yolo'
node.set['mysql']['port'] = '3308'
node.set['mysql']['data_dir'] = '/data'

include_recipe 'mysql::server'
include_recipe 'mysql::client'
