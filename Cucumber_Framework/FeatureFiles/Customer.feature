Feature: 
  As admin user add customer

  Scenario Outline: 
    Validate add Customer with multiple data

    Given user launch the browser
    When user launch the Url
    When user wait for Username with "xpath" and "//input[@id='username']"
    When user enter Username with "name" and "username" and "admin"
    When user enter Password with "xpath" and "//input[@id='password']" and "master"
    When user click on login button with "xpath" and "//button[text()='Login']"
    When wait for Customer link with "xpath" and "(//a[contains(normalize-space(),'Customers')])[2]"
    When click on customer link with "xpath" and "(//a[contains(normalize-space(),'Customers')])[2]"
    When wait for add icon with "xpath" and "(//span[@data-caption='Add'])[1]"
    When click add icon with "xpath" and "(//span[@data-caption='Add'])[1]"
    When wait for customer number with "xpath" and "//input[@id='x_Customer_Number']"
    When capture customer number with "xpath" and "//input[@id='x_Customer_Number']"
    When enter in "<username>" with "xpath" and "//input[@id='x_Customer_Name']"
    When enter in "<address>" with "xpath" and "//textarea[@id='x_Address']"
    When enter in "<city>" with "xpath" and "//input[@id='x_City']"
    When enter in "<country>" with "xpath" and "//input[@id='x_Country']"
    When enter in "<contactPerson>" with "xpath" and "//input[@id='x_Contact_Person']"
    When enter in "<phoneNumber>" with "xpath" and "//input[@id='x_Phone_Number']"
    When enter in "<email>" with "xpath" and "//input[@id='x__Email']"
    When enter in "<mobileNumber>" with "xpath" and "//input[@id='x_Mobile_Number']"
    When enter in "<notes>" with "xpath" and "//input[@id='x_Notes']"
    When click add button with "id" and "btnAction"
    When wait for confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
    When click confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
    When wait for Alert ok button with "xpath" and "//button[@class='ajs-button btn btn-primary']"
    When click Alert ok button with "xpath" and "//button[@class='ajs-button btn btn-primary']"
    When vaidate customer table
    When click on logout with "xpath" and "//a[text()='Logout']"
    Then close Application Browser

    Examples: 
      | username | address  | city      | country | contactPerson | phoneNumber | email          | mobileNumber | notes     |
      | Sai1     | Moosapet | Hyderabad | India   | LG            |  9876543210 | Test@gmail.com |   9876543210 | Customers |
      | Sai2     | Moosapet | Hyderabad | India   | LG            |  9876543210 | Test@gmail.com |   9876543210 | Customers |
      | Sai3     | Moosapet | Hyderabad | India   | LG            |  9876543210 | Test@gmail.com |   9876543210 | Customers |
