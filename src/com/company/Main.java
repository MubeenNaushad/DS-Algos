package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float[] sortedarray = {1.2f, 2.3f, 4.6f, 6.2f, 8.1f, 9.5f, 11.2f, 15.7f};
        int[] array = {16, 12, 2, 15, 20, 6, 9};
        int input = -1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter:\n1. Recursive Binary Search\n2. Recursive Ternary Search\n3. Recursive Insertion Sort\n4. Iterative Selection Sort\n5. Recursive Quick Sort.");
        input = scn.nextInt();
        if (input == 1){
            System.out.println("Enter value to find: ");
            float sv = scn.nextFloat();
            recursiveBinaryS(sortedarray, 0, sortedarray.length, sv);
        }
        else if(input == 2) {
            System.out.println("Enter value to find: ");
            float sv = scn.nextFloat();
            recursiveTernaryS(sortedarray, 0, sortedarray.length-1, sv);
        }
        else if(input == 3) {
            recursiveInsertionSort(array, 0);
            System.out.println(Arrays.toString(array));
        }
        else if(input == 4) {
            SelectionSort(array);
            System.out.println(Arrays.toString(array));
        }
        else if(input == 5) {
            recursiveQuickSort(array, 0, array.length-1);
            System.out.println(Arrays.toString(array));
        }

    }

    public static void recursiveBinaryS(float[] arr, int start, int end, float inp){ // O(logn)

        int mid = (end+start)/2; // Calculate mid value.

            if (arr[mid] == inp) { // If input is at mid
                System.out.println(mid); // then print mid index.
            } else if (inp < arr[mid]) { // If less then mid
                recursiveBinaryS(arr, start, mid - 1, inp); // Then call function again, and reduce right to mid-1.
            } else if (inp > arr[mid]) { // If value is greater than mid
                recursiveBinaryS(arr, mid + 1, end, inp); // Then call again and increase left to mid+1.
            } else { // If not found
                System.out.println("Not found."); // Print not found.
            }
    }

    public static void recursiveTernaryS(float[] arr, int left, int right, float val){ // O(log base 3 n)
        int partition = (right - left) / 3; // Find partition to divide array in 3 parts.
        int mid1 = left + partition; // Calc mid 1.
        int mid2 = right - partition; // Calc mid 2.

        if(arr[mid1] == val){ // If found at mid 1
            System.out.println( mid1 ); // Print index of mid1
        }
        else if (arr[mid2] == val){ // If found at mid 2.
            System.out.println( mid2 ); // Print index of mid1
        }
        else if (val < arr[mid1]){ // If less than mid 1
            recursiveTernaryS(arr, left, mid1-1, val); // Reduce right to mid 1 -1.
        }
        else if (val > arr[mid2]){ // If greater than mid 2,
            recursiveTernaryS(arr, mid2+1, right, val); // Increase left to mid 2 + 1.
        } else
        recursiveTernaryS(arr, mid1+1, mid2-1, val); // If in between mid 1 and 2, then calc.
    }

    public static void recursiveInsertionSort(int[] arr, int i){ // O(n^2)
        if (i == arr.length) // If i is incremented to max,
            return; // then end.

        int key = arr[i]; // assign first value as key
        int j = i - 1; // j is less than i by one
        while (j>= 0 && arr[j] > key) { // while j is greater than 0 and value is greater than first value
            arr[j+1] = arr[j]; // Swap through incrementing
            j--; // Decrement j
        }
        arr[j+1] = key; // Assign key value to first.
        recursiveInsertionSort(arr, i+1); // Iterate by calling function
    }

    public static void SelectionSort(int[] arr){ // O(n^2)
        int max = -1; // Initiliaze -1 to max variable.
        for (int i = 0; i < arr.length-1; i++) { // Start one loop
            max = i; // Assign max variable ith index.
            for (int j = i+1; j < arr.length; j++) { // run from front of i to end.
                if(arr[j] > arr[max]){ // If curr value is greater than max.
                    max = j; // assign max to curr index.
                }
                if(max != i){ // if i is not assigned to max.
                    int temp = arr[i]; //Swap
                    arr[i] = arr[max];
                    arr[max] = temp;
                }
            }
        }
    }

    public static void recursiveQuickSort(int[] arr, int start, int end){
        if (start >= end)
            return;

        int diff = partition(arr, start, end);
        recursiveQuickSort(arr, start, diff-1);
        recursiveQuickSort(arr, diff+1, end);

    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int boundary = start - 1;
        for (int i = start; i <= end; i++) {
            if(arr[i] < pivot){
                int temp = arr[i];
                arr[i] = arr[++boundary];
                arr[boundary] = temp;
            }
        }

        return start;
    }

}
