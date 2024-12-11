package com.java.practice;

import java.util.ArrayList;
import java.util.List;

public class JavaStreams {
	
	public static void main(String[] args) {
		List<String> names=new ArrayList<String>();
		names.add("Abji");
		names.add("Baja");
		names.add("Abira");
		names.add("Abji");
		names.add("Abira");
		
		Object[] count = names.stream().filter(a->a.startsWith("A")).distinct().toArray();
		names.stream().forEach(a->System.out.println(a));
		System.out.println(count.length);
    	names.stream().filter(a->a.length()>4).forEach(a->System.out.println(a));
		names.stream().filter(a->a.length()>4).limit(1).forEach(a->System.out.println(a));
	}

}
