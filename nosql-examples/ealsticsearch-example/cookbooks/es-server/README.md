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
         "sql" : "select products.productName as \"name\", products.buyPrice as \"buyPrice\", products.productDescription as \"description\" from products"
       }
	}'

To see the search results use:

	curl 'localhost:9200/jdbc/_search'

To delete all jdbc river indexes use the following command:

	curl -XDELETE 'localhost:9200/_all'

See also [here](https://github.com/jprante/elasticsearch-river-jdbc)

In order to use this example with a more advanced gui you may use
