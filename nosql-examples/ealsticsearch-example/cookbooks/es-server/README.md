## Elastic search server installation
This cookbook installs:

- Elastic search
- Mysql
- Add sample mysql database
- Elastic serach river jdbc

In order to start a river from the database run the command:

	curl -XPUT 'localhost:9200/_river/my_jdbc_river/_meta' -d '{
    	"type" : "jdbc",
    	"jdbc" : {
        	"url" : "jdbc:mysql://localhost:3308/classicmodels",
        	"user" : "root",
        	"password" : "yolo",
        	"sql" : "select * from orders"
        }
	}'

To see the search results use:

	curl 'localhost:9200/jdbc/_search'


See also [here](https://github.com/jprante/elasticsearch-river-jdbc)

