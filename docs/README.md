# 9527 User Guide
9527 is a chat bot that help you **manage your task in Command Line Interface** (CLI). Your task data would be saved in a `txt` file.
## Quick Start
1. Ensure you have Java 17 installed.
2. Make sure you are in the directory of the `.jar` file.
3. Open a command terminal, and `cd` to this directory.
4. Run `java -jar ip.jar` to start the chat bot.
## Features
> [!TIP]
> - Words in `UPPER_CASE` are parameters to be supplied by the user.
> 
> - `/...` is a flag to indicate different parameters.<br>
    e.g. `/name` indicates the parameter is a name or description of the task
>   
> - Parameters need not follow their order listed below.
>
> - Parameters must not be empty

There are three types of task, namely, `todo`, `deadline`, and `event`.

### Adding a todo task: `todo`
Adds a todo task to the task list.

Format: `todo /name NAME`

Examples:
- `todo /name laundry`
- `todo /name homework`

### Adding a deadline task: `deadline`
Adds a deadline task to the task list.

Format: `deadline /name NAME /by DEADLINE`

Examples:
- `deadline /name assignment /by tmr`
- `deadline /name report /by 2026-05-05`

### Adding an event task: `event`
Adds an event task to the task list.

Format: `event /name NAME /from START_TIME /to END_TIME`

Examples:
- event /name Party /from 3pm /to 4pm
- event /name Meeting /from now /to tmr

### Listing all tasks: `list`
Lists all the tasks in the CLI.

Format: `list`

### Marking as done: `mark`
Marks a task with a specific index as done.

Format: `mark INDEX`
- `INDEX` must be an integer

Example:
- `mark 2` Marks the second task in the task list as done.

### Unmarking as not done: `unmark`
Unmarks a task with a specific index as not done.

Format: `unmark INDEX`
- `INDEX` must be an integer

Example:
- `unmark 2` Unmarks the second task in the task list as not done.

### Deleting a task: `delete`
Deletes a task with a specific index from the task list.

Format: `delete INDEX`
- `INDEX` must be an integer

Example:
- `delete 2` Deletes the second task from the task list.

### Finding a task: `find`
Finds all tasks with descriptions containing the given keyword.

Format: `find KEYWORD`

Example:
- `find homework`

### Saving data and exiting the app: `bye`
Saves the task list into a `txt` file located in `./data` and exits the app.

Format: `bye`

### Editing the data file
The task list is saved into a `txt` file.
The formats of each type of task are as follow:
- `todo`: `T | is_done | description`
- `deadline`: `D | is_done | description | deadline`
- `event`: `E | is_done | description | start_time | end_time`

`is_done` should be replaced by a string `true` or `false` in the actual file to indicate if the task is done

> [!CAUTION]
> If any lines, i.e. tasks, in the `txt` file do not follow the above format, 9527 will discard those lines and continue with the rest of recognizable lines.<br>
A message of which lines are affected would be displayed.
