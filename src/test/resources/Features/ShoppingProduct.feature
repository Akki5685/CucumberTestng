Feature: As a tester I want to validate the  Amazon Application
  Background:
    Given Navigate to  Amazon Application
    
  @Regression @ShoppingToCart
   Scenario: Validate zoom in of search product
    And Search for "Samsung mobiles" from the search field
#    When Click on the searched product
#    And Mouse hover the mouse to the product to zoom in
#    Then Validate the selected product is zoom
#
  @Regression @ShoppingToCart
   Scenario: Validate the add to cart of the product
#    And Search for "Samsung mobiles" from the search field
#    When Click on the searched product
#    And Click on the add to cart button
#    And Click on the cart button
#    Then Validate "Samsung Galaxy S21 FE 5G" is added to shopping cart page
#    And Click on delete button from shopping cart page
#    And Validate "Your Amazon Cart is empty" page is displayed