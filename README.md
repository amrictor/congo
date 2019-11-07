# Development Manual

## Dependencies
This project requires [Maven](https://maven.apache.org/download.cgi) and [npm](https://nodejs.org/en/) in order to build and run correctly. If they are not available on the machine you are using, please install them from the links provided. Maven requires a Java Development Kit (JDK) (1.7 or above) to be used. This project was developed using JDK 8, which is available for download [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

## Setup
Clone this repository using the terminal command `git clone https://github.com/cs414-byte-mechanics/cs414-f19-001-ByteMechanics.git`. After initial clone, or after any update which has altered dependencies in either *package.json* file (*/package.json* or */client/package.json*), run `npm run update` from the root directory or run `npm install` in the same directory as the altered *package.json* file.

## Run
To run the application, run `npm start` from the root directory. This will start the Java server and client. To run the server individually, use `npm run server` or use `npm run client` to start the client on its own. 

Our test suite can be run with `npm run test` .

These `npm` scripts are mapped to common actions in one directory for convenience, but there are other ways to perform these actions. Below, find the actions made by scripts defined in the root level *package.json*. Any of the scripts below can be run using `npm run [script_name]`

- *start*: `npm run dev` 
- *dev*: `concurrently --kill-others-on-fail "npm run server" "npm run client"`
- *update*: `npm install && cd client && npm install`
- *client*: `cd client && npm start`
- *server*: `mvn install`
- *test*: `mvn test`

## Connect to database from off campus or on non-cs lab machine
1. Run `remote.sh` (found in the root directory) or use the following command in a terminal separate from where you are starting the server: 

    `ssh -N -L <local-port>:faure.cs.colostate.edu:3306 <your-username>@eel.cs.colostate.edu`

    * Replace <your-username> with the username you use to login to the CS department machines.
    * Replace <local-port> with any open port number on your local machine.
  
 2. In the terminal from where you are starting the server, enter the command `export TUNNEL=<local-port>` on Linux or `set TUNNEL=<local-port>` on Windows.
    * Replace <local-port> with the same port you used above.
 3. Start the server. It should now be able to communicate with the database.

# Contributors
This project is for CS414: Introduction to Object Oriented Design at Colorado State University. Group members include Aislinn Jeske, Abigail Rictor, Farzaneh Kadkhodaie, Marylou Nash, and Zach Klausner.
