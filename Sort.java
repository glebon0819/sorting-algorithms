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
    	return new SortData("bubbleSort", newArray.length, swaps, comparisons, runTime, "O(n^2)", "O(n)", "O(n^2)");
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