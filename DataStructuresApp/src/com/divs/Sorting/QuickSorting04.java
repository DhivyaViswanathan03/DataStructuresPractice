package com.divs.Sorting;

public class QuickSorting04 {
	static int loc ;
	public static void main(String[] args) {
//		int a[] = {17,6,10,5,9,2,1,15,7,3,0};
		int a[]= {16,14,5,6,8,2,7,15};
		int lb = 0;
		System.out.println(lb);
		int ub = (a.length) - 1;
		System.out.println(ub);
		quicksort(a,lb,ub);
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	
		
	}
	
	private static void quicksort(int[] a,int lb,int ub){
		if(lb<ub) {
			loc=partition(a, lb, ub);
			quicksort(a,lb,loc-1);
			quicksort(a,loc+1,ub);
		}
		
		
	}

	private static int partition(int[] a, int lb, int ub) {
		int pivot = a[lb];
		int start = lb;
		int end = ub;
		int temp;
		while (start < end) {
			
			while (start<=ub && a[start] <= pivot) {
				System.out.println("start value is"+a[start]);
				System.out.println("pivot value is"+pivot);
				start++;
			}
			while (end>=lb && a[end] > pivot) {
				end--;
			}
			if (start < end) {
				temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
		}
		temp=a[end];
		a[end]=a[lb];
		a[lb]=temp;
		return end;
	}
}
