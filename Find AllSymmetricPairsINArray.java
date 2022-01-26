/*
Find All Symmetric Pairs in an Array
Description
Given an array of pairs of integers, find all the symmetric pairs in it. 
Two pairs (a, b) and (c, d) are said to be symmetric if b is equivalent to c and a is equivalent to d.

For example, (10, 20) and (20, 10) are symmetric. It may be assumed that the first element in 
each pair is distinct. 

Note that in the output, you need to print only the first occurring pair out of the two 
symmetric pairs in the given array. For example, if (a, b) and (c, d) are symmetric, 
you will only print the one that occurs first in the given array.

Input Format:
The first line contains an integer representing the number of pairs.
The second line contains the elements of each pair. Each pair has two integers’ so, 
this line contains (number of pairs * 2) elements.

Output Format:
The output contains the first occurring pair in each group of symmetric pairs in each line.

Sample Test Cases:
Input:
5 
31 30 40 50 15 20 50 40 20 15

Output:
40 50
15 20
 
Input:
4
20 40 50 11 10 50 40 20 

Output:
20 40
*/

import java.util.*;

public class Source {

    public static void symmetricPair(int[][] arr) {
        // Write code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int firstElement = arr[i][0];
            int secondElement = arr[i][1];
            Integer data = hashMap.get(secondElement);
            if(data != null && data == firstElement){
                System.out.println(secondElement+" "+ firstElement );
            }
            else {
                hashMap.put(firstElement, secondElement);
            }
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        symmetricPair(arr);
    }
}