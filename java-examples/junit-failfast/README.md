# JUnit Fail Fast
This folder contains a Maven project that includes an example on how to stop junit from testing after the first test failure occures (fail fast).

In order to do so a [RunListener](http://junit.sourceforge.net/javadoc/org/junit/runner/notification/RunListener.html) and a own [Runner](http://junit.sourceforge.net/javadoc/org/junit/runner/Runner.html) need to be implemted.

Sample implementations can be found [here](./src/test/java/com/jeeatwork/java/examples/junit/failfast/) along with a test case.

In order to test the exampls simply run

	mvn clean install

Note that the project has been configured to succeed even if test cases fail. The output of a *successful* run should looke something like this:

	Results :
	
	Tests in error: 
	  FailFastListenerTest.testB:29->testMethod:39->throwExceptionOnSecondTest:45 Runtime
	
	Tests run: 2, Failures: 0, Errors: 1, Skipped: 0
	
	[ERROR] There are test failures.

