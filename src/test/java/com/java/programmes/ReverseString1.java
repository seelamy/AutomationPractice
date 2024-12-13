package com.java.programmes;

public class ReverseString1 {
	public static void main(String[] args) {
		String s = "Yella reddy";
		String re = "";
		String re1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {

			re += s.charAt(i);
		}
		System.out.println("Type1" + re);

		char[] chararray = s.toCharArray();
		for (int i = chararray.length - 1; i >= 0; i--) {
          re1+=chararray[i];
		}
		System.out.println("Type2"+re1);

	}

}
