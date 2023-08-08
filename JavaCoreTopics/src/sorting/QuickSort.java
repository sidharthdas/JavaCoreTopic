package sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        quicksort(arr, 0, n - 1);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        return 0;
    }
}
