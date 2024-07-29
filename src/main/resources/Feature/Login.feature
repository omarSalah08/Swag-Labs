@test
  Feature: Login | user can login to the website

    Scenario Outline: user can login with a valid username and password
      Given user enter "<username>" and "<password>"
      When user click login button
      Then user login successfully


      Examples:
        | username | password |
        | standard_user | secret_sauce |
        | problem_user  | secret_sauce |
        | error_user    | secret_sauce |
        | visual_user   | secret_sauce |
        | performance_glitch_user | secret_sauce |


    Scenario: user can't login with valid username and invalid password
      Given user enter "standard_user" and "invalid_sauce"
      When user click login button
      Then user can't login


    Scenario: user can't login with invalid username and valid password
      Given user enter "invalid_user" and "secret_sauce"
      When user click login button
      Then user can't login


    Scenario: user can't login with invalid username and invalid password
      Given user enter "invalid_user" and "invalid_sauce"
      When user click login button
      Then user can't login


    Scenario: user can't login with empty username and valid password
      Given user enter "" and "secret_sauce"
      When user click login button
      Then user can't login


    Scenario: user can't login with valid username and empty password
      Given user enter "standard_user" and ""
      When user click login button
      Then user can't login


    Scenario: user can't login with empty username and empty password
      Given user enter "" and ""
      When user click login button
      Then user can't login


    Scenario: user can be locked out with valid username and password
      Given user enter "locked_out_user" and "secret_sauce"
      When user click login button
      Then user can't login