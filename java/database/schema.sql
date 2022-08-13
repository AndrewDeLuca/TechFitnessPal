BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, foods, profile, meal, mealsFoods;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profile (
	user_id int,
	goal_calories int,
	current_weight int NOT NULL,
	desired_weight int NOT NULL,
	height int,
	age int,
	date_of_birth DATE,
	img_url varchar(100),
	display_name varchar(50),

	CONSTRAINT FK_profile_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE foods (
	food_id SERIAL,
	user_id int,
	name varchar(50) NOT NULL,
	serving_size int NOT NULL,
	number_of_servings int NOT NULL,
	meal varchar(50),
	calories int NOT NULL,
    food_consumed varchar(50),

	CONSTRAINT PK_food PRIMARY KEY (food_id),
	CONSTRAINT FK_foods_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)

);

CREATE TABLE meals (
   meal_id SERIAL,
   user_id int,
   number_of_servings int NOT NULL,
   meal_name varchar(50),
   calories int NOT NULL,

   CONSTRAINT PK_meals PRIMARY KEY (meal_id),
   CONSTRAINT FK_meals_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE mealsFoods (
   meal_foods_id SERIAL,
   meal_id int,
   food_id int,
   meal_foods_name varchar(50),
   calories int NOT NULL,

   CONSTRAINT PK_mealsFoods PRIMARY KEY (meal_foods_id),
   CONSTRAINT FK_mealsFoods_meal_id FOREIGN KEY (meal_id) REFERENCES meals (meal_id),
   CONSTRAINT FK_mealsFood_food_id FOREIGN KEY (food_id) REFERENCES foods (food_id)
);

COMMIT TRANSACTION;
