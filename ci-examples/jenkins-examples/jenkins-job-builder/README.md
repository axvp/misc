## Jenkins Job Builder samples
The folder [samples](./samples) contains some examples for the usage of the [Jenkins-job-builder ](https://github.com/openstack-infra/jenkins-job-builder).

###Setup
In order to run the examples, you need to install the jenkins-job-builder as described [here](http://ci.openstack.org/jenkins-job-builder/#jenkins-job-builder).
Note that this may require the installation of the [Python package manager](https://pypi.python.org/pypi/pip). Additionally if the error

	No module named pbr.version


ocurrs. The [Python Build Reasonableness](http://docs.openstack.org/developer/pbr/) need to be installed.
Remember to set up a configuration file if you intend to upload the jobs to a jenkins server, as described [here](http://ci.openstack.org/jenkins-job-builder/installation.html#configuration-file).

### Samples
- The file [Sample1](./samples/sample1.yaml)  contains a very simple "hello world" style job defintion.
- The file [Sample2](./samples/sample2.yaml) along with the file [Defaults](./samples/defaults.yaml) contains a example for using [defaults](http://ci.openstack.org/jenkins-job-builder/definition.html#defaults) .
- The file [Sample3](./samples/sample3.yaml)  contains an example for a job that cloens a git reposiotry .
- The file [Sample4](./samples/sample4.yaml)  contains an example for using [marcros](http://ci.openstack.org/jenkins-job-builder/definition.html#macro).
- Examples for using [templates](http://ci.openstack.org/jenkins-job-builder/definition.html#job-template)  can be found in the folder [template](./samples/templates). 

To test or run the examples use the jenkins job builder use the following commands:

	jenkins-jobs test ./sample1.yaml 
or

	jenkins-jobs update ./sample1.yaml 

where the name of the file is the sample you wish to run. Note that for the examples that reference other yaml files, like defaults or templates the whole directory needs to be included, or the files to use have to be selected as described [here](http://ci.openstack.org/jenkins-job-builder/installation.html#running). 