# rpn-calculator
            Reverse Polish Notation Calculator

The application source code is written in Java and it performs arithmetic calculations ( +,-,* and /) on  given input values as in the below format described.

Eg: To calculate the sum of two numbers the following format should be entered at the command prompt (Windows ) / Terminal (Mac)

> 2
2
>4
4
>+
6

The above format is called Postfix or Reverse Polish Notation where the arithmetic operator appears after the numbers such as

1 2 + 5 - 5 *

In the above scenario

Addition is performed on 1,2 which gives output as 3
The out put 3 is subtracted from 5 gives -2
And then -2 multipled by 5 gives 10.

Technology Stack Used

Java 1.8


To arrive at a solution I have used Stack datastructure for the arithmetic operations, if it is a number push to the stack, if it is a arithmetic operator then perform the operation according to the symbol and output the result.

Extension of this solution: Options I think are to develop a mathematical calculator and give user choices which one to use i.e Regular vs RPN.
Develop a webpage parallel to the UNIX CLI type.

To run the application 

do a maven package, mvn clean package
And run from the terminal / command prompt by running the below command

java -jar npm-calculator-0.0.1-SNAPSHOT.jar




