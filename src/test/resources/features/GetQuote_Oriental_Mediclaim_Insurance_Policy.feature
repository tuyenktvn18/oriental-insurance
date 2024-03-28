Feature: Get Quote - Oriental Mediclaim Insurance Policy (Individual)

  Scenario Outline: Verify that user can get quote
    Given user navigate to Get Quote screen 'https://orientalinsurance.org.in/web/guest/get-quote-individual'
    When user select date of birth with '14 Mar 2000' on 'personal'
    And user select Sum insured for 'personal' with amount '150000.0'
    And user choose "<Personal PA>" option for 'personal' area
    Then user select amount '400000' for PA sum insured if "<Personal PA>" is yes
    When user choose "<Spouse>" option for extra insure on 'spouse' area
    Then user select date of birth with '14 Mar 2000' if "<Spouse>" is yes on 'spouse' area
    And user select Sum insured with amount '150000.0' if "<Spouse>" is yes on 'Spouse' area
#    And user choose 'Personal Accident' option for 'Personal Details'
#    Then user select amount for 'Personal Details' if covering 'Personal Accident'
#    When user choose 'Dependent children' option for extra insure

    Examples:
      | Personal PA | Spouse | Dependent children | Father | Mother | Father-in-law | Mother-in-law | Entire family |
      | Yes         | Yes    | Yes                | Yes    | Yes    | Yes           | Yes           | Yes           |
#      | No          | No     | No                 | No     | No     | No            | No            | No            |
