
package searchandsort;

import java.util.Scanner;

public class SearchAndSort {
    
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String arr[] = {"a","b","c", "d", "e", "f", "g"};
        int arr2[] = {2,4,5,7,1,3,6,9,8};
        String target = "c";
        System.out.println("Press 1 for Sequential search");
        System.out.println("Press 2 for Binary search");
        System.out.println("Press 3 for Bubble search");
        
        int choice = rd.nextInt();
        
        if(choice == 1){
            sequential(arr, target);
        }else if(choice == 2){
            binary(arr, target);
        }else{
            bubble(arr2);
        }
    }
    
    public static void sequential(String[] arr, String target){
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals(target)){
                System.out.println(i);
            }
        }
        
    }
        
        
    public static void binary(String [] arr, String target){
        if (arr.length == 0) {
            System.out.println("-1");
        }
        int low = 0;
        int high = arr.length-1;
        int final3 = 0;

        while(low <= high ) {
            int middle = (low+high) /2;
            if(target.compareTo(arr[middle]) == 1){ //if(target.compareTo(arr[middle]     1 is 1st bigger, -1 is 2nd one bigger, 0 is the same
                low = middle +1;
            } else if (target.compareTo(arr[middle]) == -1){
                high = middle -1;
            } else { 
                //System.out.println(middle);
                final3 = middle;
                high = 0;
            }
        }
        System.out.println(final3);
    }

        
    
        
    public static void bubble(int [] arr){
        int length = arr.length;
        for (int i = 0; i < length-1; i++){
            for (int j = 0; j < length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int holder = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = holder;
                }
            }
        }
        for(int i = 0; i<length; i++){
            System.out.println(arr[i]);
        }
        
    }
    
}
