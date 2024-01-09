=======================================
Movie and TV Show Recommendation System
=======================================

This project is related to a movie and TV show recommendation system.

In summary, the project is a command-line-based movie and TV show recommendation system
where users can add favorites, view history, and give ratings. The system processes these
commands and generates logs as output. The code also includes utility methods for parsing
and handling data.

Commands:
I have created several classes to handle input data and organized them into a
"processors" package. Within this package, I added three classes that assist in parsing the
data and checking if the specified conditions are met. I verified each user individually
and then followed the specified requirements. I printed the messages into JSON files, adhering
to the given conditions.

Main.java:
-The main method serves as the entry point for the entire system.
-Initializes the necessary directories and files for testing and output.
-Iterates through input files, processes them using the action method,
and writes the results to output files.
-Invokes the Checker class for checking code style using Checkstyle.
Test.java:
-Designed for testing the program on a specific input file.
-Allows the user to input a filename and executes the action
method to process the specified input file.
-Enables focused testing and validation of the system's functionality on individual test cases.

The code is well-organized into classes and packages, promoting modularity and maintainability.
Utility methods in the Utils class streamline data parsing and transformation tasks.
The project includes features for testing individual input files and checking code style using
Checkstyle. Overall, it provides a flexible and extensible platform for managing and recommending
entertainment content.
