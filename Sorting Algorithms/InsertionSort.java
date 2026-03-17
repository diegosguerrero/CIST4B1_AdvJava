public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //go get the first item in the unsorted section
            int key = arr[i];

            //iterate through the sorted section from back to front
            //until key is either no longer smaller than the next item
            //or we hit index 0
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                //swap them
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

        }
    }
 
    public static void main(String[] args) {

        int [] data = {51, 2, 88, 74, 63, 5, 18};

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        insertionSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        
    }
    
}

