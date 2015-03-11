#
# Cookbook Name:: cheftutorial
# Recipe:: file-example
#
# Copyright 2015, jeeatwork.com
#
# All rights reserved - Do Not Redistribute
#

cookbook_file "file.txt" do
  path "/tmp/file.txt"
  mode "644"
  action :create
end
