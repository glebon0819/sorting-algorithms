public class Arrays {

	private static int[] generateArray() {
		int[] randomInts = new int[10000];
		for(int i = 0; i < 10000; i++){
			randomInts[i] = (int) (Math.random() * ((10000 - 0) + 1)) + 0;
		}
		return randomInts;
	}

	public static void main(String []args) {
		int[] array = generateArray();
		Sort sort = new Sort(array);
		int[] data = sort.bubbleSort();

		// display performance data
		System.out.println("Original Array Length: " + data[0]);
		System.out.println("Number of swaps: " + data[1]);
		System.out.println("Number of comparisons: " + data[2]);
	}
}