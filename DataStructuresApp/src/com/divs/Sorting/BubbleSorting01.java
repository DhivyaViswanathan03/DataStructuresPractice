package com.divs.Sorting;

public class BubbleSorting01 {

	public static void main(String[] args) {
		
		int a[]= {16,14,5,6,8,2,7,15};
		int n=a.length;
		int temp,flag;
		for(int i=0;i<n-1;i++) {
			 flag=0;
			for(int j=0;j<n-1-i;j++) {
				if(a[j]>a[j+1]) {
					flag=1;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			
			if(flag==0)
				break;
		}
		System.out.println("After sorting...");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
