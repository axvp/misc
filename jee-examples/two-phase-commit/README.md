# Two-phase-commit
This is a simple example for a two phase commit. They illustrate how the [two phase commit protocol](http://en.wikipedia.org/wiki/Two-phase_commit_protocol) is working with the various types of jee components.
These example include:

- A [session bean](http://docs.oracle.com/javaee/6/tutorial/doc/gipjg.html) that writes to a database as part of a [containenr managed transaction](http://docs.oracle.com/javaee/6/tutorial/doc/bncij.html). The transaction is aborted by an exception thrown in the session bean's method before it completes. It is expected that the changes to the database have been rolled back
- Two session beans writting to two different databases enclosed in single transaction. Those two beans are used in a thrid [session facade](http://www.corej2eepatterns.com/SessionFacade.htm) bean that encloses the calls to the two session beans in a transaction. While invoking the second session bean an exception is thrown. It is expected that the changes the first session bean made to the underlying database are rolled back as well.
- A session bean and a [jms target](http://docs.oracle.com/javaee/6/tutorial/doc/bncgl.html). A mesage is sent to the jms desination and then a second session bean is called, that writes a record into the database. At the end of the method an exception is thrown. It is expected that both, the database update as well as the jms message have been rolled back.	

All the examples are derived from the [tomme jee examples](https://tomee.apache.org/examples-trunk/).