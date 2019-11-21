Feature: Register New Customer and ADD Item to the cart and verify same item is added

Background: User opens automation practice application, register new user and navigate to signin page
Given user is on Signin page


Scenario Outline: Sign up(Register) with New user account and validate the Mandatory field in the sign up page
		  When user enters "<email address>" and click on create an account button
	   	  Then verify user is on Registration screen
		  When clicks on Register Button
		  Then Verify the Mandatory fields
		  When user selects title "<title>"
		  And user types first name "<first name>"
		  And user types sur name "<sur name>"
		  And user enters password "<password>"
		  And user enters address "<address>"
		  And user enters city "<city>"
		  And user selects the state "<state>"
		  And user enters the zip "<zip>"
		  And user selects the country "<country>"
		  And user enters mobile phone "<mobile phone>"
		  And user enters address alias "<address alias>"
		  And clicks on Register Button
		  And logout the application

	Examples:
		 |email address|title|first name|sur name|password|address|city|state|zip|country|mobile phone|address alias|
		 |tesa51@xyz.com|mr|firstxa|lastxa|Pawd1|x1 lane|salt lake|Ohio|84044|United States|9874563210|X1list|			 
				 
Scenario: Validate user login(sign in) with the above user account
		  Given user enter email address to login
		  And user enter password to login
		  When click on signin button to login
		  Then user logged in and navigates to my account page
		  And user name displayed in top right corner
		  And logout the application
		  		  
Scenario: Add an item to the cart and validate if the item is same as the one you have added
		  Given user enter email address to login
		  And user enter password to login
		  When click on signin button to login
		  Then user logged in and navigates to my account page
		  And user can see "MY WISHLISTS" in My Account Page
		  When user click on my wishlists link
		  Then user can see "TOP SELLERS" in My Store Page
		  When user click on first item in TOP SELLERS list
		  And user add the item to cart
		  And user navigate to Cart Summary page
		  Then user confirms that same item is added to the cart
		  And logout the application		  		  