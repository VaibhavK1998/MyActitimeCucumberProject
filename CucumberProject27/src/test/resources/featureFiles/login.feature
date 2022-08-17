
Feature: check login functionality

Background:
Given open a browser
Scenario: verify login functionality using datatable
Given user is on login page
When user enter username and password 
| admin | manager |
And click on login button 
Then dashboar page titile should be displayed as "actiTIME - Enter Time-Track"