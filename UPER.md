<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Write a simple console application focusing highly on approach and correctness.
* Put everything I have learned so far in OOP, OOD, SOLID principles and TDD.
* Will need to use a testing framework like JUnit5 or TestNG.
* Assignment describes to build an application that takes inputs for a various set of products and prints out receipt details for various shopping baskets.
* Keep in mind to adhere to all business requirements.
*
*
*
<h2>
    2. Planning the Solution
</h2>
* I've built several console applications so no issue here but this time we should focus on code quality.
* I will approach this problem with a TDD approach. TDD is new to me so I must make sure each step I'm sticking to TDD.
* I believe that as I implement the solution I will find opportunities to refactor parts of my solution to improve code quality.
* I will go with JUnit5 as my testing framework. This framework is chosen since it is the one taught to me. 
* I will jot down all the business requirements and write tests for each one failing first, passing second, and refactoring last.
* I see that I will need to figure out how to round to the nearest nickle.
* I plan to create a design pattern, not sure which or how many but I bet I can create a singleton somewhere.
* Final plan is to create Receipt class and allocate another class to print my Receipt (to keep Receipt as Single Responsibilty)
<h2>
    3. Executing the Plan
</h2>
* Started IntelliJ and will import as Java project to have a proper src folder and I will now setup my project with test directory and JUnit5.
* After I will build out the skeleton of my application and write my first test, making sure that it fails first.
* Created the first test for a general product sales tax
* Created the second test for an exempt product sales tax
* Created the tests for the rest of the business requirements.
* I need to implement a design pattern and I chose a singleton for the SalesCalculator, since there is only need for only one in my application.
* I will not implement the main method into the SalesCalculator because I want to follow Single Responsibility for the class so I will need to create another class to have main. 
* Created a Receipt class which was based on my ReceiptTest and did refactoring.
  
<h2>
    4. Reflection / Refactor
</h2>
* After creating my first test, following TDD protocol. I realize that tests can truly drive the way I write my program.
* After second test creation, I see that I will need to implement OOP principles like Inheritance, Abstraction, Encapsulation and Polymporphism.
* Realized that I did not know how to round to the nearest nickle. Luckily I found the solution on stackoverflow.
* Also noticed that I can make a singleton design pattern for my SalesCalculator object.
* Now I will need to grab user input and print to the console screen the receipt since now I have written all the tests for my business requirement.
* After refactoring ReceiptTest and Receipt, TDD process drove me to write a ProductLineItem class.
* This is my first time with working in a TDD assignment. I felt confident when I first started with this TDD assignment when implementing my SalesCalculatorTest. As I was getting towards the end of the requirements like the printing requirements, I saw the opportunity for more Test classes like ReceiptTest. 
* Not sure on how many more test classes I should have built and TDD module did not cover writing tests for business requirements like ouput printing. 