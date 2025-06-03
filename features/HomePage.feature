Feature: Enrollment/Registration process


Scenario: Fill out enrollment form with valid data
  Given User clicks on the enrollment form
  When User enters the following details:
| FullName           | sathish kumar         |
| Email              | sathishcv@gmail.com   |
| CurrentAddress     | Windflower            |
| PermanentAddress   | Kabir singh           |

  Then User submits the enrollment form

