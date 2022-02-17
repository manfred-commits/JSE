package com.manfredipiraino.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyEXE_Stream1 {

	public static void main(String[] args) {
		
		List<Integer> myArrayList= new ArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		myArrayList.add(4);
		Stream<Integer> myArrayListStream=myArrayList.stream();
		
		myArrayListStream.forEach((element)->System.out.println(element));
		System.out.println("___________________________");
		
		String [] arrayString= {"1","2","3","4"};
		Stream<String> arrayIntStream= Arrays.stream(arrayString);
	}

}
