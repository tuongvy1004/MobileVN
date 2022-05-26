Feature: Login page
  I want to login to the system
  @Login @LOG_001
  Scenario Outline: Verify that user is able to login when entering valid inputs
    Given I am on the Home page and click the User icon
    When I enter "<Email>" and "<Password>" in text boxs
    And I click the 'Đăng nhập' button
    Then The Login popup disappears
    Examples:
    |Email|Password|
    |jenny32@yopmail.com|Hananhh@10|

  @Login @LOG_002 @InvalidPassword
  Scenario Outline: Verify that the error message is shown when user enters incorrect password
    Given I am on the Home page and click the User icon
    When I enter valid "<Email>" and invalid "<Password>"
    And I click the 'Đăng nhập' button
    Then The 'Email hoặc SĐT hoặc Mật khẩu không đúng' error message is shown
    Examples:
    |Email|Password|
    |jenny32@yopmail.com|aaaaaa|

  @Login @LOG_003 @BlankPassword
  Scenario Outline: Verify that the error message is shown when user leaves the password blank
    Given I am on the Home page and click the User icon
    When I enter valid "<Email>" and leave password field blank
    And I click the 'Đăng nhập' button
    Then The error messsage is shown "Mật khẩu không được để trống" next to the 'Mật khẩu' label
    Examples:
    |Email|
    |jenny32@yopmail.com|

  @Login @LOG_004 @SpacesPassword
  Scenario Outline: Verify that the error message is shown when user enters spaces in the password field
    Given I am on the Home page and click the User icon
    When I enter valid "<Email>" and enter spaces in the Password field
    And I click the 'Đăng nhập' button
    Then The error messsage is shown "Mật khẩu không được để trống" next to the 'Mật khẩu' label
    Examples:
    |Email|
    |jenny32@yopmail.com|

  @Login @LOG_005 @InvalidPassword
  Scenario Outline: Verify that the error message is shown when user enters password less than 6 characters
    Given I am on the Home page and click the User icon
    When I enter "<Password>" less than six characters on the Login form
    And I enter "<Email>" on Login form
    And I click the 'Đăng nhập' button
    Then The error message is shown "Mật khẩu phải trên 6 ký tự"on the Login form
    Examples:
    |Password|Email|
    |a|jenny32@yopmail.com|

  @Login @LOG_006 @BlankEmail
  Scenario: Verify that the error message is shown when user leaves the email field blank
    Given I am on the Home page and click the User icon
    When I click the 'Đăng nhập' button
    Then The error message is shown "Email hoặc Số điện thoại không được để trống" next to Email label

  @Login @LOG_007 @InformatEmail
  Scenario Outline: Verify that the error message is shown when user enters wrong format email
    Given I am on the Home page and click the User icon
    When I enter "<Email>" on Login form
    And I click the 'Đăng nhập' button
    Then The error message is shown "Email hoặc số điện thoại không đúng định dạng" next to Email label
    Examples:
    |Email|
    |jenny32yopmail.com|

  @Login @LOG_008 @SpacesEmail
  Scenario: Verify that the error message is shown when user enters spaces in the Email field
    Given I am on the Home page and click the User icon
    When I enter spaces in the Email field on the Login form
    And I click the 'Đăng nhập' button
    Then The error message is shown "Email hoặc Số điện thoại không được để trống" next to Email label

  @Login @LOG_009 @InvalidEmail
  Scenario Outline: Verify that the error message is shown when user enters invalid email
    Given I am on the Home page and click the User icon
    When I enter "<Email>" on Login form
    And I click the 'Đăng nhập' button
    Then The error message is shown "Email hoặc Số điện thoại không có trong CSDL" next to Email label
    Examples:
    |Email|
    |jenny50@yopmail.com|