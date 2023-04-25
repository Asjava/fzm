package com.java8.stream.arithmetic.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArithmetic {

    public static int[] selectSorted(int[] arr) { // O(n2)选择排序
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1 ; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static int[] bubbleSorted(int[] arr) { // O(n2)冒泡排序
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.println("j"+ j);
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static int[] insertSorted(int[] arr) { // O(n2)插入排序
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    public static int[] mergeSorted(int[] arr) { // O(n*logn)归并排序
        if (arr == null || arr.length < 2) {
            return arr;
        }

        processMerge(arr, 0 ,arr.length - 1);
        return arr;
    }

    public static void processMerge(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + ((end -start) >> 1);
        processMerge(arr, start, mid);
        processMerge(arr, mid + 1, end);
        merger(arr, start, mid, end);
    }

    public static void merger(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int helpi = 0;
        int p1 = start;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= end) {
            help[helpi++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[helpi++] = arr[p1++];
        }

        while (p2 <= end) {
            help[helpi++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private static void swapBit(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static int getMax(int[] arr, int start, int end) { // 2分查找最大值
        return process(arr, start, end);
    }

    private static int process(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int mid = start + ((end -start) >> 1);
        int leftMax = process(arr, start, mid);
        int rightMax = process(arr, mid + 1, end);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 6};
//        int[] arrSorted = selectSorted(arr);
//        System.out.println(arr.length);
//        int[] arrSorted = bubbleSorted(arr);
//        int[] arrSorted = insertSorted(arr);
        int[] arrSorted = mergeSorted(arr);
        Arrays.stream(arrSorted).forEach(e-> System.out.println(e));

//        System.out.println(arrSorted.length);
//        int max = getMax(arrSorted, 0, arrSorted.length - 1);
//        System.out.println(max);

    }

}
