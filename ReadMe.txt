Framework:
This is a Java Selenium project.
Front end objects are identified using Selenium Webdriver and project is coded in Java.
Framework follows page object pattern of Selenium with Junit framework.
To make it easily configurable with any IDE and help for continuous integration, this automation project is created as a maven project.

Firefox version: 33.0 (User has to download and install this firefox browser)
Selenium version:2.45.0. (This will get installed automatically when you do the mvn clean install command in Terminal/CMD)

First time run:
1) Download the JavaSelenium folder
2) Download JDK and set JAVA_HOME
3) Verify by java -version
3) Download Maven and set MAVEN_HOME
4) Verify by mvn -version
5) Navigate to JavaSelenium folder
6) Run mvn clean install
7) If it is success, run mvn test or run by below instructions.

How to run a Test:
There are number of ways
Option 1) Open the project in Intellij, right click the classes ControlsTest or GaugeDisplayTest and click Run ControlsTest or Run GaugeDisplayTest
Option 2) Navigate to JavaSelenium in Terminal and run mvn test (I did not run this as I got some issues in my mac after OS upgrade.)
Option 3) Right click the test folder and Mark as Test sources root. Then right click the test folder and click Run All Tests