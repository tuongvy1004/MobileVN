Feature: Add to cart
  I want to add products to cart
  @AddToCart @ADD_001
  Scenario: Verify that user is able to add products to cart when clicking the 'Thêm vào giỏ'button
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    Then The product is added successfully

  @AddToCart @ADD_002 @Price
  Scenario: Verify that product price is displayed correctly in the Cart
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    Then The product price is displayed correctly in the cart

  @AddToCart @ADD_003 @Name
  Scenario: Verify that product name is displayed correctly in the cart
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    Then The product name is displayed correctly in the cart

  @AddToCart @ADD_004 @Amount
  Scenario: Verify that user is able to select the amount of product in the cart
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I select the amount of product
    Then The amount and price of product is displayed correctly

  @AddToCart @ADD_005 @InvalidPrice
  Scenario: Verify that product price must be greater than 0 in cart
    Given I am on the Home page
    When I check product price
    Then The price must be a positive number

  @AddToCart @ADD_006 @DeleteProduct
  Scenario: Verify that product is able to deleted when user clicks the Delete icon
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I click the Delete icon
    Then The product is not displayed in cart

  @AddToCart @ADD_07 @Total
  Scenario: Verify that total amount of the order is displayed correctly with product price of chosen products
    Given I am on the Home page
    When I click the 'Thêm vào giỏ' button
    And I choose another product
    Then I check total amount of the order is displayed correctly


