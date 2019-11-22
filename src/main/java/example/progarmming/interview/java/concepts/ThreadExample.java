package example.progarmming.interview.java.concepts;

public class ThreadExample implements Runnable{

	public static void main(String args[])
	{
		try {
			Thread t = new Thread(new ThreadExample());
			
			System.out.println("Thread Example");
			
			t.start();
			
			System.out.println("Chat   ");
			t.join();
			System.out.println("Joined  ");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured....");
		}
	}

	@Override
	public void run() {
		System.out.println("Typing1 ....");
		System.out.println("Typing 2.....");
		
	}
}
