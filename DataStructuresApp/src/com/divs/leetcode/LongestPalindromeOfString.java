package com.divs.leetcode;

public class LongestPalindromeOfString {
	int start=0;
	int maxLength=1;
	int l,r;
	private String longestPalindrome(String s) {
		if(s.length()<2) {
			return s;
		}
		//Even
		for(int i=1;i<s.length();i++) {
			l=i-1;
			r=i;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				if(r-l+1 >maxLength) {
					maxLength=r-l+1;
					start=l;
				}
				l--;
				r++;
			}
		}
		//odd
		for(int i=1;i<s.length();i++) {
			l=i-1;
			r=i+1;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				if(r-l+1 >maxLength) {
					maxLength=r-l+1;
					start=l;
				}
				l--;
				r++;
			}
		}
			
			return s.substring(start,start+maxLength);
	}
	
	public static void main(String args[]) {
//		String s="forgeeksskeegfor";
		String s="abacdgfdcaba";
		LongestPalindromeOfString palin=new LongestPalindromeOfString();
		System.out.println(palin.longestPalindrome(s));
	}
}
