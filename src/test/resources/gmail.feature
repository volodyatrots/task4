Feature: Sent message
   Missed messages should be stored in drafts and the user should be able to send them

    Scenario Outline: Sent message from drafts
      Given User navigates to Gmail
      When  I enter mail <mail> and password <password>
      Then  Login should be successful
      When  I write message
      And   Open Drafts Page
      Then  My message should be here
      When  I sent that message
      Then  Message must be sent
    Examples: users
     |              mail       |   password  |
     |     testseleniumlab5    |  teStlab#5  |
     |     testseleniumlab51   |  teStlab#5  |
