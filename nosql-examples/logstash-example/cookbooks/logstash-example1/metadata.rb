name             'logstash-example1'
maintainer       'YOUR_COMPANY_NAME'
maintainer_email 'YOUR_EMAIL'
license          'All rights reserved'
description      'Installs/Configures logstash-example1'
long_description IO.read(File.join(File.dirname(__FILE__), 'README.md'))
version          '0.1.0'

depends          'magic_shell'
depends          'yum'
depends          'java'
depends          'httpd'
depends          'selinux'
