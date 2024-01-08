package com.divs;

public class SelectionSorting03 {

	public static void main(String[] args) {
		int a[]= {16,14,5,6,8,2,7,15,0,3};
		int n=a.length;
		int min,temp;
		for(int i=0;i<n-1;i++) {
			min=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			if(min !=i) {
				temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
		System.out.println("After sorting..");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
