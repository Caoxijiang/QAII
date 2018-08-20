package com.qaii.util;

import java.util.StringTokenizer;

public class StringtoIntutil {
	
	
	public static  Integer[] StringtoIntutil(String str) {  
		  
		int length = str.length();
		 Integer[] result = new Integer[length];
		 // 依次取得字符串中的每一个字符，并将其转化为数字，放进int数组中
		for (int i = 0; i < length; i++) {
		 char c = str.charAt(i);
		 result[i] = Character.getNumericValue(c);
		 }
		 return result;
	}
 
}
