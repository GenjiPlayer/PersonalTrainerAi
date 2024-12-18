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
-To check your workout plan you now have to go to postman and use this endpoint: http://localhost:8082/api/workout/generate?proficiency=intermediate</br>
Postman should now display a workoutplan for your prefferd proficiancy. You can get a different workoutplan by changing proficiancy to begginer in the link.</br>

## User Stories:
Our program is designed to help anyone looking to build muscle, whether they are completely new to exercise or experienced gym-goers seeking a fresh workout routine.
The program starts by asking the user about their experience level, allowing them to choose between beginner, intermediate, or professional. Next, the user is prompted to provide key information, including their age, height, weight, and goal weight.
Based on the input, the program generates a personalized workout plan that focuses on building muscle. The plan includes a detailed overview of exercises tailored to target specific muscle groups, such as back, legs, and more.
Additionally, the plan provides important guidance at the start, including recommendations on how many days of rest the user should take between workouts to optimize recovery and muscle growth.
This program ensures that anyone, regardless of their fitness level, can follow a structured, effective workout plan.

https://api-ninjas.com/api/exercises


## Diagram:
![image](https://github.com/user-attachments/assets/aeee1f68-9909-4a6d-b50a-7834988c8668)

https://api-ninjas.com/api/exercises
