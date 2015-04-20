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
