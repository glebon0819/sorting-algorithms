public class Arrays {

	private static int[] generateArray(int n) {
		int[] randomInts = new int[n];
		for(int i = 0; i < n; i++){
			randomInts[i] = (int) (Math.random() * (n + 1));
		}
		return randomInts;
	}

	private static int[] generateWorstArray(int n) {
		int[] badInts = new int[n];
		for(int i = 0; i < n; i++) {
			badInts[i] = n - i;
		}
		return badInts;
	}

	public static void main(String []args) {
		int[] array = generateArray(10000);
		Sort sort = new Sort(array);
		//SortData data = sort.insertionSort();

		// display performance data
		//data.print();
		
		SortData[] benchmarkData = sort.benchmark("insertionSort");
		benchmarkData[0].print();
		benchmarkData[1].print();
		benchmarkData[2].print();
		benchmarkData[3].print();
		benchmarkData[4].print();
		benchmarkData[5].print();
	}
}