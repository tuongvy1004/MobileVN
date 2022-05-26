Feature: Order Page
  I want to order product
  @Order @ORD_001
  Scenario: Verify that the 'Đặt hàng' pop up appears when user clicks 'Đặt hàng' button
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    Then The "Đặt Hàng" popup appears

  @Order @ORD_002
  Scenario Outline: Verify that the information popup appears when user orders successfully
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    And I enter "<Address>" and "<Password>"
    And I click the 'Thanh toán' button
    Then The "Đặt hàng thành công" popup is displayed
    Examples:
    |Address|Password|
    |14 Huynh Ngoc Hue|Hananhh@10|

  @Order @ORD_003 @BlankPassword
  Scenario: Verify that the error message is shown when user leaves password blank
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    And I click the 'Thanh toán' button
    Then The error message "Mật khẩu không được để trống" is shown next to 'Mật khẩu' label

  @Order @ORD_004 @InvalidPassword
  Scenario Outline: Verify that the error message is shown when user enters invalid password
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    And I enter "<Password>"
    And I click the 'Thanh toán' button
    Then The "Mật khẩu không đúng" error message is shown next to 'Mật khẩu' field
    Examples:
    |Password|
    |a       |

  @Order @ORD_005 @Total
  Scenario: Verify that the total price in cart is equal to total price in order
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    Then The total price in cart is equal to total price in order

  @Order @ORD0_006 @BlankFullName
  Scenario Outline: Verify that the error message is shown when user leaves 'Họ và tên' blank
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    And I enter "<Password>"
    And I clear data in all fields
    And I click the 'Thanh toán' button
    Then The error message is shown
    Examples:
    |Password|
    |Hananhh@10|

  @Order @ORD_007 @InvalidAddress
  Scenario Outline: Verify that the error message is shown when user enters address less than 15 characters
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the 'Đặt hàng ngay' button
    And I order product
    And I clear data in Address field and enter "<Address>"
    And I click the 'Thanh toán' button
    Then The error message "Địa chỉ phải trên 15 ký tự" is shown next to 'Địa chỉ' label
    Examples:
    |Address|
    |a      |
