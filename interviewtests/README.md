SELENIUM CORE FRAMEWORK
-------

A Web Driver based Automation Framework using Selenium and Page Factory model


Importing the core framework as a Jar for Automation development:
----------------------------------------------------------

1. Make sure your project falls under maven org.
2. Add the following Maven dependency information in your pom.xml file 
   [TODO : Update the link]
3. Folder structure:
   i) Create a folder resource parallel to src folder
   ii) Create the following folders
      a. resources -> testng -- to hold the testng xml files
      b. resources -> drivers -- to hold browser executable files
4. Extend BaseTest class for all your test classes and BasePage class for all your page factory classes.



Executing TestNG as a Java Program:
-----------------------------------
The following set-up helps to transform a TestNG xml file into a TestNG Java file. This is particularly useful when the tests need to be run as an executable JAR file in a machine without eclipse / maven installed.

The detailed documentation can be found in: http://testng.org/doc/documentation-main.html#running-testng-programmatically

