#
# Cookbook Name:: cheftutorial
# Recipe:: welcome
#
# Copyright 2015, jeeatwork.com
#
# All rights reserved - Do Not Redistribute
#

log "Hello #{ENV['USER']}" do
  level :info
end

log "Hello #{node['cheftutorial']['name']}" do
  level :info
end
