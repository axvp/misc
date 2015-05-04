# Two phase commit example 2
This example contains two session beans writing to two different databases that are both transactional invoked by a session facade. There are several test cases, where the transaction is abored by a transaction at various points of the overall transaction.

This examples should demonstrate a working two phase commit.