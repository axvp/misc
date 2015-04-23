httpd_service 'default' do
  action [:create]
end 

httpd_module 'ssl' do
  action :create
end

#
# Install mod jk
#
modjk_rpm = "#{Chef::Config[:file_cache_path]}/" + node['mod_jk']['filename']
remote_file modjk_rpm do
    source node['mod_jk']['download_url']
    action :create
end

rpm_package modjk_rpm do
  action :install
end