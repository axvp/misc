#
# Cookbook Name:: elasticsearch
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
include_recipe "es-server::set-proxy"
include_recipe "java::default"
include_recipe "java::default_java_symlink"
include_recipe "elasticsearch::default"
include_recipe "es-server::install-mysql"
include_recipe "es-server::install-es-river-jdbc"
