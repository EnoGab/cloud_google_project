Feature: Test scenario for Calculator

  Scenario: Check calculated amount
    Given User is on "Google Cloud Page"

    When User perform search for "Google Cloud Platform Pricing Calculator" on "Google Cloud Page"

    Then User is successfully navigated from "Search Results Page" to the "Calculator Page"

    When User fill Number of instances field with value "4" on the "Calculator Page"
    And User fill Series field with value "n1" on the "Calculator Page"
    And User fill Machine Type field with value "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8" on the "Calculator Page"
    And User check GPUs checkbox on the "Calculator Page"
    And User fill GPU Type field with value "NVIDIA_TESLA_V100" on the "Calculator Page"
    And User fill Number of GPUs field with value "1" on the "Calculator Page"
    And User fill Local SSD field with value "2" on the "Calculator Page"
    And User fill Datacenter Location field with value "europe-west3" on the "Calculator Page"
    And User fill Committed Usage Location field with value "1" on the "Calculator Page"
    And User click on Add to Estimate button on the "Calculator Page"

    Then "Estimate Module" is present with info "1,081.20 / mo"

    When User click on Email Estimate button on the "Estimate Module"
    And Open a new tab from the "Estimate Module"
    And User open "Generator Page"
    And User generate a random email on the "Generator Page"
    And User navigate to the "InBox Page" from the "Generator Page"

    Then Received email is present with info "Total Estimated Monthly Cost USD 1,081.20" on the "InBox Page"
    Then Cost present in "Estimate Module" equals to the cost present on "InBox Page"