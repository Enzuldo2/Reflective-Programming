# Reflective-Programming. What is it?
Reflective programming is a specific type of metaprogramming that refers to the ability of a program to function and modify its own structure and behavior at runtime. In other words, it is an ability for a program to examine and change its own behavior or data structure while it is running.


# My Exemples
Framework-Persistence is a framework that inserts and loads any object into the database using reflective programming.
It retrieves from the program itself the information it needs. I used MySQL in this case, but you can use any database you want.

In the file named "Reflixibilidade", I wrote code that uses annotations and reflective programming to gather class information and calculate the LCOO (Lack of Cohesion in Operations) metric.
The user only needs to annotate the methods and constructors with the attributes they use. Then, by running the main method, the code will display the LCOO.
The code is located in the LCOO package.
