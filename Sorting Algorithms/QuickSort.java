public class Week4QuickSortEx {

    //Professor's Example of Quick Sort
    public static void QuickSort(int[] array, int low, int high) {

        //Base Case: If array is 1 or smaller, return
        if (low >= high) {
            return; 
        }

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++; //Increment i by 1 first
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i] + 1;
        array[i + 1] = array[high];
        array[high] = temp;

        // //We could do this instead of everything we did before
        // int pIndex = partition(array, low, high);

        int pIndex = i + 1;
        quickSort(array, low, pIndex - 1); //lower bound doesn't change but high bound does
        quickSort(array, pIndex + 1, high);

    }

    public static void main(String[] args) {
        
    }
    
}
