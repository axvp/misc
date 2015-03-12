#
# Cookbook Name:: cheftutorial
# Recipe:: definitions-example
#
# Copyright 2015, jeeatwork.com
#
# All rights reserved - Do Not Redistribute
#
createfile "/tmp/definitonfile.txt" do
   path "/tmp/definitonfile.txt"
   content "Created using definitions"
end
