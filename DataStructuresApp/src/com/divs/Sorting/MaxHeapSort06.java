package com.divs.Sorting;

public class MaxHeapSort06 {

	public static void main(String[] args) {
		int a[]= {15,5,20,1,17,10,30};
		int n=a.length;
		buildMaxHeap(a,n);
		
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		//Delete heap
		for(int i=n-1;i>=0;i--) {
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			System.out.print(a[i]+" ");
			maxHeapify(a,i,0);
		}
		
		
	}

	private static void buildMaxHeap
	(int[] a, int n) {
		for(int i=(n/2)-1;i>=0;i--) {
			maxHeapify(a,n,i);
		}
		
	}

	private static void maxHeapify(int[] a, int n, int i) {
		int largest=i;
		int left=(2*i)+1;
		int right=(2*i)+2;
		while(left<n && a[left]>a[largest]) {
			largest=left;
		}
		while(right<n && a[right]>a[largest]) {
			largest=right;
		}
		if(largest!=i) {
			int temp=a[largest];
			a[largest]=a[i];
			a[i]=temp;
			maxHeapify(a,n,largest);
		}
		
	}

}
