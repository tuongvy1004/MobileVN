BDD with serenity + cucumber 
====================
Requiremen
Firefox 
https://ftp.mozilla.org/pub/firefox/releases/44.0.2/
--------------------
* Tester shoulds have knowledge of gerkins and serenity 
* We need to install java
* We need to install maven
* We need to have a tomcat server
* We need to have a war file of application to be tested
* We need to deploy the Registration Course on tomcat server . The web application should be ready to used
Explaination of projects
--------------------
* All gerkins files are located at java-serenity-cucumber/src/test/resources/features/home
* All Scenario files are located java-serenity-cucumber/src/test/java/javaautomationcidemo/thucydides/cucumber/
* To manipulate the website (catch web elements , click button ) are located https://github.com/levunguyen/java-serenity-cucumber/blob/master/src/test/java/javaautomationcidemo/thucydides/cucumber/pages/
* All test report summary is located target folder

### Steps
* Step 1
clone the source code to your machine
* Step 2
Run the command mvn clean verify
* Step 3
You will see the browser open and automation is running

https://chromedriver.chromium.org/downloads