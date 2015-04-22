#
# Download tomcat from apache web server.
#
# Url example: http://artfiles.org/apache.org/tomcat/tomcat-7/v7.0.61/bin/apache-tomcat-7.0.61.tar.gz
#
tomcatTarName = "#{Chef::Config[:file_cache_path]}/apache-tomcat-" + node['tomcat']['exact_version'] + ".tar.gz"
remote_file tomcatTarName do
    source "http://artfiles.org/apache.org/tomcat/tomcat-" + node['tomcat']['major_version'] + "/v" + node['tomcat']['exact_version'] + "/bin/apache-tomcat-" + node['tomcat']['exact_version'] + ".tar.gz"
    action :create
end

#
# Untar to target folder
#
execute "Unzipping #{tomcatTarName}" do
  command "tar -C {#node['tomcat']['install_folder']} -xzf {#tomcatTarName}"
end