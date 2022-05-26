Feature: Search function
  I want to search products
  @Search @SEA_001
  Scenario Outline: Verify that user is able to search product when entering valid input
    Given I am on the Home page
    When I click the Search text box
    And I enter valid "<Data>"
    Then The product is shown
    Examples:
    |Data|
    |sam |

  @Search @SEA_002
  Scenario Outline: Verify that the message is shown when user enters invalid data
    Given I am on the Home page
    When I click the Search text box
    And I enter invalid "<Data>"
    Then The "Không có kết quả nào..." message is show below the Search textbox
    Examples:
    |Data|
    |vy  |

  @Search @SEA_003
  Scenario Outline: Verify that user is able to search products when entering number in the Search textbox
    Given I am on the Home page
    When I click the Search text box
    And I enter "<Number>" in the Search textbox
    Then The products contain "<Number>" characters are shown
    Examples:
    |Number|
    |24    |
