Feature: Display product categories
  As an online shopper
  I want to see the categories and subcategories available in one place
  So that I can find the items I would like to buy

  Olivia is an Online Shopper

  Rule: Main categories should be visible in the main menu bar
    Example: Olivia views all of the main categories
      Given Olivia is shopping on the Luma site
      When she views the main menu bar
      Then she should see the following items:
        | What's New |
        | Women      |
        | Men        |
        | Gear       |
        | Training   |
        | Sale       |

  Rule: Subcategories should be visible when you move the mouse over one of the main menu items
    Scenario Outline: Olivia views the subcategories for category <Category>
      Given Olivia is shopping on the Luma site
      When she views the subcategories of the "<Category>" category
      Then she should be presented with the following subcategories: <Subcategories>
      Examples:
        | Category | Subcategories                  |
        | Women    | Tops, Bottoms                  |
        | Men      | Tops, Bottoms                  |
        | Gear     | Bags,Fitness Equipment,Watches |
        | Training | Video Download                 |

    Scenario Outline: Olivia views second-level sub-categories for category <Category> and subcategory <Subcategory>
      Given Olivia is shopping on the Luma site
      When she views the subcategories of the "<Subcategory>" subcategory in the "<Category>" category
      Then she should be presented with the following 2nd level subcategories: <SubSubCategories>
      Examples:
        | Category | Subcategory | SubSubCategories                                |
        | Women    | Tops        | Jackets,Hoodies & Sweatshirts,Tees,Bras & Tanks |
        | Women    | Bottoms     | Pants, Shorts                                   |
        | Men      | Tops        | Jackets,Hoodies & Sweatshirts,Tees,Tanks        |
        | Men      | Bottoms     | Pants, Shorts                                   |
