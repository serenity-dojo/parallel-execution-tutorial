Feature: Add item to cart

  As an online shopper
  I want to be able to
  So that I can find the items I would like to buy

  Olivia is an Online Shopper

  Rule: Shoppers can add items to the cart
    Scenario: Olivia adds a highlighted product to her cart
      Given Olivia is shopping on the Luma site
      When she views the details of the "Fusion Backpack" item
      And she adds the item to her cart
      And she views her cart summary
      Then the cart should contain:
        | Product Item Name | Price  |
        | Fusion Backpack   | $59.00 |

    Scenario: Olivia adds several items to her cart
      Given Olivia is shopping on the Luma site
      And she has added the "Fusion Backpack" to her cart from the home page
      And she has added the "Push It Messenger Bag" to her cart from the home page
      When she views her cart summary
      Then the cart should contain:
        | Product Item Name     | Price  |
        | Fusion Backpack       | $59.00 |
        | Push It Messenger Bag | $45.00 |




