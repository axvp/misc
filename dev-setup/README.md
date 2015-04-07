##dev-setup Cookbook
A simple coobook for setting up a development environment on my local computer.

In order to use the coobook with [chef-client in local mode](http://docs.chef.io/ctl_chef_client.html#run-in-local-mode) follow these steps:

- In the [Berksfile](./Berksfile) assign all dependencies to the group **solos**:

	cookbook 'yum', '~> 3.5.3', group: 'solo'
	cookbook 'java', '~> 1.31.0', group: 'solo'

- Run berks vendor with including this group:

	berks vendor --only solo

- Then run chef-client as follows:

	chef-client -c $PWD/client.rb --local-mode --runlist "recipe[dev-setup::default]"

### Things that are installed
- Java
- Maven
- Eclipse
- Eclipse Plugins:
	- Explorer
	- PMD