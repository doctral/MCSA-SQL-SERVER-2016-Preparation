package spring.learning.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		BinarySearchImpl binarySearch = new BinarySearchImpl();
		int res = binarySearch.binarySearch(new int[] {4,1,2,7}, 2);
		System.out.println(res);
		//SpringApplication.run(DemoApplication.class, args);
	}

}
