# BST vs Hash Table

## Introduction

This project compares two data structures: Binary Search Tree (BST) and Hash Table.

The main goal is to compare their insertion, search, and deletion performance for different numbers of elements.

The experiment was performed with 100, 1000, and 10000 elements.

## Data Structures

### Binary Search Tree

A Binary Search Tree stores values in a tree structure.

For every node:

- values smaller than the node are stored on the left;
- values larger than the node are stored on the right.

The main operations are insertion, search, and deletion.

### Hash Table

A Hash Table stores elements using a hash function.

In this project, the hash function is:

    index = key % tableSize

Collisions are handled using separate chaining with LinkedList.

## Complexity Analysis

| Operation | BST Average | BST Worst | Hash Table Average | Hash Table Worst |
|-----------|-------------|-----------|--------------------|------------------|
| Insert    | O(log n)    | O(n)      | O(1)               | O(n)             |
| Search    | O(log n)    | O(n)      | O(1)               | O(n)             |
| Delete    | O(log n)    | O(n)      | O(1)               | O(n)             |

The BST has O(log n) average complexity when the tree is reasonably balanced.
In the worst case, the tree can become unbalanced and the operations can take O(n).

Hash Table operations are O(1) on average because the hash function usually allows direct access to an element.
However, many collisions can make an operation O(n) in the worst case.

## Experimental Setup

The experiment was performed for:

- 100 elements
- 1000 elements
- 10000 elements

For each input size, insertion, search, and deletion were measured.

Execution time was measured using Java's `System.nanoTime()`.

The results were saved in CSV format and also organized in an Excel file.

## Experimental Results

### 100 elements

| Structure | Insert (ns) | Search (ns) | Delete (ns) |
|-----------|-------------|-------------|-------------|
| BST | 5287900 | 5615800 | 480700 |
| HashTable | 209400 | 53300 | 67200 |

For 100 elements, the Hash Table was faster for all three operations.

### 1000 elements

| Structure | Insert (ns) | Search (ns) | Delete (ns) |
|-----------|-------------|-------------|-------------|
| BST | 369300 | 317800 | 355500 |
| HashTable | 685300 | 394500 | 499400 |

For 1000 elements, the BST was faster in all three measured operations.

### 10000 elements

| Structure | Insert (ns) | Search (ns) | Delete (ns) |
|-----------|-------------|-------------|-------------|
| BST | 17933700 | 10130200 | 5012300 |
| HashTable | 4820900 | 1829200 | 2858600 |

For 10000 elements, the Hash Table was faster in all three operations.

## Analysis

The experimental results show that the Hash Table generally provides better performance, especially when the number of elements increases.

However, the results for 1000 elements show that the BST was faster in this particular experiment. This does not contradict the theoretical complexity because Big-O describes how performance grows with input size, while actual execution time can be affected by implementation details and other factors.

For 10000 elements, the difference becomes more noticeable. The Hash Table was faster for insertion, search, and deletion.

The results also show that theoretical complexity and real execution time are related, but they are not exactly the same.

## Conclusion

Both data structures have advantages.

A BST is useful when data needs to be organized according to its values and when ordered traversal is important.

A Hash Table is useful when fast average insertion, search, and deletion are required.

Based on the experiment, the Hash Table showed better overall performance for the largest input size.