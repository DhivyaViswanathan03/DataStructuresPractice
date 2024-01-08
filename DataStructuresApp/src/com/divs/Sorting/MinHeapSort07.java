package com.divs.Sorting;

public class MinHeapSort07 {

	public static void main(String[] args) {
		int a[]= {15,5,7,1,17,10,3};
		int n=a.length;
		buildMinHeap(a,n);
		
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
			minHeapify(a,i,0);
		}
		
		
	}

	private static void buildMinHeap(int[] a, int n) {
		for(int i=(n/2)-1;i>=0;i--) {
			minHeapify(a,n,i);
		}
		
	}

	private static void minHeapify(int[] a, int n, int i) {
		int smallest=i;
		int left=(2*i)+1;
		int right=(2*i)+2;
		while(left<n && a[left]<a[smallest]) {
			smallest=left;
		}
		while(right<n && a[right]<a[smallest]) {
			smallest=right;
		}
		if(smallest!=i) {
			int temp=a[smallest];
			a[smallest]=a[i];
			a[i]=temp;
			minHeapify(a,n,smallest);
		}
		
	}

}
