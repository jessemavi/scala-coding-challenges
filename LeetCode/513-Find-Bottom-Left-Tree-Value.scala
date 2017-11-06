/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def findBottomLeftValue(root: TreeNode): Int = {
      // Plan: Traverse through the tree lookign at left children first and keep track of current level and leftmostValue level. If current level is greater than leftmostValueLevel, update leftmost value and leftmostValueLevel

      // Psuedocode:
      // mutable variable for leftmostValue set to root value(takes care of edge case where tree has only one node)
      // mutable variable for deepestLevel set to 0

      // traverseTree function(node, currentLevel):
        // if currentLevel is greater than leftmostValueLevel
          // set leftmostValue to node value
          // set leftmostValueLevel to currentLevel
        // if node has a left child
          // recurse on left child passing in currentLevel + 1
        // if node has a right child
          // recurse on right child

      // invoke traverseTree with root and 0

      // return leftmostValue

      var leftmostValue = root.value
      var leftmostValueLevel = 0
      
      def traverseTree(node: TreeNode, currentLevel: Int): Unit = {
        if(currentLevel > leftmostValueLevel) {
            leftmostValue = node.value
            leftmostValueLevel = currentLevel
        }
        if(node.left != null) {
          traverseTree(node.left, currentLevel + 1)
        }
        if(node.right != null) {
          traverseTree(node.right, currentLevel + 1)
        }
      }
      
      traverseTree(root, 0)
      
      leftmostValue
    }
}
