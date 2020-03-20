# Creating Community Small Groups

_**You should erase this the text below as you fill it up with your own text**_

Here you will describe your term project. Remember to write your names.
[More detailed instructions here](SmallGroups-Graph.pdf)

You will need to include in this repository:
- `group1.txt` a file with 16 names
- `group2.txt` a file with 29 names
- `group3.txt` a file with 34 names
- The source code of your program

This document should be organized as follows:

# Creating Community Small Groups
A work by: Issah Mathno and Trent Howell

Small groups are a staple of many churches aroung the globe, however disputes always seem to surface over the structure and scheduling of these meetings.
So what if a more automated system existed that can schedule these groups with a particular criteria in mind? *write an introduction to your project*

## Description
Our project is about creating a schedule of small groups that ensures that every person in the system visits everyone else's house who is in the system. By creating a list of lists of small groupings we can perfectly distribute the load of hosting responsibilities to every person in the small group system. We decided to implement our solution using Java and the jgrapht graph implementation.
*Describe what your project is about and what language you used*

## Requirements
*The requirements of the program, i.e. Python 3.1, what libraries are needed*

## User Manual
*Once a person clones this into their computer how the person is supposed to run the program, add screenshots showing how your program works, also add here the link to the Youtube video showing the program running*
Start the program by working your way to the project file and running the program jar, should look something like this
*screenshot showing jar*
Once the program is running you can run any of the three default cases included in the program by selecting the appropriate button. For instance Run Group 1 will execute on the group1.txt located in the data folder.
*screenshot showing the Group 1 button being hovered over by the mouse*
You can also change the number of people per small group generated with the dropdown menu, there are four settings to choose from allowing for groups of 3,4,5,or 6 people respectfully.
*screenshot showing the dropdown menu*
Finally you can run the program on your own custom text file, to start out create your text file so that it has the following format. Each line contains a new name, if you want to add a married couple place their names on the same line with only a comma seperating them (WARNING if you place more than two people in a marriage the program will likely not work properly). 
*screenshot showing a valid data file called test*
Once you have created your custom text file with the aforementioned format you should place it inside of the projects data folder where the other group text files are located.
*screenshot showing the test custom file inside of the data folder*
Then you can run your custom group by typing the file name including .txt at the end into the text field at the far left of the GUI. Once you have done that press the Run Custom Group button and the program will execute on your custom group file.
*screenshot showing test.txt in the text field and the mouse hovering over the run custom group button*
If you enter an invalid filename or delete one of the default case files and attempt to execute an error will pop up telling you that the file was not found, restore the default case, or ensure you are using the correct custom name to proceed.
*screenshot showing ThrowAnError in the text field, the mouse over the custom button, and the pop up error.*
After successful execution inside of the data folder a file will appear, or be ammended called groupSchedule.txt. This file will contain a list of groupings of the people entered in order to satisfy the criteria that everyone visits everyone elses house.
*screenshot showing the aforementioned file, and then another showing the contents of that file*
When you are finished with the program simply press the X at the top right of the GUI and the program will exit.
*screenshot showing the mouse hovering over the X*
Thank you for running our community small groups program.
After executing on your 


## Reflection
*Write the reflection about getting the small groups in the minimum number of iterations, etc.*


