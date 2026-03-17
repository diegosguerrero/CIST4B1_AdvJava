import java.util.Random;
import java.util.Arrays;

public class Week4MergeSort {

    // Diego Guerrero - CIST04B1
    // Followed some of Book Chapter 9 (Data Structures & Abstractions with Java, 4th Edition)
    // By Frank M. Carrano and Timothy M. Henry
    // Also followed a video from Coding with John

    public static void MergeSort(int[] array) {

        int arrayLength = array.length;

        // Base Case: if the array has 1 or 0 elements, it is already sorted
        if (arrayLength <= 1) {
            return;
        }

        //Otherwise split
        //Get the middle with integer division (round down)
        int midIndex = arrayLength / 2;

        //Create array left from 0 - mid
        int[] leftHalf = new int[midIndex];
        //Create array from mid - (array.length - 1)
        int[] rightHalf = new int[arrayLength - midIndex];

        //From 0 to the length of our left half
        //Copying elements to left subarray
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }

        //Loop through the second half of our array
        //Copying elements to right subarray
        for (int i = midIndex; i < arrayLength; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        //Recursive Cases:
        //Sort the left half
        MergeSort(leftHalf);
        //Sort the right half
        MergeSort(rightHalf);

        //Merge both sorted arrays into the original array
        merge(array, leftHalf, rightHalf);

    }

    private static void merge (int [] array, int[] leftHalf, int[] rightHalf){
        //Conquer
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //Iterate through left and right using two separate counters
        int i = 0, j = 0, k = 0;

        //Weave them into array, and each time we add from left or right,
        //increment counter (++)
        //Want to stop both when both counters are the size of their respective arrays
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //Clean up remaining elements
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        Random random = new Random();
        int [] numbers = new int[1000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        // System.out.println("Before Sorting:");
        // System.out.println(Arrays.toString(numbers));

        //Starting timing
        long startTime = System.nanoTime();

        MergeSort(numbers);

        //Ending timing
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // System.out.println("\nAfter Sorting:");
        // System.out.println(Arrays.toString(numbers));

        System.out.println("\nTime taken: " + duration + " nanoseconds");

    }
}

/*
Array with size 10
Time taken: 10200 nanoseconds

Array with size 100
Time taken: 65700 nanoseconds

Array with size 1000
Time taken: 363300 nanoseconds

Array with size 10000
Time taken: 1814600 nanoseconds

Array with size 100000
Time taken: 45730200 nanoseconds

Array with size 1000000
Time taken: 134099500 nanoseconds

Array with size 10000000
Time taken: 843190100 nanoseconds
 */
