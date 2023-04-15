import java.util.Arrays;
import java.util.Scanner;

/**
 * Task 2
 * This is the sorted array of 100 elements
 */
public class Task2 {
    public static void main(String[] args) {
        //Creation of sorted array with 10 elements

        int[] SortedNumbers100 = new int[100];
        for (int i = 0; i < SortedNumbers100.length; i++) {
            SortedNumbers100[i] = i + 1;
        }
        Arrays.sort(SortedNumbers100);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Select one of the following operations: ");
            System.out.println("1. Fetch an element");
            System.out.println("2. Insert an element");
            System.out.println("3. Delete an element");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
        
            // This portion is the fetch algorithm

            if (choice == 1) {
                System.out.println("Enter the element you want to fetch: ");
                int element = scanner.nextInt();
                int index = Arrays.binarySearch(SortedNumbers100, element);
                if (index < 0) {
                    System.out.println("Element was not found");
                } else {
                    System.out.println("Element was found at index " + index);
                }

                // This portion is the insert algorithm
                
            } else if (choice == 2) {
                System.out.println("Enter the element you want to insert: ");
                int element = scanner.nextInt();
                int index = Arrays.binarySearch(SortedNumbers100, element);
                if (index < 0) {
                    index = -(index + 1);
                }
                SortedNumbers100 = insertElement(SortedNumbers100, element, index);
                System.out.println("Element has been inserted");
                
                // This portion is the delete algorithm

            } else if (choice == 3) {
                System.out.println("Enter the element you want to delete: ");
                int element = scanner.nextInt();
                int index = Arrays.binarySearch(SortedNumbers100, element);
                if (index < 0) {
                    System.out.println("Element was not found");
                } else {
                    SortedNumbers100 = deleteElement(SortedNumbers100, index);
                    System.out.println("Element has been deleted");
                }
                
                // This is choice 4, the exit option
            } else if (choice == 4) {
                break;
                // This is the message the code will display if the user does not pick one of the options
            } else {
                System.out.println("You did not select a valid option");
            }
            // This prints the array before and after each algorithm execution
            System.out.println("Array contents: " + Arrays.toString(SortedNumbers100));
        }
    }
    
    // Creation of the method used to insert an element into the array

    public static int[] insertElement(int[] arr, int element, int index) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, index);
        result[index] = element;
        System.arraycopy(arr, index, result, index + 1, arr.length - index);
        return result;
    }
    
    // Creation of the method used to delete an element from the array
    
    public static int[] deleteElement(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        return result;
    }
}