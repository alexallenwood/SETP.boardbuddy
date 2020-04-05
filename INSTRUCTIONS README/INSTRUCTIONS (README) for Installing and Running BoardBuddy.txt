Instructions for running BoardBuddy system correctly.

1) Install Android Studio - make sure you install the Pixel3A (API 27) emulator in AVD Manager
2) Install WAMP server (windows only)
3) Open PHP MyAdmin in WAMP and create a database named "boardbuddydb"
4) Insert the following code in the SQL section, to create the table "users" (the database is localhost and so this must be done)

CREATE TABLE `users` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` text NOT NULL,
 `surname` text NOT NULL,
 `age` int(11) NOT NULL,
 `email` text NOT NULL,
 `password` text NOT NULL,
 `latitude` decimal(9,6) NOT NULL,
 `longitude` decimal(9,6) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1


4) For the application to work, at least 4 entries need to be in the database - please populate the database with at least 4 rows of legitimate data
5) Open "C:\wamp64\www" folder
6) Locate the PHP files in SETPboardbuddy under the "PHP FILES" folder
7) Place the following PHP files in the www folder
	conn.php
	login.php
	register.php

8) Open Android Studio project
9) Open DatabaseHelper class
10) Change the "????????" on line 35 and 36 to your IPv4 address (for the localhost WAMP to work)
11) The test cases are on the left hand side under "app>java>com.example.setpboardbuddy(androidTest)
12) The test cases are automatic - click on the test case and then click the green arrow on the top left of the test code
13) Run the program / test cases
