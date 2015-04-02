# Details of the java version to install
default['java']['install_flavor'] = 'oracle'
default['java']['jdk_version'] = 8 
default['java']['set_etc_environment'] = true
default['java']['set_default'] = true
default['java']['oracle']['accept_oracle_download_terms'] = true

# # Set proxies here if required
default['logstash-server']['all_proxy'] = nil 
default['logstash-server']['ftp_proxy'] = nil 
default['logstash-server']['http_proxy'] = nil 
default['logstash-server']['https_proxy'] = nil 
default['logstash-server']['no_proxy'] = nil 

# Version of elasticsearch to use
default['elasticsearch']['version'] = '1.5.0'

# Version of Kibana to usb
default['logstash-server']['kibana_version'] = '4.0.2' 

# TODO: Replace with namespace version
default['logstash-version'] = '1.4.2'
