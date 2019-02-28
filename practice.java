
import java.util.*;

public class practice
{
	public static void main(String[] args)
	{
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		prime.add(3);
		prime.add(5);
		prime.add(7);
		
		ArrayList<Integer> num = new ArrayList<>(prime);
		num.set(0,0);
		
		print(prime);
		print(num);
	}
	
	public static void print(ArrayList<Integer> al)
	{
		for(int i=0; i<al.size(); i++)
		{
			System.out.println(al.get(i));
		}
	}
}