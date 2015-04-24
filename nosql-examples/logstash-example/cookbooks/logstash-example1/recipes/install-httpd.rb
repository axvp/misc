httpd_service node['httpd']['config_name'] do
  listen_ports ['8888']
  action [:create]
end 

httpd_config 'logging' do
  source 'logging.cnf.erb'
  action :create
end

#
# Install mod jk
#
# Using wget because of proxy problems when using remote_file
#
modjk_rpm = "#{Chef::Config[:file_cache_path]}/" + node['mod_jk']['filename']

cookbook_file node['mod_jk']['filename'] do
  path modjk_rpm
  action :create_if_missing
end

rpm_package modjk_rpm do
  action :install
end

template node['httpd']['worker_properties_location'] do
  source 'worker.properties.erb'
    variables ({
      :ajp_port => node['tomcat']['ajp_port']
    })
  owner 'root'
  group 'root'
  mode '0644'
end

#
# Configure mod_jk
#
httpd_config 'mod_jk' do
  source 'mod_jk.erb'
  variables ({
    :worker_properties_location => node['httpd']['worker_properties_location'],
    :config_name => node['httpd']['config_name']
  })
  action :create
end

httpd_service node['httpd']['config_name'] do
  action [:start]
end 