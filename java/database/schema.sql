BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, foods, profile;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profile (
	profile_id SERIAL,
	user_id int,
	goal_calories int,
	current_weight int NOT NULL,
	desired_weight int NOT NULL,
	age int,
	height int,
	CONSTRAINT PK_profile PRIMARY KEY (profile_id),
	CONSTRAINT FK_profile_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE foods (
	food_id SERIAL,
	profile_id int,
	name varchar(50) NOT NULL,
	serving_size int NOT NULL,
	number_of_servings int NOT NULL,
	meal varchar(50),
	calories int NOT NULL,
	CONSTRAINT PK_food PRIMARY KEY (food_id),
	CONSTRAINT FK_food_profile_id FOREIGN KEY (profile_id) REFERENCES profile (profile_id)
);

COMMIT TRANSACTION;
