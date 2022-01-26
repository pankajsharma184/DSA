/*
Most Frequent Element

Description
Given an array of integers, find the most frequent element in the array. If multiple elements appear a maximum number of times, print any one of them.

Input Format:
The first line contains the size of the array, N.
The second line contains the elements of the array.

Output Format:
The output contains the most frequent element in the array.


Sample Test Cases:
Input:
8
1 3 2 5 2 1 9 2

Output:
2

Input:
8
10 15 12 11 13 12 11 11

Output:
11
*/


import java.util.*;

public class Source {

 public static int mostFrequentElement(int[] arr) {

   // Write code here
   HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else {
                int count = map.get(arr[i]);
                map.put(arr[i],count+1);
            }
        }
        Map.Entry<Integer, Integer> mostFrequent = null;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (mostFrequent == null || entry.getValue().compareTo(mostFrequent.getValue()) > 0)
            {
                mostFrequent = entry;
            }
        }
        return (mostFrequent.getKey());
 }


 public static void main(String[] args) {
    int n;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    System.out.println(mostFrequentElement(arr));
 }
}