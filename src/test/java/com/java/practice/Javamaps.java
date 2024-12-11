package com.java.practice;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Javamaps {

	public static void main(String[] args) {
		// Print names ends with 'a' and print the results with upper case
		Stream<String> list1 = Stream.of("Rama", "Sams", "Abhira", "Thala");
		Stream.of("Rama", "Sams", "Abhira", "Thala").filter(a -> a.endsWith("a")).map(a -> a.toUpperCase())
				.forEach(a -> System.out.println(a));

		// Print names ends with 'a' as upper case and sort
		List<String> lists = Arrays.asList("Ahid", "Aama", "Sams", "Abhira", "Thala");
		lists.stream().filter(a -> a.startsWith("A")).sorted().map(a -> a.toUpperCase())
				.forEach(a -> System.out.println(a));
		Stream<String> combainedlist =Stream.concat(list1, lists.stream());
//		combainedlist.forEach(a->System.out.println(a));
		boolean b= combainedlist.anyMatch(a->a.equalsIgnoreCase("Aama"));
		Assert.assertTrue(b);
		
		
		List<Integer> list= Arrays.asList(23,2,10,3,56,21,3,23);
		list.stream().sorted().forEach(a->System.out.println(a));
		list.stream().distinct().forEach(a->System.out.println(a));
		List<Integer> list12 = list.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println("afaf"+list12.get(2));
		
		//
		

	}
}