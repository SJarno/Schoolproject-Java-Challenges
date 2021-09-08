# Challenge VIII - Numbers to String
## About
## Assignment
### Stage 1.
Make a method that transforms numbers in string to string representations. The modifidable is passed as a parameter from another class, and the method returns the result back to the calling class.

Example:
Original text: "Mister Huu's address is tattisuonkatu 4 A 123".

Modified text/result: "Mister Huu's addres is tattisuonkatu neljä A satakaksikymmentäkolme".

### Stage 2.
Refactor the method so that the program reads the original text from a textfile.
### Stage 3 (optional)
Refactor the program so that it saves the modified thext to a textfile.
## Features
A Maven project, added dependancy for StringUtils.
## Updates
### Update 1
So I did extensive tests while buildin up the actual method that changes integer values to word representations. I probably overdid myself pretty badly here, but I figured that I would need a decent hashmap or something to compare the output against. So little by little I overwrote the test, overwrote the method, wrote the test cleaner, and so on.
This is probably something to be avoides, but thats how I did. 
Next step is to build the actual class that handles file reading and the integer converting. And some more tests for that.
## Other
[< Challenge seven](../../Haaste7/challengeseven)

[<< Back to root](https://github.com/SJarno/Schoolproject-Java-Challenges)
