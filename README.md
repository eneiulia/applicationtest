# Run the application

The application could run:
I. From InteliJ
      - Firstly, you need to set the environemnt variable **SPRING_PROFILES_ACTIVE** with value **dev**
      - Need to run the last two images for docker-compose.yml (mysqldb and wire-mock)
      - You can create users for whom the account and transactions will be updated at the scheduled time.
```sh
 {
	"name": "George"
}
```
II. As a docker container
1. Creating the network for the containers 
```sh
$ docker network create test-app_default
```
2. Building the application's Dockerfile and taking the other images from the docker repository
```sh
$ docker-compose build
```
3. Running the containers 
```sh
$ docker-compose up
```
  

# Tests
 I created just two test:
- One for controller, which is an end to end test - Usually I create a test like that for every endpoint in an application.
- One for service - Usually I have a couple of unit tests in order to test the corner cases for methods which contains business logic.
- Also, I didn't create any integration tests for this application
