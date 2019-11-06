package example.java8.lambda;

import java.util.function.Consumer;

public class LambdaClosure {
	
	public static void main(String args [])
	{
		int a =10;
		int b =20;
		/*
		 * A closure is a lambda expression paired with an environment that binds each of its free variables to a value.
		 * If a lambda expression directly uses a variable it acts as final, as lambda says that it will not accept any other value for
		 * that variable.Here, variable b become final without even specifying as it is used directly in lambda. This is called closure, as
		 * we are binding a variable to a specific value
		 */
		doProcess(a, i->System.out.println(i+b));
	}

	private static void doProcess(int i, Consumer<Integer> p)
	{
		p.accept(i);;
	}
	
}
