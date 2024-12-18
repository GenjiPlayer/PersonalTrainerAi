## How to run the program:</br>
-Do "npm run dev" in terminal</br>
-Do "consul agent -dev" in terminal</br>
-Run APIApplication</br>
-Run ApiGatewayApplication</br>
-Run DataRefactorApplication</br>
-Run MicroserviceExamApplication</br>
Program should now be ready for use</br>

## How to use the program:</br>
-Open http://localhost:3000/ in your web browser</br>
-Choose your prefered gym proficany</br>
-Put in your age, height, weight, and goal weight</br>
-Click submit</br>
-Multiple endpoints to test</br>
GET http://localhost:8080/input/all
GET http://localhost:8090/refactor/all
GET http://localhost:8081/actuator/health
GET http://localhost:8081/fallback
all POST requests are ran through the website and communicate with eachother, their results are displayed in the service log box, included the entire workout program depending on a users proficiency

## User Stories:
1. For Beginners:</br>
    A person new to training will experience this app as an easy way to start working out and get a workout plan tailored to their beginner level.</br>

2. For Intermediate Users:</br>
    A person with intermediate training experience might discover new exercises they haven’t tried before or receive a completely new workout plan designed for someone with some gym experience.</br>

3. For Experts:</br>
    An expert in training will primarily use this app to switch up their workout plan and still receive a new program that is challenging for their skill level.</br>

## Overview
Our program is designed to help anyone looking to build muscle, whether they are completely new to exercise or experienced gym-goers seeking a fresh workout routine.
The program starts by asking the user about their experience level, allowing them to choose between beginner, intermediate, or professional. Next, the user is prompted to provide key information, including their age, height, weight, and goal weight.
Based on the input, the program generates a personalized workout plan that focuses on building muscle. The plan includes a detailed overview of exercises tailored to target specific muscle groups, such as back, legs, and more.
Additionally, the plan provides important guidance at the start, including recommendations on how many days of rest the user should take between workouts to optimize recovery and muscle growth.
This program ensures that anyone, regardless of their fitness level, can follow a structured, effective workout plan.

https://api-ninjas.com/api/exercises

## Contributions:
Benjamin: task delegation, entire userInput service, API Gateway and Consul, fallback and health checks, bug fixing, rabbitmq configuration, refactor service fixing, workout service fixing, frontend api calls and design.
</br>
Sveinung: Worked on the programGenerator module, collecting from API and presenting the workout plan.
</br>
Ludvik: dataRefactor, connection between our microservices, bug fixing, help setting up parts of programGenerator 
</br>
Ole: README.md file, autentication/log in on website but as a group we decided not to have it, started the foodPlan but again as a group it was decided to not be used, pair programing with everyone.

## Diagram:
![image](https://github.com/user-attachments/assets/aeee1f68-9909-4a6d-b50a-7834988c8668)

https://api-ninjas.com/api/exercises
