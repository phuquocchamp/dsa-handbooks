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
public static int[] sol_01(int[] arr){
    int capacity = arr.length;

    for (int i = 0; i < capacity; i++) {
        if (arr[i] == 0) {
            for (int j = i; j < capacity - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[capacity - 1] = 0;
            capacity--;
            i--;
        }
    }
    return arr;
}
```
##### Ý tưởng:  
Duyệt mảng i đến khi gặp giá trị 0 thì chuyển dời các phần từ phía sau phần tử 0 hiện tại sáng trái một đơn vị. 

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
##### Ý tưởng:
- Duyệt mảng đến khi gặp giá trị 0 thì đổi giá trị cho phần từ khác 0 gần nhất.
Sử dụng 2 Pointers: 
  - Xét trường hợp giá trị x[current] == 0 && x[nonZeroIndex] != 0 => đổi chỗ gía trị cho nhau.  
  - Nếu x[current] != 0: Cập nhật current & nonZeroIndex.
  - Nêu x[nonZeroIndex] == 0: Tăng nonZeroIndex;  

Time Complexity: O(n).  
Space Complexity: O(1).