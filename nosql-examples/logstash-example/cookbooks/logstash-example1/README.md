### Logstash example 1
This cookbook contains a [logstash](http://logstash.net/) example.
It demonstrates the usage of logstash for analysing [apache httpd](http://httpd.apache.org/) and [apache tomcat](http://tomcat.apache.org/) log files.

These two log files are pushed to an [elastic search](https://www.elastic.co/products/elasticsearch) instance and then analyzes using [kibana](https://www.elastic.co/products/kibana).

#### Usage
After running the cookbook, kibana should be accessible through the url 
After configuring the index pattern on the page initially displayed querying the log files should be possible in the *discover* perspective of kibana.

For more information about the setup see [this post](http://www.jeeatwork.com/?p=224).

#### Urls
The following list contains the urls and what they should display.

- 