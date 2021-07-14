import java.util.Random;

public class testingRand 
{
	public static void main(String[] args) 
	{
	
		for(int x = 0; x < 2; x++)	
		{ 
			Random rand = new Random();
			int upperbound = 9;
			int a = rand.nextInt(upperbound);
			int b = rand.nextInt(upperbound);
			System.out.println(a);
			System.out.println(b);

		}
	}
	
}
