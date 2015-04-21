#
# Cookbook Name:: logstash-example1
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
include_recipe "logstash-example1::set-proxy"
include_recipe "java::default"
include_recipe "java::default_java_symlink"
include_recipe "logstash-example1::install-tomcat"
#include_recipe "logstash-example1::install-logstash"
#include_recipe "logstash-example1::install-elasticsearch"
#include_recipe "logstash-example1::install-httpd"
#include_recipe "logstash-example1::install-kibana"
