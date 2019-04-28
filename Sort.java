import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Sort {
	private int[] array;
    private long startTime;
    private long endTime;
	Sort(int[] inputArray) { 
        array = inputArray;
    }

    // verifies that an int array is sorted from least to greatest
    private static int verify(int[] sortedArray){
        for(int i = 0; i < (sortedArray.length - 1); i++) {
            if(sortedArray[i] > sortedArray[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // implementation of the bubble sort algorithm on an array of ints
    public SortData bubbleSort() {
        startTime = System.nanoTime();
    	long swaps = 0;
    	long lastSwaps = 1;
        int holder;
    	int[] newArray = array;
    	long comparisons = 0;
    	while(lastSwaps != 0) {
	    	lastSwaps = 0;
	    	for(int i = 0; i < newArray.length; i++) {
	    		int j = i + 1;
	    		if(j < newArray.length) {
	    			if(newArray[i] > newArray[j]) {

	    				// swap elements
	    				holder = newArray[j];
	    				newArray[j] = newArray[i];
	    				newArray[i] = holder;

	    				lastSwaps++;
	    				swaps++;
		    		}
		    		comparisons++;
	    		}
	    	}
    	}
        endTime = System.nanoTime();
        long runTime = endTime - startTime;

        // verify that array was successfully sorted
        if(verify(newArray) != -1) {
            System.out.println("Sort failed");
        }

    	// return object containing data about the sort
    	return new SortData("Bubble Sort", newArray.length, swaps, comparisons, runTime, "O(n^2)", "O(n)", "O(n^2)");
    }

    // implementation of the insertion sort algorithm on array of ints
    public SortData insertionSort() {
        startTime = System.nanoTime();
        long swaps = 0;
        long comparisons = 0;
        int sorted = 0;
        int holder;
        int[] newArray = new int[array.length];
        while(sorted < (newArray.length)) {
            if(sorted == 0) {
                newArray[0] = array[0];
            }
            else {
                int currentIndex = sorted - 1;
                while(array[sorted] < newArray[currentIndex]) {
                    comparisons++;
                    newArray[currentIndex + 1] = newArray[currentIndex];
                    swaps++;
                    currentIndex--;
                    if(currentIndex == -1) {
                        break;
                    }
                }
                comparisons++;
                newArray[currentIndex + 1] = array[sorted];
            }
            sorted++;
        }
        endTime = System.nanoTime();
        long runTime = endTime - startTime;

        // verify that array was successfully sorted
        if(verify(newArray) != -1) {
            System.out.println("Sort failed");
        }

        // return object containing data about the sort
        return new SortData("Insertion Sort", newArray.length, swaps, comparisons, runTime, "O(n^2)", "O(n)", "O(n^2)");
    }

    // conducts multiple sorts on arrays of various sizes using the same algorithm, then spits out the data
    public SortData[] benchmark(String algName) {
        SortData[] benchmarkData = new SortData[6];
        int[] ogArray = array;
        if(algName == "bubbleSort") {
            for(int i = 0; i < 6; i++) {
                benchmarkData[i] = bubbleSort();
                //int[] array = (int[]) ArrayUtils.addAll(array, ogArray);
                array = IntStream.concat(Arrays.stream(array), Arrays.stream(ogArray)).toArray();
            }
            array = ogArray;
        }
        else if(algName == "insertionSort") {
            for(int i = 0; i < 6; i++) {
                benchmarkData[i] = insertionSort();
                //int[] array = (int[]) ArrayUtils.addAll(array, ogArray);
                array = IntStream.concat(Arrays.stream(array), Arrays.stream(ogArray)).toArray();
            }
            array = ogArray;
        }
        else {
            throw new IllegalArgumentException();
        }
        return benchmarkData;
    }

    /*
    To-Do:
    bubbleSortBetter
    insertionSort
    selectionSort
    heapSort
    mergeSort
    quickSort

    benchmark
    compare

    add:
    memoryUsage?
    time
    */
}