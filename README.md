Football World Cup Score Board

Overview

This project is a simple library for managing a live Football World Cup Score Board. The scoreboard supports starting games, finishing games, updating scores, retrieving a summary of ongoing games sorted by their total scores, and displaying team rankings. The library is implemented using Java and Swing for a basic user interface to manage and display the games.

Features

Start a Game: Captures the home and away teams, initializing the score to 0-0.
Finish a Game: Removes a match from the scoreboard.
Update Score: Updates the score for a game based on the provided home and away scores.
Get a Summary of Games: Retrieves a list of ongoing games sorted by total score. Games with the same total score are ordered by the most recently added.
Project Structure
Display Team Rankings: Displays team rankings based on live scores and away goals.

com.sportradar.scoreboard: Contains the core classes for managing the scoreboard.
Team: Represents a football team with properties for name, score, and goals.
TeamFactory: Factory class for creating and managing Team instances.
Game: Interface defining the structure of a game.
FootballGame: Implementation of the Game interface for football games.
GameFactory: Factory class for creating Game instances.
ScoreBoard: Singleton class for managing the list of games.
com.sportradar.scoreboard.ui: Contains the classes for the Swing-based user interface.
ScoreBoardUI: Main class for the user interface, which includes panels for game management and displaying live games.
com.sportradar.scoreboard.tests: Contains the unit tests for the project.
FootballGameTest: Tests for the FootballGame class.
GameFactoryTest: Tests for the GameFactory class.
ScoreBoardTest: Tests for the ScoreBoard class.
TeamFactoryTest: Tests for the TeamFactory class.
TeamTest: Tests for the Team class.

Assumptions

The library is in-memory and does not persist data to any external storage.
The user interface is simple and focuses on functionality rather than appearance.
The sorting of games in the summary is based on total goals, with ties broken by the order of addition to the system.
How to Run

How to Run

Prerequisites
Java Development Kit (JDK) 8 or higher
Apache Maven
Build the Project
Navigate to the project directory and run the following command to build the project using Maven:

bash code: "mvn clean install"
Run the Application
After building the project, you can run the ScoreBoardUI class to launch the user interface:

bash code: mvn exec:java -Dexec.mainClass="com.sportradar.scoreboard.ui.ScoreBoardUI"

Use the Application
Use the text fields and buttons in the "Game Management" panel to start and finish games.
The "Live Games" panel will display ongoing games and allow you to update or add to their scores.

Example Usage

Start a new game by entering the home and away team names and clicking "Add Game".
Update the score of an ongoing game by entering the new scores and clicking "Update".
Add goals to an ongoing game by entering the number of goals and clicking "Add Goals".
Finish a game by entering the team names and clicking "Finish Game".
The live games will be displayed and sorted by their total scores in the "Live Games" panel.
Unit Tests

The project includes a set of unit tests to ensure the correctness of the core functionalities. These tests are located in the com.sportradar.scoreboard.tests package.

Running Tests
YYou can run the tests using Maven. Navigate to the project directory and execute:

bash code "mvn test"

Test Descriptions:

FootballGameCreationTest: Tests the creation of a football game.
goalTest: Tests setting goals for a game.
liveGoalTest: Tests live goal updates.
scoreTest: Tests score updates and finalization.

GameFactoryTest:
CreateTeamTest: Tests the creation of a game using the factory.

ScoreBoardTest:
singletonScoreBoardTest: Tests the singleton nature of the scoreboard.
startGameTest: Tests starting a new game.
finishGameTest: Tests finishing a game.
updateGoalsTest: Tests updating goals of a game.
addGoalsTest: Tests adding goals to a game.
summaryTest: Tests retrieving the summary of games.

TeamFactoryTest:
createTeamTest: Tests the creation of a team using the factory.

TeamTest:
TeamCreationTest: Tests the creation of a team.
teamSummaryTest: Tests the summary of a team.
teamAddGoalsTest: Tests adding goals to a team.
teamAddScoreTest: Tests adding score to a team.

Future Improvements

Add more comprehensive unit tests to cover edge cases.
Enhance the user interface for better user experience and visual appeal.
Implement data persistence to save the state of the scoreboard between runs.
Contact

