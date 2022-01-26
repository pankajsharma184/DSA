/*
Find Sum Between pth and qth Smallest Element
Description
Given an array and two numbers p and q, find the sum of all the elements of the array such 
that the range of the elements is between the pth and qth smallest elements of the array.

It may be assumed that (1 <= p < q <= n) and all elements of the array are distinct.

Input Format:
The first line contains an integer ‘N’ as the size of the array.
The second line contains the elements of an array of size ‘N’.
The third line contains an integer ‘p’.
The fourth line contains an integer ‘q’.

Output Format:
The output contains the sum of all the elements of the array such that the range of the elements 
is between the pth and qth smallest elements of the array.

Sample Test Cases:
Input:
7
30 18 32 14 22 20 24
3
6

Output:
46

Input:
8
12 20 10 30 15 11 16 20
2
7


Output:
63
*/

import java.util.*;

public class Source {

    public static int sumBetweenPthToQthSmallestElement(int[] arr, int p, int q) {

       // Write code here
         TreeSet<Integer> treeSet = new TreeSet<>();
        Integer sortedArr[] = new Integer[arr.length];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            treeSet.add(arr[i]);
        }
        for (int i = p; i < q-1;i++){
            sortedArr = treeSet.toArray(sortedArr);
            sum += sortedArr[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(sumBetweenPthToQthSmallestElement(arr, p, q));
    }
}