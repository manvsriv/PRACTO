
Feature: To validate the different functionalities of Practo Find Doctor Page

Background:
    Given User is on Practo HomePage. 
    
@Scenario1 @Positive
Scenario: Validate the visibility of Practo Case Studies Page
When user clicks Find Doctors near you button
And clicks on Security and Help dropdown menu
And clicks on help
Then Practo help page should appear
And clicks on Practo Case Studies
Then Practo Case Studies Page appears.

@Scenario2 @Positive
Scenario: Validate the visibility of Practo Github page
When user clicks Find Doctors near you button on homepage
And clicks Find Doctors near you buttonscrolls to the bottom of the page
And clicks on the Github button
Then Practo Github Page opens.
 
@Scenario3 @Positive
Scenario: Validate the Healthy Eating Page
When user clicks on the module button
And clicks on Read Articles button
And clicks on Healthy Eating option
Then Articles on Healthy Eating appear on a page
And user navigates back to the module page

@Scenario4 @Positive @Negative
Scenario Outline: Validate the page for Booking a Surgery Appointment   #using ExcelSheet
When user clicks on the module page
And clicks on the Surgeries popup
And scrolls down and clicks Cataract option
And enters the "<name>" and "<phnumber>" 
Then validate the Book Appointment button

    Examples: 
      | name          | phnumber     |
      | 10            |     11       |
      | 20            |     21       |
      
@Scenario5 @Positive
Scenario: Validate bookimg Video Consultation with valid credentials     #using DataTable
When user clicks on FindDoc button 
And clicks on Consult with a Doctor button
And clicks on Consult Now button
And enters the VALID symptom and phonenumber using Data Table
|VideoConsultationCredentials.xlsx|
Then OTP popup appears

@Scenario6 @Negative
Scenario: Validate booking Video Consultation with Invalid credentials    #usingPropertyFile
When user clicks on FindDoc button on HomePage
And clicks on consult with a Doctor button on the module page
And clicks on Consult Now button on the page
And enters the INVALID symptom and phonenumber using Property file
Then OTP PopUp appears

@Scenario7 @Positive @Negative
Scenario Outline: Validate Booking Clinic visit using Valid and Invalid Credentials    #using ExcelSheet
When user clicks on module page icon on home page
And clicks on Pediatrician option on Module Page
And applies filters
And clicks on Book Clinic Visit
And enters OTP
And enters both Valid and Invalid Credentials from <sheetno> and <rowno>
Then Booking Confirmation page should appear

    Examples: 
      | sheetno      | rowno       |
      | 0            |     1       |
      | 0            |     3       |
