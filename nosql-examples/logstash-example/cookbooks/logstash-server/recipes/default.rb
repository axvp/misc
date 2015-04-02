#
# Cookbook Name:: logstash-server
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
include_recipe "logstash-server::set-proxy"
include_recipe "java::default"
include_recipe "java::default_java_symlink"
include_recipe "logstash-server::install-logstash"
include_recipe "logstash-server::install-elasticsearch"
include_recipe "logstash-server::install-httpd"
include_recipe "logstash-server::install-kibana"
include_recipe "logstash-server::configure-logstash"
