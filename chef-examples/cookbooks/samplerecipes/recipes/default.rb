#
# Cookbook Name:: samplerecipes
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#

execute 'cat-file-if-exists' do
  command 'echo /etc/passwd exists'
  action :run
  only_if do File.exists?('/etc/passwd') end
end

if platform?("redhat", "centos", "fedora")
  log "platform is red hat family"
end