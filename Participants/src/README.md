# Participants
The goal of this project is to create a simple GUI form that allows users to reserve a time slot. It should feature a log to show what has happened or to show error messages and a live updated list of all participants.

## Requirements
* Add participants (and save it in a data structure)
* Show participants (name + time) in the text box
* Check for wrong inputs and display warnings accordingly
* Write clear comments for the classes, methods and functions
* Divide your code into classes and explain briefly why it needs to be a separate class
* Code has to be visible on GitHub and be updated daily

## Task List
- [x] Prepare (watch tutorial videos)
- [x] Create repository on GitHub
- [x] Add participants (and save it in a data structure)
- [x] Show participants (name + time) in the text box
- [x] Check for wrong inputs and display warnings accordingly
- [x] Reset the form after each added participant
- [x] Empty an input field when the user selects that field
- [x] Add explanation why my class needs to be separate

## Strategy and decisions
After reading the assignment and reading or watching all materials in the assignment, I started working on the layout of the form. With the Swing UI designer it was pretty easy to click-and-drag the components to the correct location and alter their most important properties like width and height.

The first challenge was to make sure the spinners would have the correct bounds. With the CreateUIComponents you can make new components or override existing ones. Here we redefine our spinners with the correct bounds for hours and minutes.

When creating the layout I first used JFormattedTextFields, because those sounded logical. I probably wanted to format my text before displaying it. But I never got it to work: it never accepted the `\n` so all text would be on one line. I also couldn't get the text to be aligned to the top of the box. Eventually I switched to using TextArea's which were easily modified to fit my needs.

Now it was time for the button to work properly. I had already played with it to show a message when clicked, but now it had to show the correct messages. Log messages would go in the top text box, added participants in the bottom text box. This was quite straightforward, creating formatted strings and appending them to the text box.

Visually, the project was done after finishing the buttons. But in reality, you would like to save your participants somewhere. The next step would be to save them in a data structure.

I chose to save them in a ArrayList, because that allows for the array to grow with each participant, instead of being a fixed length. I had not yet used this data type before, but the difference between regular Arrays and ArrayLists is not enormous. With the help of documentation I was able to find the correct methods.

For this I created two classes. The Participant class would help me to make each new participant, while the Participants (plural!) class contains the ArrayList. It has methods to add a participant to the ArrayList. There are some debug functions to keep track of the data in the terminal.

To make the form more user-friendly I added functionality to reset the form after each added participant and to empty the value when selected. The default behaviour of the spinners was annoying as the zero stayed in place. So when you use `TAB` to get into the next field and try to type `15`, you would actually type `150`.
