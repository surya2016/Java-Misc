package example.programming.interview;

public class ArmstrongNumber {

	/**
	 * Armstrong number is a number that is equal to the sum of cubes of its digits. For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers.
	 * @param num
	 * @return
	 */
	static int armstrongOrNot(int num)
	{
		int x,a=0;
		while(num!=0)
		{
			x=num%10;
			a=a+(x*x*x);
			num/=10 ;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=100,arm;
		System.out.println("Armstrong numbers between 100 to 999");
		while(i<1000)
		{
			arm=armstrongOrNot(i);
			if(arm==i)
			System.out.println(i);
			i++;
		}
	}

}
