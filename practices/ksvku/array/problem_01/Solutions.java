package array.problem_01;

/*
Problem 1:
Give an array x[] of n integers, where some elements are zero and some elements are non-zero.
Write a program to move all the zeroes to the end of the array (Propose two ways to solve this problem)
Example:
    Input: X[] = [4,8,0,0,2,0,1,0]
    Output: [4,8,2,1,0,0,0,0]

*/


public class Solutions {
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

    public static void main(String[] args) {
        int[] list = {0, 8, 0, 0, 0, 1, 1, 0};
        int n = list.length;
        int[] sol1Ans = sol_02(list);
        for(int value : sol1Ans){
            System.out.print(value + " ");
        }
    }
}
