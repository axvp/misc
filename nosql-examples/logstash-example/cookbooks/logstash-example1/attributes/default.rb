# Details of the java version to install
default['java']['install_flavor'] = 'oracle'
default['java']['jdk_version'] = 8 
default['java']['set_etc_environment'] = true
default['java']['set_default'] = true
default['java']['oracle']['accept_oracle_download_terms'] = true

# # Set proxies here if required
default['logstash-example1']['all_proxy'] = nil 
default['logstash-exymple1']['ftp_proxy'] = nil 
default['logstash-example1']['http_proxy'] = nil 
default['logstash-example1']['https_proxy'] = nil 
default['logstash-example1']['no_proxy'] = nil 

# Version of elasticsearch to use
default['elasticsearch']['version'] = '1.5.0'

# Version of Kibana to usb
default['logstash-example1']['kibana_version'] = '4.0.2' 

# TODO: Replace with namespace version
default['logstash-version'] = '1.4.2'

# Version of tomcat to use
default['tomcat']['major_version'] = '7'
default['tomcat']['exact_version'] = '7.0.61'
default['tomcat']['install_folder'] = '/opt'
default['tomcat']['shutdown_port'] = '8005'
default['tomcat']['port'] = '8889'
default['tomcat']['proxy_port'] = nil
default['tomcat']['ssl_port'] = '8443'
default['tomcat']['ajp_port'] = '8009'
default['tomcat']['max_threads'] = nil

# Parameters for tomcat access log
default['tomcat']['write_access_log'] = false
default['tomcat']['access_log_pattern'] = '%h %l %u %t &quot;%r&quot; %s %b'

# Attribues for tomcat roles
default['tomcat']['roles'] = ['manager-gui', 'admin-gui']
default['tomcat']['users'] = [{'id' => 'admin', 'password' => 'admin', 'roles' => ['manager-gui', 'admin	-gui']}]

# Mod jk download url.
default['mod_jk']['filename'] = "apache2-mod_jk-1.2.37-4.1.x86_64.rpm"
default['mod_jk']['download_url'] = "ftp://ftp.pbone.net/mirror/ftp5.gwdg.de/pub/opensuse/repositories/home:/adesso/CentOS_CentOS-6/x86_64/#{node['mod_jk']['filename']}"