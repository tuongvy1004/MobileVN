Feature: Sign up form
  I want to verify the Sign up form
  @SignUp @SIG_001 @SignUplink
  Scenario: Verify that the Sign up popup appears when user clicks the Sign up link
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    Then The Sign up popup appears with title "Đăng ký"

  @SignUp @SIG-002 @AllFields
  Scenario Outline: Verify that user is able to sign up when entering valid inputs in all fields
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    And I enter valid inputs "<Full Name>", "<Email>", "<Phone Number>", "<Password>", "<Confirm Password>"
    And I click the Sign up button
    Then The Sign up popup disappears
    Examples:
    |Full Name|Email|Phone Number|Password|Confirm Password|
    |Jenny Nguyen|jenny40@yopmail.com|0354357159|Hananhh@10|Hananhh@10|

  @SignUp @SIG_003 @FullName @Blank
  Scenario: Verify that the error message is shown when user leaves the full name blank
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    And I click on the Sign up button
    Then The error message "Họ và tên không được để trống" is shown next to the full name label

  @SignUp @SIG_004 @FullName @InvalidData
  Scenario Outline: Verify that the error message is shown when user enters data less than 6 characters
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    And I enter "<Full name>" less than six characters
    And I click on the Sign up button
    Then The error message "Họ và tên phải trên 6 ký tự" is shown next to the full name label
    Examples:
      |Full name|
      |v        |

  @SignUp @SIG_005 @FullName @OnlySpaces
  Scenario: Verify that the error message is shown when user enters only spaces in the Full name field
    Given  I am on the Home page and click the User icon
    When I click the Sign up link
    And I enter spaces in the full name field
    And I click on the Sign up button
    Then The error message "Họ và tên không được để trống" is shown next to the full name label

  @SignUp @SIG_006 @Email @InvalidData
  Scenario Outline: Verify that the error message is shown when user enters email in the wrong format
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    And I enter "<Email>" in the wrong format
    And I click on the Sign up button
    Then The error message "Email không đúng định dạng" is shown next to the email label
    Examples:
      |Email|
      |jenny33@|

  @SignUp @SIG_007 @Email @Blank
  Scenario: Verify that the error message is shown when user leaves the email field blank
    Given  I am on the Home page and click the User icon
    When I click the Sign up link
    And I click on the Sign up button
    Then The error message "Email không được để trống" is shown next to the email label

  @SignUp @SIG_008 @Email @OnlySpaces
  Scenario: Verify that the error message is shown when user enters only spaces in the email field
    Given I am on the Home page and click the User icon
    When I click the Sign up link
    And I enter spaces in the Email field
    And I click on the Sign up button
    Then The error message "Email không được để trống" is shown next to the email label

  @SignUp @SIG_009 @PhoneNumber @Blank
  Scenario: Verify that the error message is shown when user leaves phone number field blank
    Given  I am on the Home page and click the User icon
    When I click the Sign up link
    And I click on the Sign up button
    Then The error message "Số điện thoại không được để trống" is shown next to the phone number label

  @SignUp @SIG_010 @Password @Blank
  Scenario: Verify that the error message is shown when user leaves password field blank
    Given  I am on the Home page and click the User icon
    When I click the Sign up link
    And I click on the Sign up button
    Then The error message "Mật khẩu không được để trống" is shown next to the password label




