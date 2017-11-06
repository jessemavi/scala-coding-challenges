object Solution {
    def isValid(s: String): Boolean = {
      // Plan: use a map to store pairs pf parens. Use a stack to add opening parens to. Iterate over string and add opening parens and remove when a matching closing parens is found. Break and return false when a matching paren is not found.

      // Psuedocode:
      //if string length is odd
        // return false
      // else
        // mutable variable for if validParens set to true
        // immutable map to store opening and closing paren pairs as chars
        // mutable stack of chars to add opening parens to
        
        // start breakable block
          // iterate over s
            // if char is a opening paren
            // push it to the stack
          // else if a char is a closing paren
            // if stack is empty
              // set validParens to false
                // break
            // else if char at the top of the stack matches char
              // pop off char at top of stack
            // else
              // set validParens to false
              // break

        // if validParens is true
          // if stack length is not zero
            // set validParens to false

        // return validParens

      import scala.collection.mutable.Stack
      import util.control.Breaks._

      if(s.length % 2 == 1) {
          false
      } else {
        var validParens = true
        val parens = Map('(' -> ')', '{' -> '}', '[' -> ']')
        val stack = Stack[Char]()  
          
        breakable {
          for(i <- 0 until s.length) {
            if(s(i) == '(' || s(i) == '{' || s(i) == '[') {
              stack.push(s(i))
            } else {
              if(stack.size == 0) {
                validParens = false
                break   
              } else if(parens(stack.top) == s(i)) {
                stack.pop
              } else {
                validParens = false
                break
              }
            }
          }
        }

        if(validParens == true) {
          if(stack.size != 0) {
            validParens = false
          }
        }
      
        validParens
      }
    }
}
