Feature: Booking Hotel Tab

  Background:

    Given The user on the Inar Academy Home page
    And The user clicks on the booking link

  Scenario: Visibilty of search hotel button

    When The user clicks on the "Stays" tab
    Then The user should see search hotels button

  Scenario Outline: Search Hotels Functionality
    When The user clicks on the "Stays" tab
    And The user enters "<city>"
    And The user selects check-in date as "<check-in date>" of next month and check-out date as "<check-out date>"
    And The user selects number of adults as "<number of adults>" and number of children "<number of children>" number of rooms "<number of rooms>"
    And The user clicks on search hotel button
    Then The "<title>" title is displayed
    And The user should see that the hotels's locations are "<city>"
    Examples:
      | city      | check-in date | check-out date | number of adults | number of children | number of rooms | title  |
      | Istanbul  | 2             | 5              | 2                | 2                  | 2               | Hotels |
      | Berlin    | 3             | 6              | 2                | 2                  | 2               | Hotels |
      | New York  | 4             | 10             | 2                | 2                  | 2               | Hotels |
      | Amsterdam | 12            | 15             | 2                | 2                  | 2               | Hotels |
      | Moscow    | 6             | 11             | 2                | 2                  | 2               | Hotels |
      | Sydney    | 5             | 8              | 2                | 2                  | 2               | Hotels |


  Scenario Outline: Validate that the Hotel Search filters by features
    When The user clicks on the "Stays" tab
    And The user clicks on search hotel button
    And The user selects feature as "<feature>" from bar on the left side
    And The user clikcs on search button
    And The user clicks on see availability button for #2 hotel is displayed

    Then The user should see that "<feature>" is among the hotel's features
    And The selected hotel's name should be the same with shown name on Hotel Detail Page
    And The selected hotel's price should be the same amount with shown price on Hotel Detail Page

    Examples:
      | feature            |
      | Free WiFi          |
      | Fitness            |
      | 24-hour front desk |
      | Non-smoking rooms  |
      | Free parking       |


  Scenario Outline: Verify the selected information match with displayed information on Booking Page
    When The user clicks on the "Stays" tab
    And The user enters "Istanbul"
    And The user selects check-in date as "2" of next month and check-out date as "6"
    And The user selects number of adults as "2" and number of children "2" number of rooms "<number of rooms>"
    And The user clicks on search hotel button
    And The user clikcs on search button
    And The user clicks on see availability button for #1 hotel is displayed
    And The user clicks on Reserve or Book Now! button

    Then The displayed hotel name should be same with specified hotel name
    And The displayed city of hotel should be "Istanbul"
    And The displayed total lenght of stay should be the same with length of stay on hotel details page
    And The calculated amount based on the number of rooms as "<number of rooms>" should be the same with original price
    #  And The total price’s calculation should be that the original price multipiled by 7% for VAT rate, by 3% for Tourism fee, by 3% for City tax, by 10% for Damage deposit and added it to the original price. And the calculated total price should be the equal to the displayed price.

    Examples:
      | number of rooms |
      | 1               |
      | 2               |
      | 3               |


  Scenario Outline: Verify the valid information to proceed to the checkout step
    When The user clicks on the "Stays" tab
    And The user enters "Istanbul"
    And The user selects check-in date as "2" of next month and check-out date as "6"
    And The user selects number of adults as "2" and number of children "2" number of rooms "2"
    And The user clicks on search hotel button

    And The user clikcs on search button
    And The user clicks on see availability button for highest rated hotel

    And The user clicks on Reserve or Book Now! button

    And The user selects "Yes"
    And The user enters first name as "<FirstName>"
    And The user enters last name as "<LastName>"
    And The user enters email adresses as "<EmailAddress>"
    And The user selects booking person as "<BookingPerson>"
    And The user selects arrival time as "<ArrivalTime>"
    And The user clicks on Next, Final Details button

    Then The user should see that the checkout header as "Enter your Info"
    Examples:
      | FirstName | LastName | EmailAddress           | BookingPerson                | ArrivalTime         |
      | Arthur    | Vassel   | artvas@hotmail.com     | I'm the main guest           | 10:00 PM – 11:00 PM |
      | Kevin     | Vassel   | kevvas@hotmail.com     | I'm the main guest           | I don't know        |
      | Denis     | Sanchez  | densanchez@hotmail.com | I'm booking for someone else | 11:00 PM – 12:00 AM |

  @endtoend @checkout
  Scenario Outline: Verify complete checkout process with valid credentials
    When The user clicks on the "Stays" tab
    And The user enters "Istanbul"
    And The user selects check-in date as "2" of next month and check-out date as "6"
    And The user selects number of adults as "2" and number of children "2" number of rooms "2"
    And The user clicks on search hotel button

    And The user clikcs on search button
    And The user clicks on see availability button for highest rated hotel

    And The user clicks on Reserve or Book Now! button

    And The user selects "Yes"
    And The user enters first name as "<first name>"
    And The user enters last name as "<last name>"
    And The user enters email adresses as "kevvas@hotmail.com"
    And The user selects booking person as "I'm the main guest"
    And The user selects arrival time as "10:00 PM – 11:00 PM"
    And The user clicks on Next, Final Details button

    And The user selects country as "<country>"
    And The user enters phone number as "1234567890"

    Then "Invalid phone number" error message does not show up

    When The user enter card holder's name as "<first name> <last name>"
    And The user enters card number as "1234123412341234"

    Then "Invalid card number. Please enter a valid card number." error message disappear

    And The user enters expiration date as "11/24"
    And The user enters cvv or cvc code as "<cvc/cvv code>"
    And The user clicks on Compelete Booking button

    Then The user should see confirmation message as "Thank you for your booking ! <first name> <last name>"

    When The user clicks on close button

    Then The user should be on the hotel's home page

    Examples:
      | first name | last name | country       | cvc/cvv code |
      | Musa       | Okur      | Germany       | 171          |
      | Ozgur      | Kartal    | Canada        | 127          |
      | Merve      | Genc      | United States | 109          |

  Scenario Outline: Verify complete checkout process with invalid user credentials on booking page

    When The user clicks on the "Stays" tab
    And The user enters "Istanbul"
    And The user selects check-in date as "2" of next month and check-out date as "6"
    And The user selects number of adults as "2" and number of children "2" number of rooms "2"
    And The user clicks on search hotel button

    And The user clikcs on search button
    And The user clicks on see availability button for highest rated hotel

    And The user clicks on Reserve or Book Now! button

    And The user selects "Yes"
    And The user enters first name as "<first name>"
    And The user enters last name as "<last name>"
    And The user enters email adresses as "<email>"
    And The user selects booking person as "I'm the main guest"
    And The user selects arrival time as "10:00 PM – 11:00 PM"
    And The user clicks on Next, Final Details button

    Then The user should see that error message as "<error type> is required"

    Examples:
      | first name | last name | email              | error type    |
      |            | Katal     | o.kartal@gmail.com | First Name    |
      | Musa       |           | m.okur@gmail.com   | Last Name     |
      | Merve      | Genc      |                    | Email Address |

  Scenario Outline: Verify complete checkout process with invalid card credentials on checkout page

    When The user clicks on the "Stays" tab
    And The user enters "Istanbul"
    And The user selects check-in date as "2" of next month and check-out date as "6"
    And The user selects number of adults as "2" and number of children "2" number of rooms "2"
    And The user clicks on search hotel button

    And The user clikcs on search button
    And The user clicks on see availability button for highest rated hotel

    And The user clicks on Reserve or Book Now! button

    And The user selects "Yes"
    And The user enters first name as "Kevin"
    And The user enters last name as "Vassel"
    And The user enters email adresses as "kevvas@gmail.com"
    And The user selects booking person as "I'm the main guest"
    And The user selects arrival time as "10:00 PM – 11:00 PM"
    And The user clicks on Next, Final Details button

    And The user selects country as "United Kingdom"
    And The user enters phone number as "<phone number>"
    And The user enter card holder's name as "<cardholder name>"
    And The user enters card number as "<card number>"
    And The user enters expiration date as "<expiration date>"
    And The user enters cvv or cvc code as "<cvc/cvv code>"
    And The user clicks on Compelete Booking button

    Then The user should see that error message as "Please fill in all the required fields." on checkout page
    Examples:
      | phone number | cardholder name | card number      | expiration date | cvc/cvv code |
      |              | Kevin Vassel    | 1234123412341234 | 11/24           | 123          |
      | 1234567890   | Kevin Vassel    |                  | 11/24           | 123          |
      | 1234567890   | Kevin Vassel    | 1234123412341234 |                 | 123          |
      | 1234567890   | Kevin Vassel    | 1234123412341234 | 11/24           |              |

































