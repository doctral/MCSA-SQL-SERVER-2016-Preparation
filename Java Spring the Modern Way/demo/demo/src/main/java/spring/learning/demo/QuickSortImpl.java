package spring.learning.demo;

public class QuickSortImpl implements SortAlgorithm {

	@Override
	public int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		quickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	private void quickSort(int[] arr, int left, int right) {
		if(left<right) {
			int pivotIndex = partition(arr, left, right);
			quickSort(arr, left, pivotIndex-1);
			quickSort(arr, pivotIndex+1, right);
		}
	}
	
	private int partition(int[] arr, int left, int right) {
		int pivotIndex = 0, pivot = arr[right];
		for(int i=left; i<right; i++) {
			if(arr[i]<pivot) {
				swap(arr, pivotIndex, i);
				pivotIndex++;
			}
		}
		swap(arr, pivotIndex, right);
		return pivotIndex;
	}
	
	private void swap(int[] arr, int i, int j) {
		if(i!=j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
}
