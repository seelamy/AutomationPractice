package com.java.programmes;

public class ReverseString2 {
	public static void main(String[] args) {
		String s="Yellareddy";
		
		char[] charAarry=s.toCharArray();
		int n=(charAarry.length)/2;
		for (int i = 0; i <n; i++) {
			char temp=charAarry[i];
			charAarry[i]=charAarry[n-i-1];
			charAarry[n-i-1]=temp;
		}
		String rev=new String(charAarry);
		System.out.println(rev);
	}

}
