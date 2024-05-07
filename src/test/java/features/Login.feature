Feature: Application Login

Scenario: Login with valid credential
Given Open any browser
And Navigate to login page
When User enters username as "anirudha.selenium5@gmail.com" and password as "Anirudha@123" into the fields
And clicks the login button
Then verify user is able to successfully login