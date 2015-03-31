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

In order to use this example with a more advanced gui you may use [Calaca](https://github.com/romansanchez/Calaca) for a start.

To see the detailed configuration of the elastic search server goto:

	http://localhost:9200/_nodes?settings=true&pretty=true
### Some facts about elastic serach

- It provides scalable search, has near real-time search (but not real time search)
- Elasticsearch can be used to search all kinds of documents
- Supports [multitenancy](http://en.wikipedia.org/wiki/Multitenancy) 
	- A single instance of a software runs on a server and serves multiple tenants. 
	- A tenant is a group of users who share a common access with specific privileges
	- Importang for [SaaS](http://en.wikipedia.org/wiki/Software_as_a_service)  (cloud computing)
	- Isolating information (data, customizations, etc) pertaining to the various tenants is a particular challenge in these systems
		- Virtual private database, separate databases, seperate schemas, discriminator
		- Hibernate supports [multi tenancy](http://docs.jboss.org/hibernate/orm/4.2/devguide/en-US/html/ch16.html) .
		- Attention when using connection pools which share a common user
		- Multitenant applications are typically required to provide a high degree of customization
			- Data model customization
			- Workflow