# Details of the java version to install
default['java']['install_flavor'] = 'oracle'
default['java']['jdk_version'] = 8
default['java']['set_etc_environment'] = true
default['java']['set_default'] = true
default['java']['oracle']['accept_oracle_download_terms'] = true

# Set proxies here if required
default['es-server']['all_proxy'] = nil
default['es-server']['ftp_proxy'] = nil
default['es-server']['http_proxy'] = nil
default['es-server']['https_proxy'] = nil
default['es-server']['no_proxy'] = nil

# Version of elasticsearch to use
default['elasticsearch']['version'] = '1.5.0.0'

# Version of elasticsearch river jdbc to install
default['es-river-jdbc']['version'] = '1.5.0.0'
