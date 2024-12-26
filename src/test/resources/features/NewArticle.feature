Feature: Create New Article

Scenario Outline: Create new Article 
Given User should be on New Article Page 
When User enters Article details "<title>", "<Desc>", "<Content>" and "<tag>"
Then Article must be created 

Examples:
| title | Desc | Content | tag |
| selenium23456356 | Selenium first Project | Selenium first Project using POM and testNG framework | @selenium, @TestNG, @POM |
| selenium23453456 | Selenium first Project | Selenium first Project using POM and testNG framework | @selenium, @TestNG, @POM |