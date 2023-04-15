import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Task 4
 * This is the unsorted array of 10 elements
 */
public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }

        //This prints the array out so the user can see the elements
        System.out.println(Arrays.toString(numbers));
        
        //This prompts the user for their input, asking which operation they wish to perform with the array
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Select one of the following operations: ");
            System.out.println("1. Fetch an element");
            System.out.println("2. Insert an element");
            System.out.println("3. Delete an element");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            
            switch (choice) {
                // This portion is the fetch algorithm
                case 1:
                    System.out.print("Enter the element you want to fetch: ");
                    int fetchElement = scanner.nextInt();
                    int fetchIndex = fetch(numbers, fetchElement);
                    if (fetchIndex == -1) {
                        System.out.println("Element was not found.");
                    } else {
                        System.out.println("Element was found at index " + fetchIndex + ".");
                    }
                    break;
                    // This portion is the inset algorithm
                case 2:
                    System.out.print("Enter the element you want to insert: ");
                    int insertElement = scanner.nextInt();
                    System.out.print("Enter the index you want to insert it at: ");
                    int insertIndex = scanner.nextInt();
                    numbers = insert(numbers, insertElement, insertIndex);
                    System.out.println("Element has been inserted.");
                    System.out.println(Arrays.toString(numbers));
                    break;
                    // This portion is the delete algorithm
                case 3:
                    System.out.print("Enter the element you want to delete: ");
                    int deleteElement = scanner.nextInt();
                    int deleteIndex = fetch(numbers, deleteElement);
                    if (deleteIndex == -1) {
                        System.out.println("Element was not found.");
                    } else {
                        numbers = delete(numbers, deleteIndex);
                        System.out.println("Element has been deleted.");
                        System.out.println(Arrays.toString(numbers));
                    }
                    break;
                    // This is choice 4, the exit option
                case 4:
                    break;
                    // This is the message the code will display if the user does not pick one of the options
                default:
                    System.out.println("You did not enter a valid option.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
    // Creation of the fetch method
    public static int fetch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
    // Creation of the insert method
    public static int[] insert(int[] arr, int element, int index) {
        int[] result = new int[arr.length + 1];
        for (int i = 0, j = 0; i < result.length; i++, j++) {
            if (i == index) {
                result[i] = element;
                j--;
            } else {
                result[i] = arr[j];
            }
        }
        return result;
    }
    // Creation of the delete method
    public static int[] delete(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (i == index) {
                j++;
            }
            result[i] = arr[j];
        }
        return result;
    }
}