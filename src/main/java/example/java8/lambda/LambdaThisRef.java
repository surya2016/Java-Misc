package example.java8.lambda;

import java.util.function.Consumer;

public class LambdaThisRef {

	public static void main(String[] args) {
		int i=10;
		/*doProcess(i, x -> {
			System.out.println(x);
			System.out.println(this); //using this gives error here as it doen't refer to anything
			//if instead of using lambda, had we creaed an anonymous inner class, 'this' would have referred to instance of anonymous inner class
		});*/
		
		LambdaThisRef thisExample = new LambdaThisRef();
		thisExample.execute(i);
	}

	private void execute(int i)
	{
		doProcess(i, x -> {
			System.out.println(x);
			System.out.println(this); //works as this will refer to instance of class LambdaThisRef
		});
	}
	
	private static void doProcess(int i, Consumer<Integer> consume) {
		consume.accept(i);
	}
	
	@Override
	public String toString()
	{
		return "This is instance of LambdaThisRef";
	}

}
