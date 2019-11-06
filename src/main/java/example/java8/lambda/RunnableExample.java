package example.java8.lambda;

public class RunnableExample {

	
	
	public static void main(String[] args) {
		
		//using lambda
		Thread lambdaThread = new Thread(()-> System.out.println("Lambda Runnable Thread"));
		
		Thread lambdaThread2 = new Thread(()-> {
			System.out.println("Lambda Runnable Thread2");
			int a= 5*5;
			System.out.println(a);
		});
		
		lambdaThread2.run();
		lambdaThread.run();

	}

}
