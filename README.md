Sales Tax Counter
=================

Sales Tax Counter is a Java project to count the sales tax and total price of a shopping basket. The input is a shopping basket containing the items amount, name and price. The program will calculate and output a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items and the total amounts of sales taxes paid.

Application Design
------------------

This application is designed to match the scope of the problem. As the scope widens (more product types, different taxes) then more development will be needed. For future development discussion, refer to the *Future Development* section at the end of this readme.

The components of the application are as follows:
* A shopping basket containing the purchased products
* A cashier program which reads the shopping baskets, calculates taxes and total, then produces a receipt
* A receipt which lists the items and total costs

The cashier program operates in the following sequence:
* Read the shopping basket (input files in input directory)
* Parse the products information, creates Goods objects
* Calculate sales taxes and imported sales taxes
* Output a receipt (output files in output directory)

Unit Tests
----------

The application is tested using JUnit test cases which can be found in the following files:
* GoodsTest.java : contains the unit tests for tax calculation


Input and Output Files
----------------------

The shopping basket is a text file containing the item information, it is located inside the *input* directory. Likewise, receipt is a text file that is produced by the program in the *output* directory

### Input Files

Example:

	1 book at 12.49
	1 music CD at 14.99
	1 chocolate bar at 0.85

### Output Files

After running the program, depending on the number of input files it will generate receipts.

	1 book: 12.49
	1 music CD: 16.49
	1 chocolate bar: 0.85
	Sales Taxes: 1.50
	Total: 29.83

Running the Application
-----------------------

To run the application, export the project to Eclipse then Run.


Future Development
------------------

* Goods object can be extended to multiple subclass (Book,Food,Medical) to facilitate custom attributes and easier tax calculation
* Input / Output user interface