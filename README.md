[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<div align='center'>
    <h1>Appointment Manager</h1>
    <p>A GUI-based scheduling desktop application to help a global consulting organization manage appointments. Created using Java, JavaFX, MySQL, and Scenebuilder.</p>
        <a href='https://www.linkedin.com/in/plang-psm/' target='_blank'><img src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn tag" /></a>
</div>


## Table of Contents
* [Description](#description)
* [Scenario](#scenario)
* [Technologies](#technologies)
* [Road Map](#road-map)
* [Launch](#launch)
* [Contact](#contact)
* [Resources](#resources)

## Description
The Appointment Manager is a school project that was built using Java, JavaFX, MySQL and Scenebuilder. It consists of three major screens incluidng the appointment screen, customer screen and the report screen. These three, as well as the additional eight, user friendly GUIs were created using Scene Builder. The data that filled these screens were formatted and provided by Western Governors University instructors using the MySQL database. The data was then used to perform C.R.U.D. functions in Java, and JavaFX to create a functionable appointment manager. 

### Login

<img src='https://user-images.githubusercontent.com/101952500/185836917-aa532ec2-7950-4875-a8f1-613525bdca62.jpg' alt='Login image' width='35%'/><img src='https://user-images.githubusercontent.com/101952500/185838953-c813fa2d-7e98-4bef-b391-9985cb0b485c.jpg' alt='Login_activity image' width='65%' />


* User login validation.
* User location displayed.
* French language conversion (including errors).
* 15 minute appointment alert upon validation.
* Login activity attempts are stored in a .txt file.

### Appointnment Screen
![appointments](https://user-images.githubusercontent.com/101952500/185836929-2a56a83b-5b84-4d33-b0ac-367cbbf9b83f.jpg)


* Access to all appointments.
* Navigation to the customer screen.
* Navigation to the report screen.
* Filtering by all, weekly, or monthly appointments.
* Add, edit and delete appointment functions.
* Alerts will display for any blank fields, and upcoming appointments.
* Program exit.

### Customer Screen
![customers](https://user-images.githubusercontent.com/101952500/185837294-e5d68415-6780-41ab-9455-521c53ea226d.jpg)
* Access to all customers.
* Add, edit and delete customer functions.
  * Deleting a customer will result in deletion of all associated appointments.
* Navigation back to the appointment screen.


### Appoinment and Customer Add and Edit screens

<img src='https://user-images.githubusercontent.com/101952500/185837678-5e3da5e1-15f5-4009-b138-7a78a23dc8c3.jpg' alt='Add customer image' width='50%'/><img src='https://user-images.githubusercontent.com/101952500/185837694-0f266a54-f53a-468c-bda3-2910007e3e03.jpg' alt='Edit appointment image' width='50%'/>

* Edit screen passes all the data associated with the appointment or customer id.
* Customer
  *  The division (state/province) filters based off the country selected.
      - For example, U.S. will only display U.S. states.
* Appointment 
  *  Business hours are from 8AM to 10PM and cannot be scheduled before or after.
  *  Appointments cannot overlap with another appointment.

* Alerts will display for any blank fields.

### Report Screen
![reports](https://user-images.githubusercontent.com/101952500/185838436-e1099433-cb87-4368-9ff7-3d43c48c284b.jpg)
* All report options will be displayed

### Report by month and type
![monreports](https://user-images.githubusercontent.com/101952500/185838598-906e60ea-f5ac-4cc5-bc35-6e304c44a9e3.jpg)

* Total number of appointments by type and month.

### Report by contact
![conreport](https://user-images.githubusercontent.com/101952500/185838603-a42d66e6-b05b-4bd3-b445-4ba88ed49703.jpg)
* Report of all appointments associated to the contact selected from the combo box.

### Report by country and division
![divreport](https://user-images.githubusercontent.com/101952500/185838611-ca936ab8-0ea1-43b5-8e4a-68cbb5ce264f.jpg)
* Total number of appointments by the country and division.

### Alerts
![upcomingapts](https://user-images.githubusercontent.com/101952500/185838937-66fcd047-b670-4f17-9af4-ee5c94e01237.jpg)
![deletemsg](https://user-images.githubusercontent.com/101952500/185838946-a3728ed9-5d9c-4467-8f43-81e946f3b6bd.jpg)

* Alerts shown throughout the program include
  * Leaving any required fields blank.
  * Incorrect credentials.
  * Upcoming appointments.
  * Clicking the edit button before selecting an appointment or customer.
  * Before deleting an appointment or customer.
  * If the save was successful. 


## Scenario
You are working for a software company that has been contracted to develop a GUI-based scheduling desktop application. The contract is with a global consulting organization that conducts business in multiple languages and has main offices in Phoenix, Arizona; White Plains, New York; Montreal, Canada; and London, England. The consulting organization has provided a MySQL database that the application must pull data from. The database is used for other systems, so its structure cannot be modified.

The organization outlined specific business requirements that must be met as part of the application. From these requirements, a system analyst at your company created solution statements for you to implement in developing the application. These statements are listed in the requirements section.

Your company acquires Country and First-Level-Division data from a third party that is updated once per year. These tables are prepopulated with read-only data. Please use the attachment “Locale Codes for Region and Language” to review division data. Your company also supplies a list of contacts, which are prepopulated in the Contacts table; however, administrative functions such as adding users are beyond the scope of the application and done by your company’s IT support staff. Your application should be organized logically using one or more design patterns and generously commented using Javadoc so your code can be read and maintained by other programmers.

<details>
<summary>Project requirements</summary>
<br>
 
### A.  Create a GUI-based application for the company in the scenario. Regarding your file submission—the use of non-Java API libraries are not allowed with the exception of JavaFX SDK and MySQL JDBC Driver. If you are using the NetBeans IDE, the custom library for your JavaFX .jar files in your IDE must be named JavaFX.



Note: If you are using IntelliJ IDEA, the folder where the JavaFX SDK resides will be used as the library name as shown in the “JavaFX SDK with IntelliJ IDEA webinar.



#### 1.  Create a log-in form with the following capabilities:

•  accepts a user ID and password and provides an appropriate error message

•  determines the user’s location (i.e., ZoneId) and displays it in a label on the log-in form

•  displays the log-in form in English or French based on the user’s computer language setting to translate all the text, labels, buttons, and errors on the form

•  automatically translates error control messages into English or French based on the user’s computer language setting



Note: Some operating systems require a reboot when changing the language settings.



#### 2.  Write code that provides the following customer record functionalities:

•  Customer records and appointments can be added, updated, and deleted.

-  When deleting a customer record, all of the customer’s appointments must be deleted first, due to foreign key constraints.

•  When adding and updating a customer, text fields are used to collect the following data: customer name, address, postal code, and phone number.

-  Customer IDs are auto-generated, and first-level division (i.e., states, provinces) and country data are collected using separate combo boxes.



Note: The address text field should not include first-level division and country data. Please use the following examples to format addresses:

•  U.S. address: 123 ABC Street, White Plains

•  Canadian address: 123 ABC Street, Newmarket

•  UK address: 123 ABC Street, Greenwich, London



-  When updating a customer, the customer data autopopulates in the form.



•  Country and first-level division data is prepopulated in separate combo boxes or lists in the user interface for the user to choose. The first-level list should be filtered by the user’s selection of a country (e.g., when choosing U.S., filter so it only shows states).

•  All of the original customer information is displayed on the update form.

-  Customer_ID must be disabled.

•  All of the fields can be updated except for Customer_ID.

•  Customer data is displayed using a TableView, including first-level division data. A list of all the customers and their information may be viewed in a TableView, and updates of the data can be performed in text fields on the form.

•  When a customer record is deleted, a custom message should display in the user interface.



#### 3.  Add scheduling functionalities to the GUI-based application by doing the following:

#### a.  Write code that enables the user to add, update, and delete appointments. The code should also include the following functionalities:

•  A contact name is assigned to an appointment using a drop-down menu or combo box.

•  A custom message is displayed in the user interface with the Appointment_ID and type of appointment canceled.

•  The Appointment_ID is auto-generated and disabled throughout the application.

•  When adding and updating an appointment, record the following data: Appointment_ID, title, description, location, contact, type, start date and time, end date and time, Customer_ID, and User_ID.

•  All of the original appointment information is displayed on the update form in local time zone.

•  All of the appointment fields can be updated except Appointment_ID, which must be disabled.



#### b.  Write code that enables the user to view appointment schedules by month and week using a TableView and allows the user to choose between these two options using tabs or radio buttons for filtering appointments. Please include each of the following requirements as columns:

•  Appointment_ID

•  Title

•  Description

•  Location

•  Contact

•  Type

•  Start Date and Time

•  End Date and Time

•  Customer_ID

•  User_ID



#### c.  Write code that enables the user to adjust appointment times. While the appointment times should be stored in Coordinated Universal Time (UTC), they should be automatically and consistently updated according to the local time zone set on the user’s computer wherever appointments are displayed in the application.



Note: There are up to three time zones in effect. Coordinated Universal Time (UTC) is used for storing the time in the database, the user’s local time is used for display purposes, and Eastern Standard Time (EST) is used for the company’s office hours. Local time will be checked against EST business hours before they are stored in the database as UTC.



#### d.  Write code to implement input validation and logical error checks to prevent each of the following changes when adding or updating information; display a custom message specific for each error check in the user interface:

•  scheduling an appointment outside of business hours defined as 8:00 a.m. to 10:00 p.m. EST, including weekends

•  scheduling overlapping appointments for customers

•  entering an incorrect username and password



#### e.  Write code to provide an alert when there is an appointment within 15 minutes of the user’s log-in. A custom message should be displayed in the user interface and include the appointment ID, date, and time. If the user does not have any appointments within 15 minutes of logging in, display a custom message in the user interface indicating there are no upcoming appointments.



Note: Since evaluation may be testing your application outside of business hours, your alerts must be robust enough to trigger an appointment within 15 minutes of the local time set on the user’s computer, which may or may not be EST.



#### f.  Write code that generates accurate information in each of the following reports and will display the reports in the user interface:



Note: You do not need to save and print the reports to a file or provide a screenshot.



•  the total number of customer appointments by type and month

•  a schedule for each contact in your organization that includes appointment ID, title, type and description, start date and time, end date and time, and customer ID

•  an additional report of your choice that is different from the two other required reports in this prompt and from the user log-in date and time stamp that will be tracked in part C



### B.  Write at least two different lambda expressions to improve your code.



### C.  Write code that provides the ability to track user activity by recording all user log-in attempts, dates, and time stamps and whether each attempt was successful in a file named login_activity.txt. Append each new record to the existing file, and save to the root folder of the application.



### D.  Provide descriptive Javadoc comments for at least 70 percent of the classes and their members throughout the code, and create an index.html file of your comments to include with your submission based on Oracle’s guidelines for the Javadoc tool best practices. Your comments should include a justification for each lambda expression in the method where it is used.



Note: The comments on the lambda need to be located in the comments describing the method where it is located for it to export properly.



### E.  Create a README.txt file that includes the following information:

•  title and purpose of the application

•  author, contact information, student application version, and date

•  IDE including version number (e.g., IntelliJ Community 2020.01), full JDK of version used (e.g., Java SE 17.0.1), and JavaFX version compatible with JDK version (e.g. JavaFX-SDK-17.0.1)

•  directions for how to run the program

•  a description of the additional report of your choice you ran in part A3f

•  the MySQL Connector driver version number, including the update number (e.g., mysql-connector-java-8.1.23)
</details>


## Technologies
* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
* ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Road Map
- [ ] Create a usable envrionment for the project

## Launch
Coming soon.


## Contact
<a href='https://www.linkedin.com/in/plang-psm/' target='_blank'><img src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn tag" /></a>

## Resources
Badges: <a href='https://github.com/Ileriayo/markdown-badges' target='_blank'>Copyright (c) 2020 Ileriayo Adebiyi</a>

Header and Layout: <a href='https://github.com/othneildrew/Best-README-Template' target='_blank'>Copyright (c) 2021 Othneil Drew</a>


[contributors-shield]: https://img.shields.io/github/contributors/plang-psm/dice-game.svg?style=for-the-badge
[contributors-url]: https://github.com/plang-psm/dice-game/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/plang-psm/dice-game.svg?style=for-the-badge
[forks-url]: https://github.com/plang-psm/dice-game/network/members
[stars-shield]: https://img.shields.io/github/stars/plang-psm/dice-game.svg?style=for-the-badge
[stars-url]: https://github.com/plang-psm/dice-game/stargazers
[issues-shield]: https://img.shields.io/github/issues/plang-psm/dice-game.svg?style=for-the-badge
[issues-url]: https://github.com/plang-psm/dice-game/issues
