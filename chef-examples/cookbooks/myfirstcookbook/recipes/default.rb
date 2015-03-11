#
# Cookbook Name:: myfirstcookbook
# Recipe:: default
#
# Copyright 2015, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
ruby_block "greetings" do
  block do
	puts " \"Congratulations on running your first cookbook !\""
  end
end
