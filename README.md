# kotlin-high-order-function (Functional Programing:)
- In Kotlin, functions are first-class citizen. It means that functions can be assigned to the variables, passed as an arguments or 
  returned from another function. 
- Before we jupped into higher order function, we can have quick description on  functions in Kotlin.
  #### Function 
  - A function is a group of related statements that perform a specific task.
  - In Kotlin, a function generally looks like the following:
```
  fun functionName(parameter1:DataType1, parameter2:DataType2,...): ReturnType { 
      //do your stuff here
      return value/object
  }
```
  #### Extension functions
  - Extension functions are like an ad hoc function on top of an existing datatype/class.
  ```
    fun String.countWords():Int { 
         return trim()..size
    }
  ```

   - We declared the function as String.countWords(),that means it should be called on a String instance now
   
  #### Function type
  - While Kotlin is statically typed, to make it possible, functions need to have a type. It exists and it is called function type
    - ```()->Unit``` : the function type that returns nothing useful (Unit) and takes no arguments.
    - ```(Int)->Int``` :the function type that returns Int and takes single argument of type Int.
    - ```()->()->Unit``` : the function type that returns another function that returns nothing useful (Unit). Both functions take no 
    arguments.
  - We can also use them to type local variables, properties or arguments:
    - ```val greet: ()->Unit```
    - ```val square: (Int)->Int```
    - ```val producePrinter: ()->()->Unit```
  #### Function literal
  function literal is a special notation used to simplify how a function is defined.There are two types of function literals in Kotlin:
    - Lambda expression
    - Anonymous function
    
 ---------------------------------------------------
  #### First-class functions
  Kotlin functions are first-class citizens, which means they can be stored in variables and data structures, passed as arguments to
  and returned from other functions
  The advantages of first-order functions are, when we want to write a function that can work for many scenarios.
  #### Higher-order-function
  A higher order function is a function that either accepts another function as a parameter or returns a function as its return value, or 
  both.Lets take example
  

  
     ```
       fun stringOperation(str: String, fn: (String) -> String): Unit {
         val applied = fn(str)
         println(applied)
      }
    ```
   -  we have defined a function stringOperation with two parameters,
      - The first parameter is str which is of string type, 
      - Second is a function fn from string to string (it means, second parameter is function accepts a string input and returns another 
      string as the output). Also note the syntax we used to define the function parameter. 
        - The input types are wrapped in parentheses (String)
        - The output type is separated by a thin arrow.
   - If a function receives a lambda as the last parameter, the lambda can be passed outside the parentheses:
     ```
     stringOperation("Hello World"){ str -> str.substring(0..1) }
     
     ```
   - Example for Sting operation is [here](https://github.com/AnerayeVijay/kotlin-higher-order-function/blob/master/src/test/kotlin/com/vijayaneraye/string/StringOperationTest.kt)
  

    
## Type Alias 
 - Type alias allow us to declare alternative type that is simply alias of an existing type
 - Type alias provides a way to define names of types that already exist. Type alias can help to make complex types easier to read, and
   can also provide other hints.
 - Instead of typing the function type every time when defining a property, we can use typealias as shown below.
 - Type aliases allow developers to define synonyms for pre-existing types.
 - You can use typealias for most any type: classes, enums, structs, tuples, closures, etc. Here are a few examples.
    - typealias Name = String
    - typealias Employees = Array<Employee>
    - typealias GridPoint = (Int, Int)
    - typealias CompletionHandler = (ErrorType?) -> Void

  
---------------------------------
## Developers: Getting Started

```sh
# Install Homebrew (see https://brew.sh).
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# Install Java 8.
brew tap caskroom/versions
brew cask install java8

# Checkout the monorepo:
git clone https://github.com/AnerayeVijay/kotlin-high-order-function.git
```
### Running the Applications

- Go inside `kotlin-beginner`
- Open the project in IntelliJ IDEA
  1. Tell it to overwrite `.idea`, then revert all changes IntelliJ made to that directory
  2. You can run the test cases through IntelliJ or
   run ```gradle build``` from terminal or commandprompt 

