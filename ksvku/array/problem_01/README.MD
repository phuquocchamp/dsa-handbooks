### PROBLEM 01

#### Problem 1:  
Give an array X[] of n integers, where some elements are zero and some elements are non-zero. Write a program to move all the zeroes to the end of the array (Propose two ways to solve this problem).  

##### Example:  
**Input:** X[] = [4,8,0,0,2,0,1,0]  
**Output:** [4,8,2,1,0,0,0,0]  

##### Analysis:
- Array Capacity: n elements [0 -> n-1].
- Special Case: Array with all 0 elements.

#### Solution 01: Two For Loop
```java

```
Loop i from left to right:
- if x[i] == 0 (When reach value 0):
  - Loop j at index i and assign a x[j] = x[j + 1];  
  - Assign x[n-1] = 0;

Time Complexity: O(n^2).  
Space Complexity: O(1). 
#### Solution 02: Two Pointers.
```java
public static int[] sol_02(int[] arr) {
        int capacity = arr.length;
        int current = 0;
        int nonZeroIndex = 0;
        while (nonZeroIndex < capacity) {
            if (arr[current] == 0 && arr[nonZeroIndex] != 0) {
                int temp = arr[current];
                arr[current] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                current++;
                nonZeroIndex++;
            }

            if (arr[current] != 0) {
                current += 1;
                nonZeroIndex += 1;
            }
            if (arr[nonZeroIndex] == 0) {
                nonZeroIndex += 1;
            }
        }
        return arr;

    }
```
nonZeroIndex = 0;  
current = 0;  
While nonZeroIndex < Capacity:
- Check if x[current] == 0 && x[nonZeroIndex] != 0:
  - exchange x[current] to x[nonZeroIndex].
- if(x[current] != 0):
  - increase current & nonZeroIndex.
- if(x[nonZeroIndex] == 0):
  - increase nonZeroIndex
Time Complexity: O(n).
Space Complexity: O(1).