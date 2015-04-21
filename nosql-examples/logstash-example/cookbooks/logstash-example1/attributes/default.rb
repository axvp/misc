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
