/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
      // Inorder -> left child, parent, right child
      // Recursive solution
      // Plan: traverse through the tree recursing on a node's left child, adding the node's value to a list then recursing on its right child
        
      // import list buffer

      // Psuedocode:
      // if root is null
        // return empty list
      // else
        // create nodeValues mutable ListBuffer

        // traverseTree function(node):    *function doesn't return anything*
          // if node has a left child
            // recurse on left child
          // add node's value to nodeValues
          // if node has a right child
            // recurse on right child

        // invoke traverseTree function with root

        // return nodeValues converted to a list

      import scala.collection.mutable.ListBuffer

      if(root == null) {
        List()
      } else {
        val nodeValues = ListBuffer[Int]()

        def traverseTree(node: TreeNode): Unit = {
          if(node.left != null) {
            traverseTree(node.left)
          }

          nodeValues += node.value

          if(node.right != null) {
            traverseTree(node.right)
          }
        }

        traverseTree(root)

        nodeValues.toList
      }
        
    }
}
