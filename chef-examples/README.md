##Chef sample cookbooks

This folder contains some sample cookbooks.
To run the cookboks and recipes use the following commands:

	chef-client --local-mode --runlist "recipe[myfirstcookbook::default]"
	chef-apply recipes/default.rb 

	chef-client --local-mode --runlist "recipe[helloworld::default]"
	chef-apply recipes/default.rb
	
	chef-client --local-mode --runlist "recipe[cheftutorial::attribute-example]"
	chef-client --local-mode --runlist "recipe[cheftutorial::template-example]"
Please note that the cookbooks / recipes are run against the local node.
