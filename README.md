Tools:
Java 11
Spring Boot

------------------------------------------------------------------------

Read files in %HOMEPATH%/data/in with specifications:

Salesman data has the format id 001 and the line will have the following format:
• 001çCPFçNameçSalary

Customer data has the format id 002 and the line will have the following format:
• 002çCNPJçNameçBusiness Area

Sales data has the format id 003. Inside the sales row, there is the list of items, which is
wrapped by square brackets []. The line will have the following format:
• 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

Write files in %HOMEPATH%/data/out with results:

• Amount of clients in the input file
• Amount of salesman in the input file
• ID of the most expensive sale
• Worst salesman ever
