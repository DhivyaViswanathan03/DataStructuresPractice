package com.divs.Sorting;

public class MergeSorting05 {

	public static void main(String args[]) {
//		int a[] = {15,5,24,8,1,3,16,10,20};
		int a[] = {17,6,10,5,9,2,1,15,7,3,0};
		int[] b=new int[a.length];
		int lb=0;
		int ub=a.length-1;
		MergeSort(a,lb,ub,b);
		
		System.out.println("After sorting...");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

	private static void MergeSort(int[] a, int lb, int ub,int b[]) {
		int mid;
		if(lb<ub) {
			mid=(lb+ub)/2;
			MergeSort(a,lb,mid,b);
			MergeSort(a,mid+1,ub,b);
			Merge(a,lb,mid,ub,b);
		}
		
	}

	private static void Merge(int[] a, int lb, int mid, int ub,int b[]) {
		int i=lb;
		int j=mid+1;
		int k=lb;
		while(i<=mid && j<=ub) {
			if(a[i]<=a[j]) {
				b[k]=a[i];
				i++;
				k++;
			}else {
				b[k]=a[j];
				j++;
				k++;
			}
		}
		if(i>mid) {
			while(j<=ub) {
				b[k]=a[j];
				j++;
				k++;
			}
		}else {
			while(i<=mid) {
				b[k]=a[i];
				i++;
				k++;
			}
		}
		for(k=lb;k<=ub;k++) {
			a[k]=b[k];
		}
		
	}
	
}

