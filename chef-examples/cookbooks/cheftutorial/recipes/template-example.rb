#
# Cookbook Name:: cheftutorial
# Recipe:: welcome
#
# Copyright 2015, jeeatwork.com
#
# All rights reserved - Do Not Redistribute
#
template "/tmp/simple.txt" do
  source "simple.erb"
  mode '0440'
end
