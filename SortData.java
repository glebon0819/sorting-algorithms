public class SortData {
	public int ogArrayLength;
	public long swaps;
	public long comparisons;
	public long runTime;
	public String worstCase;
	public String bestCase;
	public String avgCase;

	SortData(int inpArrayLength, long inpSwaps, long inpComparisons, long inpRunTime, String worstCase, String bestCase, String avgCase) { 
        ogArrayLength = inpArrayLength;
        swaps = inpSwaps;
        comparisons = inpComparisons;
        runTime = inpRunTime;
    }
}