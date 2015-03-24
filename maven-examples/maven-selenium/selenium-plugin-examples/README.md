## Selenium plugin examples
This multi module maven project contains several examples for using [Selenium](http://www.seleniumhq.org/) , and the [Selenium maven plugin](http://mojo.codehaus.org/selenium-maven-plugin/):

- [Multipe Browsers](./multiple-browsers/README.md). This example shows a setup for using firefox and chrome simultaneously.
- [Multipe Instances](./multiple-instances/README.md). This example shows a setup for using multiple firefox instances on the same host.

### Version
Please note that the versions of selenium and the browsers installed must match. These examples haven been tested using the following combination:

- Selenium 2.44.0
- Firefox 33
- Chromedriver [2.14](http://chromedriver.storage.googleapis.com/index.html?path=2.14/) 

Note that chromedriver and firefox need to be installed on the host running the examples.
The chromedriver path needs to be set in the [pom](./pom.xml) like this:

	<systemProperties>
	  <webdriver.chrome.driver>/opt/google/chrome/chromedriver</webdriver.chrome.driver>
	</systemProperties>
If the firefox executable can not be found in the path it might be necessary to set the path to the executable [like this](http://stackoverflow.com/questions/20950748/cannot-find-firefox-binary-in-path-make-sure-firefox-is-installed),