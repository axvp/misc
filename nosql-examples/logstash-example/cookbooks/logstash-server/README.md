logstash-server Cookbook
========================
A simple cookbook for demonstrating the [ELK stack](https://www.elastic.co/webinars/elk-stack-devops-environment).

The image is configured using port forwarding.

To access elastic serch use the url

[http://localhost:9200/](http://localhost:9200/) 

To see a list of indexes in elasticserch use the url

[http://localhost:9200/_aliases?pretty=1](http://localhost:9200/_aliases?pretty=1) 

If no logstash index is displayed this might indicated that the logstash process has not been started correctly. See [recipes/configure-logstash.rb](recipes/configure-logstash.rb) 

To access kibana use the url

[http://localhost:5601/](http://localhost:5601/) 

If everything is running correctly the logstash index should be displayed.

For the time being only [httpd](http://httpd.apache.org/docs/2.2/programs/httpd.html)  is installed and the log files should be send to elastic search via logstash. Note that because of port number restrictions the port 80 has been forwarted to 8888. Thus httpd is accessible using the url

[http://localhost:8888/](http://localhost:8888/) 

If everything worked out correctly you should see two indices after accessing httpd for the first time:

	health status index               pri rep docs.count docs.deleted store.size pri.store.size 
	yellow open   logstash-2015.04.20   5   1          4            0     31.2kb         31.2kb 
	yellow open   .kibana               1   1          1            0      2.4kb          2.4kb 


when going to the url 

[http://localhost:9200/_cat/indices?v](http://localhost:9200/_cat/indices?v) 

Likewise the list of indices should then be:

	{
	  "logstash-2015.04.20" : {
	    "aliases" : { }
	  },
	  ".kibana" : {
	    "aliases" : { }
	  }
	}

In Kibana you still have to configure the index pattern for the logstash index

	logstash-*

Especially the time stamp index needs to be set. In this example it would be

	@timestamp

See the logstash coniguration file for details on how to set the format. In this example the following file has been used:

	input {
	  file {
	    path => "/var/log/httpd/access_log"
	    start_position => beginning
	  }
	}
	
	filter {
	  if [path] =~ "access" {
	    mutate { replace => { "type" => "apache_access" } } 
	    grok {
	      match => { "message" => "%{COMBINEDAPACHELOG}" }
	    }   
	  }
	  date {
	    match => [ "timestamp" , "dd/MMM/yyyy:HH:mm:ss Z" ]
	  }
	}
	
	output {
	  elasticsearch {
	    host => localhost
	  }
	  stdout { codec => rubydebug }
	}

See also [logstash config template](./templates/default/opt/logstash/logstash-apache.conf.erb) 