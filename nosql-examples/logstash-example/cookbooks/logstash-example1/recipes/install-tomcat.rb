#
# Download tomcat from apache web server.
#
# Url example: http://artfiles.org/apache.org/tomcat/tomcat-7/v7.0.61/bin/apache-tomcat-7.0.61.tar.gz
#
tomcatTarName = "#{Chef::Config[:file_cache_path]}/apache-tomcat-" + node['tomcat']['exact_version'] + ".tar.gz"
tomcatTargetDir = "#{node['tomcat']['install_folder']}/apache-tomcat-#{node['tomcat']['exact_version']}"
remote_file tomcatTarName do
    source "http://artfiles.org/apache.org/tomcat/tomcat-" + node['tomcat']['major_version'] + "/v" + node['tomcat']['exact_version'] + "/bin/apache-tomcat-" + node['tomcat']['exact_version'] + ".tar.gz"
    action :create
end

#
# Untar to target folder
#
execute "Unzipping #{tomcatTarName}" do
  command "tar -C #{node['tomcat']['install_folder']} -xzf #{tomcatTarName}"
  not_if { ::File.exists?("tomcatTargetDir") }
end

#
# Template code from: https://github.com/opscode-cookbooks/tomcat/blob/master/providers/instance.rb
#
template "#{tomcatTargetDir}/conf/server.xml" do
source 'server.xml.erb'
  variables ({
    :port => node['tomcat']['port'],
    :proxy_port => node['tomcat']['proxy_port'],
    :ssl_port => node['tomcat']['ssl_port'],
    :ajp_port => node['tomcat']['ajp_port'],
    :shutdown_port => node['tomcat']['shutdown_port'],
    :max_threads => node['tomcat']['max_threads'],
    :write_access_log => node['tomcat']['write_access_log'],
    :access_log_pattern => node['tomcat']['access_log_pattern']
  })
  owner 'root'
  group 'root'
  mode '0644'
end

#
# https://github.com/opscode-cookbooks/tomcat/blob/master/recipes/users.rb
#
template "#{tomcatTargetDir}/conf/tomcat-users.xml" do
  source 'tomcat-users.xml.erb'
  variables(
    :users => node['tomcat']['users'],
    :roles => node['tomcat']['roles']
  )
  owner 'root'
  group 'root'
  mode '0644'
end

#
# Start tomcat
#
execute "Starting tomcat" do
  command "#{tomcatTargetDir}/bin/catalina.sh start"
  not_if "/sbin/fuser #{node['tomcat']['port']}/tcp"
end