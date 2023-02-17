Feature: Search by keyword
  As an online shopper
  I want to search for items by keyword
  So that I can find the items I would like to buy

  Olivia is an Online Shopper

  Rule: Should be able to search by keyword
    Example: Olivia searches for tops
      Given Olivia is shopping on the Luma site
      When she searches for products related to "tops"
      Then she should be presented with the following products:
        | Leah Yoga Top        |
        | Primo Endurance Tank |
        | Carina Basic Capri   |
        | Bardot Capri         |

  Rule: Search results should display related search terms
    Example: Olivia sees related searches
      Given Olivia is shopping on the Luma site
      When she searches for products related to "tops"
      Then she should be presented with the following related search terms:
        | tops and bottoms |
        | tops women       |

    Example: Olivia views the related search items
      Given Olivia is shopping on the Luma site
      When she searches for products related to "tops"
      And she selects the related search term "tops women"
      Then she should be presented with the following related search terms:
        | womens t-shirt     |
        | women pink t-shirt |
        | women t-shirt      |

