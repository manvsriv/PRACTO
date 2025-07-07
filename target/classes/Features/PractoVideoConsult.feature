Feature:Practo Video Consult Module

Backgroud:
Given User has launched the browser
And User is on the Practo homepage

@ConsultNowPositive
Scenario: Verify Consult Now button is clickable and open Consultation form
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
Then Consultation form should be displayed successfully
