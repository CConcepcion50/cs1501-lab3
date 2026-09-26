/** A Binary Search Tree with predecessor and successor lookup.
* There are two parts to be implemented by students: predecessor(BinaryNode, T)
* and findSmallest(BinaryNode). successor(BinaryNode, T) and findLargest(BinaryNode)
* are given as completed reference methods to model your work after.
*/
public class
  BinarySearchTree<T extends Comparable<? super T>> {
    BinaryNode<T> root;

    public BinarySearchTree(){
      root = null;
    }


    public T add(T entry){
      T result = null;
      if(root == null){
        root = new BinaryNode<>(entry);
      } else {
        result = addEntry(root, entry);
      }
      return result;
    }

    private T addEntry(BinaryNode<T> root, T entry){
      T result = null;
      int comparison = root.data.compareTo(entry);
      if(comparison == 0){
        result = root.data;
        root.data = entry;
      } else if(comparison < 0){
        if(root.right != null){
          result = addEntry(root.right, entry);
        } else {
          root.right = new BinaryNode<>(entry);
        }
      } else {
        if(root.left != null){
          result = addEntry(root.left, entry);
        } else {
          root.left = new BinaryNode<>(entry);
        }
      }
      return result;
    }

    public T predecessor(T entry){
        BinaryNode<T> predNode = predecessor(root, entry);
        if(predNode != null){ //found a predecessor node
          return predNode.data;
        } else {//entry is the smallest in the tree; no predecssor
          return null;
        }
    }

    private BinaryNode<T> predecessor(BinaryNode<T> root, T entry){
      BinaryNode<T> result = null;
 
      if(root != null){
        int compareResult = root.data.compareTo(entry);
        if(compareResult == 0){ 
          result = findLargest(root.left);
        } else if(compareResult > 0){
          result = predecessor(root.left, entry);
        } else { 
          result = predecessor(root.right, entry);
          if(result == null){ 
            result = root;
          }
        }
      }
      return result;
      // TODO (~18 lines): Write this method's full logic. It's the mirror image
      // of the completed successor(BinaryNode<T>, T) method above - same structure,
      // but with "left"/"right" and "largest"/"smallest" swapped.
      //
      // Steps:
      //   1. If root is null, there's nothing to search - return null.
      //   2. Compare root.data to entry using compareTo(). Store the result.
      //   3. If the comparison is 0 (this is the node we're looking for):
      //      the predecessor is the LARGEST item in the LEFT subtree.
      //      Use findLargest(root.left) to get it.
      //   4. If entry is smaller than root's data (comparison > 0): the entry is
      //      somewhere to the left, so move left - recursively call
      //      predecessor(root.left, entry).
      //   5. If entry is larger than root's data (comparison < 0): the entry is
      //      somewhere to the right, so move right - recursively call
      //      predecessor(root.right, entry).
      //        - If that recursive call comes back null, it means no predecessor
      //          was found further down. In that case, root itself is the deepest
      //          "right ancestor," so it becomes the predecessor - assign root to
      //          your result variable.
      //   6. Return your result.

      //return null; // placeholder - replace with your implementation
    }

    public T successor(T entry){
      BinaryNode<T> succNode = successor(root, entry);
      if(succNode != null){ //found a successor node
        return succNode.data;
      } else {//entry is the largest in the tree; no successor
        return null;
      }
    }

    private BinaryNode<T> successor(BinaryNode<T> root, T entry){
      BinaryNode<T> result = null;

      if(root != null){
        int compareResult = root.data.compareTo(entry);
        if(compareResult == 0){ //found the node;
                                //successor is the smallest in right subtree
          result = findSmallest(root.right);
        } else if(compareResult < 0){ //entry > root; move right
          result = successor(root.right, entry);
        } else { //entry < root; move left
          result = successor(root.left, entry);
          if(result == null){ //couldn't find a successor;
                              //the first left parent (root) is the successor
            result = root;
          }
        }
      }
      return result;
    }

    private BinaryNode<T> findLargest(BinaryNode<T> root){
        BinaryNode<T> result = null;
        if(root != null){
          if(root.right != null){
            result = findLargest(root.right);
          } else {
            result = root;
          }
        }
        return result;
    }

    private BinaryNode<T> findSmallest(BinaryNode<T> root){
        BinaryNode<T> result = null;
        if(root != null){
          if(root.left != null){
            result = findSmallest(root.left);
          } else {
            result = root;
          }
        }
        return result;
      // TODO (~8 lines): Write this method's full logic. It's the mirror image
      // of findLargest(...) right above it - same structure, but moving left
      // instead of right.
      //
      // Steps:
      //   1. If root is null, return null.
      //   2. If root.left is not null, the smallest node is further down - recursively
      //      call findSmallest(root.left).
      //   3. Otherwise (root.left is null), this root has no smaller node below it,
      //      so root itself is the smallest - use it as your result.
      //   4. Return your result.

      //return null; // placeholder - replace with your implementation
    }

    private class BinaryNode<T> {
      private T data;
      private BinaryNode<T> left;
      private BinaryNode<T> right;

      public BinaryNode(T data){
        this(data, null, null);
      }

      public BinaryNode(T data, BinaryNode<T> left,
                       BinaryNode<T> right){
          this.data = data;
          this.left = left;
          this.right = right;
      }
    }
}
