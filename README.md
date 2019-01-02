# kotlin-high-order-function (Functional Programing:)
In Kotlin, functions are first-class citizen. It means that functions can be assigned to the variables, passed as an arguments or returned from another function. 
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

