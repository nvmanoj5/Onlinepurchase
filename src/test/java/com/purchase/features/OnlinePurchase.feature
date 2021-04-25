Feature: product purchase


@Dresspurchase
Scenario Outline: Validate the purchased dress details

Given Open the online purchase application
When login into the application with valid "<username>" username and "<password>" password
And Click the dresses tab and choose the casualdresses
And click more button for product details
And Verify the product details if the product details has "<productDetails>" this information
And Verify the product price "<price>"  size "<size>" size1 "<size2>" and colour "<colour>" colour2 "<colour2>"
Then Purchase the dress 


Examples:

|username|password|productDetails|price|size|size2|colour|colour2|
|nvmanoj5@gmail.com|12345|100% cotton|$50|S|M|Orange|Blue|