public class Sort {
	
	private int[] array;

	Sort(int[] array) { 
        this.array = array;
    }

    public int[] bubbleSort() {
    	int swaps = 0;
    	int lastSwaps = 1;
    	int holder;
    	int[] newArray = this.array;
    	int comparisons = 0;
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

    	// return original array length, number of swaps, number of loops
    	return new int[]{newArray.length, swaps, comparisons};
    }
}