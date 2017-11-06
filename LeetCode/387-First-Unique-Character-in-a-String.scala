object Solution {
    def firstUniqChar(s: String): Int = {
      // Plan: Iterate over the string and store each character with its index and frequency in a map(mutable). Iterate over the string and if a character has a frequency of 1 in the map return its index.

      // Psuedocode:
      // set indexToReturn mutable variable to -1 by default

      // create a mutable map to store character with its index and frequency

      // set breakable block of code to throw an exception
        // iterate over s
          // if char is not in map
            // add char and a an array with index and 1 to the map
          // else if char exists in map
            // increment char frequency im map

      // iterate over map
        // if char has a frequency of 1
          // set indexToRetunr to char index in map

      // return indexToReturn
        
      import util.control.Breaks._

      var indexToReturn = -1

      val charIndexAndFreq = scala.collection.mutable.Map[Char, Array[Int]]()

      for(i <- 0 until s.length) {
        if( !charIndexAndFreq.contains(s(i)) ) {
          charIndexAndFreq(s(i)) = Array(i, 1)
        } else if( charIndexAndFreq.contains(s(i)) ) {
          charIndexAndFreq(s(i))(1) += 1
        }
      }

      breakable {
        for(i <- 0 until s.length) {
          if( charIndexAndFreq(s(i))(1) == 1 ) {
            indexToReturn = charIndexAndFreq(s(i))(0)
            break
          }
        }
      }

      indexToReturn
    }
}
