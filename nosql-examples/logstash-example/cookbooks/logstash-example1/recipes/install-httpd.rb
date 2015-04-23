httpd_service 'default' do
  action [:create]
end 

#
# Install mod jk
#
# Using wget because of proxy problems when using remote_file
#
modjk_rpm = "#{Chef::Config[:file_cache_path]}/" + node['mod_jk']['filename']

execute "Downloading #{node['mod_jk']['filename']}" do
   cwd Chef::Config[:file_cache_path]
   command "wget #{node['mod_jk']['download_url']}"
   not_if { ::File.exists?("#{modjk_rpm}")}
end

rpm_package modjk_rpm do
  action :install
end