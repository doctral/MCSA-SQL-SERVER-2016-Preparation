package spring.learning.demo;

public class BinarySearchImpl {
	
	private SortAlgorithm sortAlgo;
	
	public BinarySearchImpl(SortAlgorithm algo) {
		sortAlgo = algo;
	}
	
	public int binarySearch(int[] arr, int target) {
		
		arr = sortAlgo.sort(arr);
		
		int left=0, right = arr.length-1;
		while(left<=right) {
			int mid = (right+left)/2;
			if(arr[mid]==target) return mid;
			if(arr[mid]>target) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return -1;
	}
}
