
import java.util.*;

public class practice
{
	public static void main(String[] args)
	{
		Map<Integer,String> classes = new HashMap<>();
		
		classes.put(3311,"Object Oriented");
		classes.put(4321,"Software testing");
		classes.put(3315, "Theoretical CS");
		classes.put(4314, "Professional practices");
		classes.put(4322, "Project management");
		
		printMap(classes);
		
		if(classes.containsKey(4321))
			System.out.println("true");
		
		classes.put(3311, "Object Oriented SE");
		
		classes.remove(4322);
		
		printMap(classes);
	}
	
	public static void printMap(Map<Integer, String> myMap)
	{
		for(int c : myMap.keySet())
		{
			System.out.println(c+" - "+myMap.get(c));
		}
	}
}