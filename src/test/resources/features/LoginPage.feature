Feature: Login to the App
  
Scenario:  Login into App 
Given User is on Login page 
When User provide "devamahe93@gmail.com" and "Selenium@2468" 
Then User should be on Home Page 

  
Scenario:  Login into App invalid 
Given User is on Login page 
When User provide invalid "devamahe93@gmail.com" and "Selenium@2468" 
Then User should be on Home Page invalid


Scenario:  Login into App negative 
Given User is on Login page 
When User provide negative "devamahe93@gmail.com" and "Selenium@" 
Then User should be on Home Page negative