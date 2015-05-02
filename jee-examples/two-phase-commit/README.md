# Two-phase-commit
This is a simple example for a two phase commit. They illustrate how the [two phase commit protocol](http://en.wikipedia.org/wiki/Two-phase_commit_protocol) is working with the various types of jee components.
These example include:

- A session bean that writes to a database as part of a transaction
- Two session beans writting to two different databases enclosed in single transaction