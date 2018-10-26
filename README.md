# Blue Harvest Code Assessment 

##Business Requirements
###Open Current Account API
  * This api will be used to open a current account
  * Ths user should be already existing
  * API to consume following information
    *  customerId
    * initialCredit
        
  * If initialCredit is not 0, initiate a transaction with given amount
        
### Show user Details API

  * This API will be used to retrieve User's details
    * Given Name
    * Surname
    * List of Accounts and there balances
    * Account Transactions

## Technical Requirements
### Domain Entities
 * Customer
    * Customer Id
    * Given Name
    * Surname
    * Collection of Accounts
    
 * Account
    * Account Id
    * Account Type
    * Ordered Collection of Transactions
    * Balance
 * Transaction
    * Transaction Id
    * Transaction Type
    * Associated Account
    * Transaction Amount
    
 ### Data Transfer Objects
 * Create Current Account
    * Customer ID
    * Initial Credit
 * Get User Details
    * Customer
  
    
 ### Crud Repositories for all domain objects
 ### Service layer 
 ### Controllers