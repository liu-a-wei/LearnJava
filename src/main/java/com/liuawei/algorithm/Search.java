package com.liuawei.algorithm;

public class Search {

	/**
	 * 二分查找
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0;
		int hign = arr.length - 1;
		while (low <= hign) {
			int middle = (low + hign) / 2;
			if (arr[middle] == value) {
				return middle;
			} else if (arr[middle] < value) {
				low = middle + 1;
			} else {
				hign = middle - 1;
			}

		}
		return -1;
	}

	/**
	 * 二分查找
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch2(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		return binarySearchInternally(arr, value, 0, arr.length - 1);
	}

	/**
	 * 二分查找 -- 递归实现
	 * 
	 * @param arr
	 * @param value
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearchInternally(int[] arr, int value, int low, int high) {
		if (low > high) {
			return -1;
		}
		int middle = (low + high) / 2;
		if (arr[middle] == value) {
			return middle;
		} else if (arr[middle] < value) {
			return binarySearchInternally(arr, value, middle + 1, high);
		} else {
			return binarySearchInternally(arr, value, low, middle - 1);
		}
	}

	/**
	 * 顺序查找
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int orderSearch(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * 找到第一个value的值
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchFirst(int[] arr, int value){
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0;
		int hign = arr.length - 1;
		while (low <= hign) {
			int middle = (low + hign) / 2;
			if (arr[middle] == value) {
				if ((middle==0)||(arr[middle-1]!=value)) {
					return middle;
				}else {
					hign = middle - 1;
				}
			} else if (arr[middle] < value) {
				low = middle + 1;
			} else {
				hign = middle - 1;
			}

		}
		return -1;
	
	}
	
	/**
	 * 找到最后一个value的值
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearchLast(int[] arr, int value){
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int low = 0;
		int hign = arr.length - 1;
		while (low <= hign) {
			int middle = (low + hign) / 2;
			if (arr[middle] == value) {
				if ((middle==0)||(arr[middle+1]!=value)) {
					return middle;
				}else {
					low = middle + 1;
				}
			} else if (arr[middle] < value) {
				low = middle + 1;
			} else {
				hign = middle - 1;
			}

		}
		return -1;
	
	}
	
	// 查找第一个大于等于给定值的元素
	
	
	

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 6,6,6,7, 9, 12 };
		System.out.println(binarySearchFirst(arr, 6));
		System.out.println(binarySearchLast(arr, 6));
	}
}
