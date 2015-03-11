#
# Cookbook Name:: helloworld
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

log "Hello #{ENV['USER']}" do
  level :info
end
