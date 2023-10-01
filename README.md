# Task Manager Application

The Task Manager Application is a simple task and note management system designed to help users keep track of tasks and associated notes.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [API Documentation](#api-documentation)
  - [Task Endpoints](#task-endpoints)
  - [Notes Endpoints](#notes-endpoints)
- [Usage Examples](#usage-examples)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, view, update, and delete tasks.
- Add and view notes associated with tasks.
- Simple and intuitive RESTful APIs.
- Easy integration with other applications.

## Technologies Used

- Java
- Spring Boot
- RESTful API
- Lombok
- ModelMapper

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (e.g., OpenJDK 11).
- Gradle or Maven for building and managing dependencies.
- Your preferred integrated development environment (IDE), such as IntelliJ IDEA or Eclipse.

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/your-username/task-manager.git


## API Documentation

The Task Manager Application provides the following APIs for managing tasks and notes.

### Task Endpoints

- **GET /task**: Retrieve a list of all tasks.
- **GET /task/{id}**: Retrieve a specific task by its ID.
- **POST /task**: Create a new task.
- **PUT /task/{id}**: Update an existing task by its ID.

### Notes Endpoints

- **GET /tasks/{taskId}/notes**: Retrieve a list of notes associated with a specific task.
- **POST /tasks/{taskId}/notes**: Create a new note associated with a specific task.

## Usage Examples

Here are some examples of how to use the APIs:

### Create a New Task

```http
POST /task
Content-Type: application/json

{
  "title": "Complete Project Report",
  "desc": "Write a detailed project report for the task manager project.",
  "deadline": "2023-12-31"
}
```
### Update an Existing Task

To update an existing task, send a `PUT` request to the following endpoint:


Replace `{id}` with the ID of the task you want to update.

#### Request

```http
PUT /task/1
Content-Type: application/json

{
  "desc": "Write a detailed project report for the task manager project by October 15, 2023.",
  "deadline": "2023-10-15",
  "status": true
}
```

### Create a New Note for a Task

To create a new note associated with a specific task, send a `POST` request to the following endpoint:


Replace `{taskId}` with the ID of the task to which you want to add the note.

#### Request

```http
POST /tasks/1/notes
Content-Type: application/json

{
  "title": "Research",
  "body": "Conduct research on project management best practices."
}
```

###Response

The API will respond with a CreateNoteResponseDTO object that includes details of the created note and the associated task ID. The HTTP status will be 200 OK if the creation is successful.

Example response:
```http
{
  "taskId": 1,
  "note": {
    "id": 1,
    "title": "Research",
    "body": "Conduct research on project management best practices."
  }
}
```


