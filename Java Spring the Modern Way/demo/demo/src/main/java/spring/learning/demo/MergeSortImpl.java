package spring.learning.demo;

public class MergeSortImpl implements SortAlgorithm {

	@Override
	public int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		MergeSort(arr, new int[arr.length], 0, arr.length-1);
		return arr;
	}
	
	private void MergeSort(int[] arr, int[] temp, int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			MergeSort(arr, temp, left, mid);
			MergeSort(arr, temp, mid+1, right);
			Merge(arr, temp, left, mid, right);
		}
	}
	
	private void Merge(int[] arr, int[] temp, int left, int mid, int right) {
		for(int i=left; i<=right; i++) {
			temp[i] = arr[i];
		}
		
		int curr = left, idx1 = left, idx2 = mid+1;
		
		while(idx1<=mid || idx2<=right) {
			if(idx1>mid) {
				while(idx2<=right) {
					arr[curr] = temp[idx2];
					idx2++;
					curr++;
				}
			}
			else if(idx2>right) {
				while(idx1<=mid) {
					arr[curr] = temp[idx1];
					idx1++;
					curr++;
				}
			}
			else {
				if(temp[idx1]<temp[idx2]) {
					arr[curr] = temp[idx1];
					idx1++;
				}
				else {
					arr[curr] = temp[idx2];
					idx2++;
				}
				curr++;
			}
		}
	}

}
