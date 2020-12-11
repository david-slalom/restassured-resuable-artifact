# restassured-resuable-artifact
Quality Engineering Reusable Artifact

Fully Functional Test application with Get, Post and Put endpoints in the base controller. 

Rest Assured Tests follow an Abstract Implementation and use SpringBootRunner for running tests independently allowing for CI/CD Integration

Application uses the Spring framework and can be transpiled back into Java.

To initialize the project, change your directory to the RestAssured folder and run the following initialization script:
./startup.sh

This will install gradle into your machine, build the project, run the tests, then run the Application. 
IMPORTANT: Tests can only currently be ran when the application is off, in order to open the port. 
Tests will fail if the application is running concurrently. This will be addressed in a later release.

Kotlin Version.

Java Version Coming Soon. 

Written by David Michael Tompkins for use by Slalom Build. 
