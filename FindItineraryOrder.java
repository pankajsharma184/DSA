/*
Find Itinerary in Order
Description
Given a list of tickets in pairs as source city and destination city, 
find the itinerary in order using the given list.

Note that the given list of tickets is non-cyclic and there is one ticket from each city except 
the destination city.

Input Format:
The first line contains an integer N representing the number of tickets.
For the next N lines, each line contains a ticket representing the source city and the destination city.

Output Format:
Print ‘Invalid Input’ if the start city is null, else print city in an itinerary in order, a pair in each line as shown below:
Bangalore->Ranchi 
Ranchi->Jamshedpur

Sample Test Cases:
Input:
4
Bangalore Ranchi
Jamshedpur Kolkata
Ranchi Jamshedpur
Kolkata Varanasi

Output:
Bangalore->Ranchi
Ranchi->Jamshedpur
Jamshedpur->Kolkata
Kolkata->Varanasi 

Input:
4
Chennai Bangalore
Bombay Delhi
Goa Chennai
Delhi Goa

Output:
Bombay->Delhi
Delhi->Goa
Goa->Chennai
Chennai->Bangalore

*/

import java.util.*;

public class Source {

    public static void findItinerary(Map<String, String> tickets) {
        // Write code here
        String startingCity = null;
        String destinationCity;
        Map<String, String> reverseMap = new HashMap<String, String>();
        for(Map.Entry<String, String > entry: tickets.entrySet()){
            reverseMap.put(entry.getValue(),entry.getKey());
        }
        for(Map.Entry<String, String > entry: tickets.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                startingCity = entry.getKey();
                break;
            }
        }
        if(startingCity == null){
            System.out.println("Invalid Input");
        }
        destinationCity = tickets.get(startingCity);
        while (destinationCity != null){
            System.out.println(startingCity+"->"+ destinationCity);
            startingCity = destinationCity;
            destinationCity = tickets.get(startingCity);
        }

    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}