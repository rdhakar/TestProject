/**
 * 
 */
package my.test.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rajendra.Dhakar
 *
 */
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
		
		System.out.print( "Source {");
		for (int i : randomIntegers){
			System.out.print(i+",");
		}
		System.out.println( "}");
		
		System.out.print( "New from removeDuplicates1 =  {");
		for(Integer o : removeDuplicates1(randomIntegers)){			
			System.out.print(o+",");
		}
		System.out.println( "}");

		System.out.print( "New from removeDuplicates2 =  {");
		for(Integer o : removeDuplicates2(randomIntegers)){			
			System.out.print(o+",");
		}
		System.out.println( "}");

		System.out.print( "New from removeDuplicates3 =  {");
		for(int o : removeDuplicates3(randomIntegers)){			
			System.out.print(o+",");
		}
		System.out.println( "}");
		
		System.out.print( "New from removeDuplicates4 =  {");
		for(int o : removeDuplicates4(randomIntegers)){			
			System.out.print(o+",");
		}
		System.out.println( "}");
		

	}
	/**
	 * removeDuplicates1 is removes duplicate from the int arrays - With  LinkedHashSet to maintain order 
	 * @param numbers
	 * @return
	 */
	public static Integer [] removeDuplicates1(int [] numbers){
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		for (int i =0; i<numbers.length; i++){
		    set.add(numbers[i]);	
		}
		Integer newArry[] = new Integer [set.size()];
		return  ( Integer [] ) set.toArray(newArry);
	}
	
	
	
	
	
    /**
     * removeDuplicates2 is removes duplicate from the int arrays - With  HashSet  and ArrayList to maintain order 
     * @param numbers
     * @return
     */
	public static Integer [] removeDuplicates2(int [] numbers){
		List<Integer> resultList = new ArrayList<Integer>(); 
		Set<Integer> set = new HashSet<Integer>();
		for (int i =0; i<numbers.length; i++){
		    if(set.add(numbers[i])){
		    	resultList.add(numbers[i]);
		    }
		}
		Integer newArry[] = new Integer [resultList.size()];
		return ( Integer [] ) resultList.toArray(newArry);
	}
	/**
	 * removeDuplicates3 is removes duplicate from the int arrays - With  int Array  and isExist method
	 * @param numbers
	 * @return
	 */
	public static int [] removeDuplicates3(int [] numbers){
			int[] list = new int[numbers.length];
		int j=0;
		for (int i =0; i<numbers.length; i++){
		    if(!isExist(list,numbers[i],j)){
		    	list[j++]=numbers[i];
		    }
		}
		return Arrays.copyOf(list, j);
	}
	/**
	 * isExist, checks it the given number already in array returns true if it exist otherwise false 
	 * @param list
	 * @param i
	 * @return
	 */
	private static boolean isExist(int[] list, int val, int end){
		boolean result =false;
		if(list != null && list.length!=0) {
			for (int i=0;i<end;i++){
				if(list[i]==val){
					result = true;
					break;
				}
			}
		}
		
		return result;
		
	} 
	/**
	 * removeDuplicates4 , is pure array opration to remove duplicate - SiftLeft Array element in case of duplicate
	 * @param arr
	 * @return
	 */
	public static int[] removeDuplicates4(int[] arr) {

	    int end = arr.length;

	    for (int i = 0; i < end; i++) {
	        for (int j = i + 1; j < end; j++) {
	            if (arr[i] == arr[j]) {                  
	                int shiftLeft = j;
	                for (int k = j+1; k < end; k++, shiftLeft++) {
	                    arr[shiftLeft] = arr[k];
	                }
	                end--;
	                j--;
	            }
	        }
	    }

	    int[] list = new int[end];
	    for(int i = 0; i < end; i++){
	    	list[i] = arr[i];
	    }
	    return list;
	}
	
	
}
