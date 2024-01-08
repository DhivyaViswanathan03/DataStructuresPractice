package com.divs;

public class InsertionSorting02 {

	public static void main(String[] args) {
		int a[]= {16,14,5,6,8,2,7,15,0,3};
		int n=a.length;
		int temp,flag;
		
		for(int i=1;i<n;i++) {
			temp=a[i];
			int j=i-1;
			while(j>=0 && a[j]>temp) {
				a[j+1]=a[j];
				j--;
				
			}
			a[j+1]=temp;
		}
		System.out.println("After sorting..");
		
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
