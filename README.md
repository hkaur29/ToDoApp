# ToDoApp
Spring boot: For Rapid application development using spring boot starter as it can leverage Autoconfiguration and dependency management over a typical spring
project for the scope of this application.

 Rest Apis: for exposing the functionality for creating, viewing, updating, and deleting tasks.
 
Spring Security + JWT: to provide user-based authentication for login and sending bearer token in each subsequent request. 
(For the purpose of this app, I have provided in memory hard coded user as suggested -> username = test, password= test)
JWT make use of tokens and not passwords. Tokens are uniquely generated per application and valid for only a particular amount of time.
unlike basic authentication where we send the username and password encrypted which could be prone to attacks.

HSQL: in memory database to store the data for tasks.

Global Exception Handler: used Controller Advice for providing global Exception handling for all controller exceptions.
