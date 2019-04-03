public class SortData {
	public String algName;
	public int ogArrayLength;
	public long swaps;
	public long comparisons;
	public long runTime;
	public String worstCase;
	public String bestCase;
	public String avgCase;

	SortData(String inpAlgName, int inpArrayLength, long inpSwaps, long inpComparisons, long inpRunTime, String worstCase, String bestCase, String avgCase) { 
        algName = inpAlgName;
        ogArrayLength = inpArrayLength;
        swaps = inpSwaps;
        comparisons = inpComparisons;
        runTime = inpRunTime;
    }

    public void print() {
    	System.out.println(algName + ":");
    	System.out.println("Original Array Length: " + ogArrayLength);
		System.out.println("Number of swaps: " + swaps);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Run Time: " + (runTime / 1000000) + " milliseconds.");
    }
}