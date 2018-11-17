package com.liuawei.algorithm;

import java.util.Arrays;

public class Sort {

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int n = arr.length;
		// 总共需要循环n次 每次通过冒泡 得到最大的
		for (int i = 0; i < n; i++) {
			// 因为上一次已经确定了最大的，所以需要遍历的数据就是(n-1)-i
			boolean flag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = false;
				}
			}
			// 因为冒泡 如果这次冒泡没有数据没有交换所以数据已经有序了，可以提前退出
			if (flag) {
				break;
			}
		}
		return arr;
	}

	/**
	 * 归并排序算法
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] mergeSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		mergeSortInternal(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * 分治
	 * 
	 * @param arr
	 * @param p
	 * @param r
	 */
	private static void mergeSortInternal(int[] arr, int p, int r) {
		if (p >= r) {
			return;
		}
		// 把一个无序数组的排序问题，分成两个无序数组的排序问题
		int q = p + (r - p) / 2;
		mergeSortInternal(arr, p, q);
		mergeSortInternal(arr, q + 1, r);

		// 将arr[p...q]，arr[q+1...r]合并成arr[p,r]
		merge(arr, p, q, r);
	}

	/**
	 * 合并
	 * 
	 * @param arr
	 * @param p
	 * @param q
	 * @param r
	 * @return
	 */
	private static void merge(int[] arr, int p, int q, int r) {
		// arr[p...q]的起点
		int i = p;
		// arr[q+1...r]起点
		int j = q + 1;
		int k = 0;
		// 声明一个大小和arr[p...r]大小一样的数组
		int[] temp = new int[r - p + 1];
		// 循环遍历两个数组 把有序的数据放到空数组里面
		// why i<=q && j<=r 而不是因为合并的时候子数组已经有序了，只要有一个数组遍历完，剩下的只需要追加在后面
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 判断哪个子数组没有剩余数据
		int start = i;
		int end = q;
		// 如果第二个数组j不是最后一位 那么第二个数组还有剩余数据
		if (j <= r) {
			start = j;
			end = r;
		}

		// 将剩余数据落到临时空间
		while (start <= end) {
			temp[k++] = arr[start++];
		}

		// 将temp数组拷贝会a[p...r]
		for (i = 0; i <= r - p; i++) {
			arr[p + i] = temp[i];
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		quickSortInternal(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * 快速排序递归函数
	 * 
	 * @param arr
	 * @param p
	 * @param r
	 */
	private static void quickSortInternal(int[] arr, int p, int r) {
		if (p >= r) {
			return;
		}
		// 获取分区点的元素下标
		int q = partition(arr, p, r);
		quickSortInternal(arr, p, q - 1);
		quickSortInternal(arr, q + 1, r);
	}

	/**
	 * 快速排序-分区
	 * 
	 * @param arr
	 * @param p
	 * @param r
	 * @return
	 */
	private static int partition(int[] arr, int p, int r) {
		// 选择最后一个元素作为分区点
		int pivot = arr[r];
		int i = p;
		for (int j = p; j < r; j++) {
			// 小于当前数据的交换，i标志的数据就是第一个大于分区点元素的数据
			if (arr[j] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		return i;
	}

	/**
	 * 计数排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] countingSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		// 1：计算最大的数据，也就是我们要分多少个桶
		int n = arr.length;
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// 2: 申请一个桶数组
		int[] bucketArr = new int[max + 1];
		for (int i = 0; i < bucketArr.length; i++) {
			bucketArr[i] = 0;
		}
		// 3:计算每个桶里面元素的个数
		for (int i = 0; i < n; i++) {
			bucketArr[arr[i]]++;
		}
		// 4: 依次累加
		for (int i = 1; i < bucketArr.length; i++) {
			bucketArr[i] = bucketArr[i - 1] + bucketArr[i];
		}
		// 5:临时数组，存储排序之后的结果
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int index = bucketArr[arr[i]] - 1;
			result[index] = arr[i];
			bucketArr[arr[i]]--;
		}

		// 6:将结果拷贝到原始数组
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
		return arr;
	}

	/**
	 * 计数排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] countingSort2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		// 1：计算最大的数据，也就是我们要分多少个桶
		int n = arr.length;
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		// 2: 申请一个桶数组
		int[] bucketArr = new int[max - min + 1];
		for (int i = 0; i < bucketArr.length; i++) {
			bucketArr[i] = 0;
		}
		// 3:计算每个桶里面元素的个数
		for (int i = 0; i < n; i++) {
			int pos = arr[i] - min;
			bucketArr[pos]++;
		}
		// 4：直接遍历 桶的下标就是数组元素的值,小标元素的值就是数据的个数
		int k = 0;
		for (int i = 0; i < bucketArr.length; i++) {
			while (bucketArr[i]-- > 0) {
				arr[k++] = i + min;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 2, 7, 4, 3, 6 };
		int[] arr2 = { 1, 2, 3, 3, 4, 6, 7 };
		int[] arr3 = { 9, 7, 6, 2, 4, 1, 0 };
		int[] arr4 = { 2, 3, 3, 4, 6, 6, 8, 8, 2, 9, 1, 2, 3 };

		System.out.println(Arrays.toString(countingSort2(arr4)));

	}

}
