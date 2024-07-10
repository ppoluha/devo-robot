# Robot Movement Application

This application simulates a robot moving in a room based on given commands. The robot can turn left, turn right, and move forward. The application also checks if the robot goes out of bounds.

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

## Project Structure

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── se.hkr.robot
│   │   │       ├── Main.java
│   │   │       ├── Position.java
│   │   │       ├── Robot.java
│   │   │       ├── Room.java
│   │   │       └── OutOfBoundsException.java
│   └── test
│       ├── java
│       │      └─── RobotTest.java
├── pom.xml
└── README.md
```

## Instructions

### Clone the Repository

Clone the repository to your local machine using the following command:

```sh
git clone https://github.com/ppoluha/devo-robot
cd devo-robot
```

### Build the Project

Use Maven to build the project. Run the following command in the project root directory:

```sh
mvn clean install
```

### Running the Application

```sh
java -cp .\target\DevoRobot-1.0-SNAPSHOT.jar se.hkr.robot.Main
```

### Expected Input and Output

#### Input
```
5 5
1 2 N
RFRFFRFRF
```

#### Output
```
Report: 1 3 N
```

#### Error Handling
If an exception is thrown, the output will be:
```
ERROR: Out of bounds at [x] [y]
```

## Extra feature
The path of the robot as it moves is stored in a list which can be used for backtracing or repeating a sequence.
