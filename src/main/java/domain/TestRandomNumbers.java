package domain;

import java.util.Random;

public class TestRandomNumbers {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		for(int i = 0; i<15; i++){
			int randNum = random.nextInt((10+1)-5) + 5;
			System.out.println(randNum);
		}
		
	}

}
