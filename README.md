# CS 1501 - Lab #3 (Binary Search Tree)[^1]

## Table of Contents

- [Overview](#overview)
- [Predecessor and Successor](#predecessor-and-successor)
- [Tasks](#tasks)
- [Testing](#testing)
- [Submission](#submission)

## Overview

 __Purpose__: In this lab, you will complete the implementation of methods to find the predecessor and successor of a data item in the Binary Search Tree.
 
 The starter project has been provided to you with the following content:

- `BinarySearchTree.java` - The file you will be editing. `successor` and `findLargest` are given as completed methods; you will write `predecessor` and `findSmallest` by mirroring them. Those two are marked by the `TODO` comments.
- `Main.java` - The tester for your implementation; the data for the tree is included in this file. __Do not modify__.
- `expected-output.txt` - Sample execution and the expected output for the program.

## Predecessor and Successor

The predecessor of a data item in a Binary Search Tree is the largest of all smaller items in the tree or `null` if no smaller item exists in the tree (i.e., the item is the smallest in the tree).
The successor of a data item in a Binary Search Tree is the smallest of all larger items in the tree or `null` if no larger item exists in the tree (i.e., the item is the largest in the tree).

Another definition is:
The predecessor of a data item in a Binary Search Tree is the previous item in the **sorted order** of data items in the tree or `null` if no previous item exists.
The successor of a data item in a Binary Search Tree is the next item in the **sorted order** of data items in the tree or `null` if no next item exists.

__For finding the predecessor of an item:__

- First, find the node that contains the item.
- If the node has a left subtree, the predecessor for the node will be the largest item in the left subtree.
- Otherwise, the node's predecessor will be its deepest "right ancestor" (i.e., the first node found while climbing up from the node to the root for which the node is in the right subtree). If that ancestor doesn't exist, then the node's predecessor is `null`.

__For finding the successor of an item:__

- First, find the node that contains the item.
- If the node has a right subtree, the successor for the node will be the smallest item in the right subtree.
- Otherwise, the node's successor will be its deepest "left ancestor" (i.e., the first node found while climbing up from the node to the root for which the node is in the left subtree). If that ancestor doesn't exist, then the node's successor is `null`.

## Tasks

In this lab, we will complete the implementation of methods to find the predecessor and the successor of any given data item in the tree.

The tree creation portion is finished for you. The `successor` method and the `findLargest` helper method are also finished for you - read through them carefully, since they're the model for what you'll write.

Your two tasks are to write:
- `predecessor(BinaryNode<T>, T)` - the mirror image of `successor`, with "left"/"right" and "largest"/"smallest" swapped.
- `findSmallest(BinaryNode<T>)` - the mirror image of `findLargest`, moving left instead of right.

Each method's comment gives you the steps in order, but unlike the given methods, you're writing the full body yourself rather than filling in single lines - use the completed methods above each one as your reference for the surrounding structure (variable names, base cases, recursive calls).

## Testing

Compile the Java file after completing the tasks. Once compiled, you can run the class file without command-line arguments.

``` powershell
cd #YOUR_LAB3_DIRECTORY
javac *.java 
java Main
```
You can also [run the program directly from VS Code](https://code.visualstudio.com/docs/java/java-tutorial). 

The input for execution and the corresponding expected output can be found in `expected-output.txt`.

## Submission

- The only file you're allowed to modify is the `BinarySearchTree.java` file.
- `commit` and `push` the finished code to your GitHub repository. You can check the following [page](https://code.visualstudio.com/docs/sourcecontrol/github) to set up GitHub access directly from VS Code. If you think the commit command hangs in VS Code, it probably asks for a commit message in an open file. You would then need to enter a message and close the file before it can commit to GitHub.
- Submit your Github repository to GradeScope for automatic grading.
  
Note: If you use an IDE, such as NetBeans, Eclipse, or IntelliJ, to develop your programs, make sure the programs will compile and run on the command line before submitting – this may require some modifications to your program (e.g., removing package information).
[^1]: Contributed by [Alex Zhou](https://github.com/yuz727)
