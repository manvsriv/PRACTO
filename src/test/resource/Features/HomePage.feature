Feature: Practo Website Functional Test Suite
 
  # TC001 - Search and Book Doctor
  # Brief: Verify that users can search for doctors based on specialization (e.g., Dentist),
  # and view relevant results to initiate the booking process.
 #Feature: Search and sort doctors by experience
#
  Scenario: TC001 - Search dentist in Mumbai and sort by high to low experience
    Given User is on Practo homepage
    When User selects "Mumbai" as the city
    And User searches for "Dentist" and hits Enter
    Then User applies "Experience - High to Low" filter
    And Search results should reflect sorted experience
#Feature: Practo Consult Flow
#
  Scenario: TC002 - Fill Consultation Form and Submit OTP
    Given User is on Practo homepage
    When User scrolls down once and clicks on View Specialities
    And User scrolls further and clicks on See all Specialities
    And User enters symptom "Fever" and mobile number "9172448853"
    And User submits OTP and completes consultation step
    Then Consultation form should be submitted and user should land on post-login page
 
  # TC003 - Scroll Using JavaScript
  # Brief: Ensure that the page scrolls smoothly to the bottom using JavaScriptExecutor,
  # confirming dynamic content loads correctly without manual scroll.
  #Scenario: TC003 - Scroll to bottom using JavaScript
    #Given User is on Practo homepage
    #When User scrolls to bottom using JavaScript
    #Then Page should scroll till the footer
 
  # TC004 - Hover on Menu and Navigate
  # Brief: Test the mouse hover action on the “For Providers” menu and confirm that the dropdown
  # appears and links (e.g., Practo Prime) are clickable.
  #Scenario: TC004 - Hover over For Providers and click Practo Prime
    #Given User is on Practo homepage
    #When User hovers on "For Providers"
    #And User clicks on "Practo Prime"
    #Then Practo Prime page should be visible
 #
   Scenario: TC003 - Play YouTube video inside ABDM section
  Given User is on Practo homepage
  When User opens For Providers dropdown and clicks on ABDM
  And User scrolls to video section and plays it
  Then ABDM video should start playing
 #
#Feature: Practo Website Functional Test Suite

  Scenario: TC004 - Capture screenshot of health article
    Given User is on Practo homepage
   When User scrolls to See all articles button and clicks it
    And User clicks on Healthy Eating tab
    Then User scrolls to article list and clicks on one
  #  Then Screenshot of the opened article should be captured
 #
  # TC007 - Change City and Search for Lab Test
  # Brief: Ensure that users can change their city (e.g., to Mumbai) and search for lab tests,
  # confirming the results are filtered based on the selected city.
  #Scenario: TC007 - Change city and search for lab test
    #Given User is on Lab Tests page
    #When User changes city to "Mumbai"
    #And User enters "Blood" in the test search box
    #Then List of lab tests should be shown
 #
  # TC008 - Book a Diagnostic Test (Thyroid Profile)
  # Brief: Validate that a user can find and navigate to a specific diagnostic test
  # (e.g., Thyroid Profile) and initiate the booking process.
  #Scenario: TC008 - Book Thyroid Profile test
    #Given User is on Lab Tests page
    #When User scrolls and clicks on "Thyroid Profile"
    #Then Booking page for Thyroid Profile should open
 #
  # TC009 - Open Health Feed Article
  # Brief: Ensure that the Health Feed section loads correctly, users can click on any article,
  # and are redirected to a page with full content and title.
  #Scenario: TC009 - Open and verify health feed article
    #Given User is on Practo homepage
    #When User navigates to Health Feed
    #And User clicks on an articley768
    #Then Article page title should be visible
 #


  Scenario: TC005 - Book surgery consultation from homepage
    Given User is on Practo homepage
    When User clicks on the Surgeries section
    And User scrolls to Book Appointment form
    And User selects "Pune" as the city1
    And User selects "Lasik" as the surgery
   And User searches and selects "Knee" as the ailment
		And User selects "Knee Replacement" from ailment suggestions
    And User enters "Abcdr" as the patient name
    And User enters "9172448853" as the mobile number
    And User clicks on Book Appointment
    Then Confirmation message should be visible
 Scenario: TC006 - Search with invalid input on homepage
  Given User is on Practo homepage
  When User selects "Mumbai" as the city
  And User searches for "123456789" and hits Enter
  Then No search results message should be displayed
 