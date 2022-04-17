package codingquestions;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesfromArray {

	public static void main(String[] args) {
		
		List<Integer> primes = new ArrayList<Integer>(); 
		   primes.add(2);
		   primes.add(3);
		   primes.add(5); 
		   primes.add(7); //duplicate
		   primes.add(7); 
		   primes.add(11);

			System.out.println("List "+primes);
		    for(int i=0;i<primes.size();i++)
		    {
		    	System.out.println(primes.get(i)+ " "+ i);
		    }
		Set<Integer> dup=new HashSet<Integer>(primes);
	    System.out.println("set "+dup);
	    primes.clear();
	    System.out.println("cleared list "+primes);
	    primes.addAll(dup);
	    System.out.println("List without dups"+primes);

//array to set  
		int arrs[]={10,12,12,4,5,5,22,41,10};
		Set<Integer> duparrs=new HashSet<Integer>();
		Set<Integer> dupset=new HashSet<Integer>();
			  for(int i=0;i<arrs.length;i++)
				    {
//				  		duparrs.add(arrs[i]);
//				    	System.out.println(duparrs+ " "+ i);
				    	 if (!duparrs.add(arrs[i])) 
				    	 {
				             dupset.add(arrs[i]);
				         }
				    }
			  System.out.printf("Unsorted array in Java :%s %n",Arrays.toString(arrs));
			  System.out.println("Array set only dups "+dupset);  
			  System.out.println("Array set without dups"+duparrs); 
		

	}

}
