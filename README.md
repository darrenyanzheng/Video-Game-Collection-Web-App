# github1
This is a dynamic web application built using Java. It uses MVC (Model, View, Controller) architecture which works to 
divide the application in three different, interconnected pieces as the view represents the interface for the user,
the model the abstract piece of data that is represented (a VideoGame), and the controller that serves to interpret
the request from the interface. 

The web app provides basic CRUD functionality (create, read, update, delete) through the use of Servlets that interpret
the HTTP requests provided from the interface, which is a Java Server Page (JSP). Tomcat Apache Server provides the 
server that supports both Servlets and JSP. 

Data is stored using the MySQL database, which is connected with our backend via the use of the Java Database Connectivity (JDBC), which is an API 
used to connect with database management systems. Access to modify contents within the database is put in another class (data access layer) to isolate the 
responsabilities of interacting with a database.
