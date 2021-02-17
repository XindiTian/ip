# User Guide

## Features 

### List
Lists the existing tasks that are in the list of tasks.
### Add Todo
Adds a task of type Todo into the list of tasks. 
### Add Event
Adds a task of type Event into the list of tasks with a time stamp for when the event occurs.
### Add Deadline
Adds a task of type Deadline into the list of tasks with a time stamp for when the deadline is due.
### Add After
Adds 2 tasks into the list of tasks such that when a specific task is marked as done, the dependent task is also done.
### Delete a Task
Deletes the specified task from the list of tasks.
### Mark as Done
Marks the specified task in the list of tasks as done.
### Find
Search for any tasks in the list of tasks that matches the keyword given.

## Usage

### List

#### Format: `list`

- Returns a list of the existing tasks in the task list.

#### Example of usage: 

`list`

#### Expected outcome:

> Here are the tasks in your list:
> 1. [T][ ] read book
> 2. [T][ ] return book



### Add Todo

#### Format: `todo <STRING>`

- Adds a task of type Todo into the list of tasks.
- `<STRING>` specifies the description of the todo to be added.

#### Example of usage:

`todo borrow book`

#### Expected outcome:

 > Got it. I've added this task:  
 > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [T][ ] borrow book  
 > Now you have 3 tasks in the list.


### Add Event

#### Format: `event <STRING> /at <DATE> <TIME>`

- Adds a task of type Event into the list of tasks.
- `<STRING>` specifies the description of the event to be added.
- `<DATE>` specifies the date that the event occurs.
    - `<DATE>` must be in the format YYYY-MM-DD.
- `<TIME>` specifies the time that the event occurs.
    - `<TIME>` must be in the format HH:mm

#### Example of usage:

`event go for lesson /at 2020-03-02 16:00`

#### Expected outcome:

> Got it. I've added this task:  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [E][ ] go for lesson (at: Mar 2 2020, 4PM)  
> Now you have 4 tasks in the list.


### Add Deadline

#### Format: `deadline <STRING> /by <DATE> <TIME>`

- Adds a task of type Deadline into the list of tasks.
- `<STRING>` specifies the description of the deadline to be added.
- `<DATE>` specifies the date that the deadline is due.
    - `<DATE>` must be in the format YYYY-MM-DD.
- `<TIME>` specifies the time that the deadline is due.
    - `<TIME>` must be in the format HH:mm

#### Example of usage:

`deadline submit assignment /at 2020-02-19 18:00`

#### Expected outcome:

> Got it. I've added this task:  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [D][ ] submit assignment (at: Feb 19 2020, 6PM)  
> Now you have 5 tasks in the list.


### Add After

#### Format: `<STRING> after <STRING2>`

- Adds 2 tasks, one of which is dependent on the other.
    - `<STRING2>` is dependent on `<STRING>` such that `<STRING2>` is done after `<STRING>`
- `<STRING>` specifies the description of the task to be added.
- `<STRING2>` specifies the description of the dependent task.

#### Example of usage:

`eat after lecture`

#### Expected outcome:

> Got it. I've added this task:  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [A][ ] eat (after: lecture)  
> Now you have 6 tasks in the list.


### Delete a Task

#### Format: `delete <INDEX>`

- deletes the task in the existing task list that corresponds to the `<INDEX>` specified.
- `<INDEX>` refers to the order which the task appears in the task list.

#### Example of usage:

`delete 1`

#### Expected outcome:

> Noted. I've removed this task:  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [T][ ] read book  
> Now you have 5 tasks in the list.


### Mark as Done

#### Format: `done <INDEX>`

- marks the task as done in the existing task list that corresponds to the `<INDEX>` specified.
- `<INDEX>` refers to the order which the task appears in the task list.

#### Example of usage:

`done 4`

#### Expected outcome:

> Nice! I've marked this task as done:  
> [E][X] go for lesson (at: Mar 2 2020, 4PM)


### Find

#### Format: `find <KEYWORD>`

- Returns the tasks in the existing list of tasks that matches the `<KEYWORD>` specified.  

#### Example of usage:

`find book`

#### Expected outcome:

> Here are the matching tasks in your list:  
> [T][ ] return book  
> [T][ ] borrow book

