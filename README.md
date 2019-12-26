# Functions in Kotlin (Functional Programing:)
- In Kotlin, functions are first-class citizen. It means that functions can be assigned to the variables, passed as an arguments or 
  returned from another function. 
- Before we jupped into higher order function, we can have quick description on  functions in Kotlin.
 #### Function 
  - A function is a group of related statements that perform a specific task.
  - In Kotlin, a function generally looks like the following:
```kotlin
  fun functionName(parameter1:DataType1, parameter2:DataType2,...): ReturnType { 
      //do your stuff here
      return value/object
  }
```
 ---------------------------------------------------

  #### Extension functions
  - Extension functions are like an ad hoc function on top of an existing datatype/class.
  ```kotlin
    fun String.countWords():Int { 
         return trim()..size
    }
  ```

  - We declared the function as String.countWords(),that means it should be called on a String instance now
 ---------------------------------------------------  
  #### Function type
  -  In Kotlin, you can store Lambda in a variable,to make it possible, variable need to have a type
  -  If we specify this type explicitly,we'll see a so-called function type.
  - While Kotlin is statically typed, to make it possible, functions need to have a type. It exists and it is called function type
    - ``` ()->Unit``` : the function type that returns nothing useful (Unit) and takes no arguments.
    - ```(Int)->Int``` :the function type that returns Int and takes single argument of type Int.
    - ```()->()->Unit``` : the function type that returns another function that returns nothing useful (Unit). Both functions take no 
    arguments.
    
      ```kotlin
           val sum = {a: Int,b: Int -> a + b}
      ```
  - If we have to specify type explicitly then code looks like parameter types are written inside the parentheses and then an arrow,then 
    the return type
    ```kotlin
     val sum : (Int,Int) -> Int = { a, b -> a + b}
    ```
  - In above example this is function type takes two integer parameters and returns an integer as a resul

  ##### Calling stored function
     - You can call a variable a function type as a regular function by providing all the necessary arguments
          ```kotlin
          val add : (Int,Int) -> Int = { a, b -> a + b}
          val result: Int = add (1,2)
          ```
     - When you store a Lambda in a variable, you can pass this variable whenever an expression of function type is expected
    for example , for collection 

          ```kotlin
          val list = listOf(1,2,3,4,5,6,7,8,9,10)

          val isEven : (Int) -> boolean = {it % 2 == 0}

          list.any(isEven) //return true
          list.filter(isEven) // returns 2,4,6,8,10
          ```
   #### Calling Member reference in Function 
    - The syntax for member reference is the same as in Java
    - In Kotlin you can store Lambda in a variable, however, you can't store a function in a variable. It's not like in a truly functional
      language where each function is a variable.
    - In Kotlin there is a clear distinction between functions and variables,
      ```kotlin
       fun isOdd (a:Int) : Boolean = a % 2 != 0
       // You can't store function in variable
       val predicates = add // Compile error
      ```
    - To solve this issue use Functional reference instead
    - Function references allow you to store a reference to any defined function in a variable to be able to store it and qualitative it
      ```kotlin
       fun isOdd (a:Int) : Boolean = a % 2 != 0
       val predicates = ::add  // No Compilation error
      ```
     - Member references allow you to hide all the parameters, because the compiler infers the types for you.
     - If a reproach member is a property, or it's a function that takes zero or one argument, then member reference syntax looks like
         ```kotlin
            val action = { person: Person, message: String -> sendNotificaiont(person,message)}

            val action = ::sendNotification
        ``` 
    - If the reproached function takes several arguments,you have to repeat all the parameter names as Lambda parameters, and then 
      explicitly pass them through,that makes this syntax robust
      
     - We can also use them to type local variables, properties or arguments:
      - ```val greet: ()->Unit```
      - ```val square: (Int)->Int```
      - ```val producePrinter: ()->()->Unit```
    ##### Passing function reference as argument
     ```kotlin
       fun isEven (i: Int) : Boolan = { i%2 == 0 }
       val list = listOf(1,2,3,4,5,6,7)
       list.any(::isEven)
       list.filter(::isEven)
     ```  
    #### Bound vs Non-Bound Reference
    - Non-Bound reference is  not bound to any specific instance and you can call it on any object of the that class
    
      ```kotlin
      data class Student (val name: String, percentage: Int){
          fun average (percentageLimit: Int) = percentage > percentageLimit
      }

      val avgPredicate: (Studen,Int) -> Boolean = Student::average

      val john = Student("John, Ray",80)
      avgPredicate(john,40)

      //If we look under the hood and check what Lambda does correspond to this member reference, we will find that this Lambda takes two 
      arguments,
      //student and avgPercentage limit,it simply calls the member function is older inside on the past personnel element
      //val avgPredicate: (Studen,Int) -> Boolean = { student,perLimit -> student.average(perLimit)

      ```
     - Bound reference is a member reference that is attached to a specific instance of the class
    
        ```kotlin
        data class Student (val name: String, percentage: Int){
            fun average (percentageLimit: Int) = percentage > percentageLimit
        }
        val john = Student("John, Ray",80)

        val avgPredicate: (Int) -> Boolean = john::average
        avgPredicate(45)
        ```   
     - Member reference can be bound to this reference.Here, we'll return a predicate directly from the class student.
        ```kotlin
        data class Student (val name: String, percentage: Int){
            fun average (percentageLimit: Int) = percentage > percentageLimit
            fun getAvgPredicate() = ::average
        }
        ```
 ---------------------------------------------------

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

