## Elastic search tutorial

This tutorial is based on [this](http://joelabrahamsson.com/elasticsearch-101/)  excellent introduction to using elastic search.

This tutorial primarily focues on indexing data in json format.
Indexes can be easily created by supplying the name and type of the index in the url, and the data to put in the json data:

	curl -XPUT "http://localhost:9200/movies/movie/1" -d'{
	    "title": "The Godfather",
	    "director": "Francis Ford Coppola",
	    "year": 1972 }'
Th example above creates an index called movies with type movie and adds the first movie to that index.

In order to "batch" insert multiple records elastic search offers the [bulk](http://www.elastic.co/guide/en/elasticsearch/reference/current/_batch_processing.html) statement. But there is [size limit per request](http://elasticsearch-users.115913.n3.nabble.com/Max-request-size-td3687861.html) .