#
# Cookbook Name:: cheftutorial
# Recipe:: welcome
#
# Copyright 2015, jeeatwork.com
#
# All rights reserved - Do Not Redistribute
#
template "/tmp/simple.txt" do
  source "simple.txt.erb"
  mode '0440'
end


template "/tmp/simple2.txt" do
  source "simple2.txt.erb"
  variables({
    :recipe => node['recipes'][0],
    :ip => node['ipaddress'],
    :fqdn => node['fqdn']
  })
end

template "/tmp/simple3.txt" do
  source "simple3.txt.erb"
  variables({
    :recipe => node['recipes'][0],
    :ip => node['ipaddress'],
    :fqdn => node['fqdn']
  })
end
