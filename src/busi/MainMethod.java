package busi;

import java.io.IOException;

public class MainMethod {

	
	public static void main(String[] args) {
		MainBusi main  = new MainBusi();
		try {
			main.busi();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("the total matcher time is : "+main.count);
	}
}
