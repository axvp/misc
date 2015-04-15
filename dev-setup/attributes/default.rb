# Details of the java version to install
default['java']['install_flavor'] = 'oracle'
default['java']['jdk_version'] = 8 
default['java']['set_etc_environment'] = true
default['java']['set_default'] = true
default['java']['oracle']['accept_oracle_download_terms'] = true

# Details for the maven version to install
default['maven']['version'] = 3
default['maven']['setup_bin'] = true

# Details of the eclipse version to install
default['dev-setup']['eclipse-download-url']= 'https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz&r=1'