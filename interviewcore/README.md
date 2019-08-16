SELENIUM CORE FRAMEWORK
-------

A Web Driver based Automation Framework using Selenium and Page Factory model

Local setup steps:
------------------

1. Make sure you have Java version 7 (JDK) or above installed in your machine.
2. Download eclipse [https://eclipse.org/downloads/].
3. Setup TestNG in eclipse [http://goo.gl/GleaWs].
4. Clone the core repo from here [https://github.com/dineshjk92/interview].
5. Open the eclipse in either new workspace or existing one.
6. Import the file project by navigating File->import and select Existing Maven Projects
7. Once the project is imported, verify the java compiler path is set to jdk (not to JRE) by following steps below.
   i) Project -> properties
   ii) Click on Java compiler
   iii) Click on Installed JRE's link
   iv) Verify that the path set is for jdk 1.7 or above, otherwise change the path and save.
8. Make sure that all the package names in the project starts with com.gogo.interview.core. If not, follow the steps given below.
   i) Project -> properties
  ii) Click on build path
 iii) Click on source tab
  iv) Click add folder, and check src box under interview.core. Remove the source folder, that was present earlier 
9. To download the dependencies
   i) Right click on the project module and select Run As -> Maven Install
  ii) Verify that build status is success. If not, restart eclipse and import the projects again.
 iii) Once it completed, right click on the project module and select Maven -> Update Project


