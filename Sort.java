import java.util.Arrays;
public class Sort {

	private void swap(int[] nums, int x, int y) {
		int tmp;
		tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
	// Bubble sort: every time move the max element to last
	private void bubble_sort(int[] nums, int len) {
		int i, j, tmp;
		// round
		for (i = 0; i < len - 1; i++) {
			// traverse
			for (j = 0; j < len - 1 - i; j++) {
				// swap
				if (nums[j] > nums[j+1]) {
					tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
	}
	// Insertion sort: every time move the new element to the sorted sub array
	private void insertion_sort(int[] nums, int len) {
		int i, j, tmp;
		// n-1 new elements
		for (i = 1; i < len; i++) {
			// new element
			tmp = nums[i];
			// insert to sorted array
			for (j = i - 1; j >= 0 && tmp < nums[j]; j--) {
				nums[j+1] = nums[j];
			}
			nums[j+1] = tmp;
		}
	}
	// Quicksort: recursively move small elements before pivot and large elements after pivot
	private void quicksort(int[] nums, int start, int end) {
		if (start >= end) return;
		// pick last element as pivot
		int pivot = nums[end];
		int left = start, right = end - 1;
		// use left and right to swap small elements and large elements
		while (left < right) {
			while (nums[left] < pivot && left < right) left++;
			while (nums[right] > pivot && left < right) right--;
			swap(nums, left, right);
		}
		// move pivot to the middle
		if (nums[left] >= pivot) swap(nums, left, end);
		else left++;
		// recursively sort sub arrays
		quicksort(nums, start, left-1);
		quicksort(nums, left+1, end);
	}
	

	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] nums = {2,4,6,78,42,5,63,3};
		int len = nums.length;
		System.out.println("Original Array:");
		System.out.println(Arrays.toString(nums));
		sort.quicksort(nums, 0, len-1);
		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(nums));
	}
}