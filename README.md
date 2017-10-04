Do or Diet
=====

Create and maintain meal plans.

## Run

The project can be run through the maven goal: `spring-boot:run`. When the project is up and running you can browse it on `http://localhost:8080/`.

## Database

The database is hosted on AWS and the connection information is in the application.properties and persistance.xml.

## Contact

- Eiður Örn Gunnarsson (eog26@hi.is)
- Fannar Þeyr Guðmundsson (fthg2@hi.is)
- Ragnheiður Ásta Karlsdóttir (rak4@hi.is)
- Viktor Alex Brynjarsson (vab18@hi.is)

## Releases

### 0.2

- Improvements on recipe creation
- Register new user
- Log in for users
- Log out for users

Known bugs:

- Problem creating Recipe, IngredientQuantity, IngredientType relations.

### 0.1

- Register new meal plan
- Create new recipe
- Edit meal plan

