package spring.learning.demo;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		BinarySearchImpl binarySearch = new BinarySearchImpl( new QuickSortImpl() );
		int[] arr = new int[] {4,1,2,7};
		int res = binarySearch.binarySearch(arr, 2);
		System.out.println(res);
		System.out.println(print(arr));
		//SpringApplication.run(DemoApplication.class, args);
	}
	public static String print(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for(int num : nums) {
			sb.append(num);
			sb.append(" ");
		}
		return sb.toString();
	}
}
