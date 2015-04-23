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

#
# Configure mod_jk
#
tomcat_mod_jk_conf = "#{node['tomcat']['install_folder']}/apache-tomcat-#{node['tomcat']['exact_version']}/conf/jk/mod_jk.conf-auto"
httpd_config 'mod_jk' do
  source 'mod_jk.erb'
  variables ({
    :tomcat_mod_jk_conf => tomcat_mod_jk_conf
  })
  action :create
end