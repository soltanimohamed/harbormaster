package domain;

public class TimeFunctionSimulator {

	public static void main(String[] args) {
		try{
			TimeFunctions tf = new TimeFunctions(2016, 1, 1, "00:00");
			for (int i = 0; i<2000; i++){
				System.out.println(tf.currentDate());
				tf.advanceTime();
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
