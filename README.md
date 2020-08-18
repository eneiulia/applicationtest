# Run the application

The application could run:

I. From InteliJ

  - Firstly, you need to set the environemnt variable **SPRING_PROFILES_ACTIVE** with value **dev**
  
  - Need to run the last two images for docker-compose.yml (mysqldb and wire-mock)
  
  - The security is built using basic auth. The app has two users, _user_george_ and _user_mihai_, both having the same password "_123_".
  
  - I didn't add any mock data for accounts and transactions. For testing purposes, I changed the cron for calling the scheduled method every 5 minutes. 
  
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
- The security testing is another important topic which I didn't cover here
- Also, I didn't create any integration tests for this application
