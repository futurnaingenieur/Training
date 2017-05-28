import java.util.HashSet;

public class FindPair {
	
	/*
	 * 	GOOGLE INTERVIEW TRAINING HANDS-ON #1
	 * 
	 * 	This little algorithm finds the pair able to make the sum inside an array of integers unsorted.
	 * 	To do so, I used a HashSet to store complements (the int needed to complete the number of the array to get the good sum).
	 * 	If I find one of the required complements, I know their is a pair able to get the exact sum we are looking for so I return it in an object I've created.
	 * 
	 * 	The problem is exposed in the video : https://www.youtube.com/watch?v=XKu_SEDAykw
	 * 
	 */

	public static void main(String[] args) {
	
		int[] test1 = {1,2,3,9};
		int[] test2 = {1,2,4,4};
		
		PairResult p = hasPairWithSum(test1, 8);
		PairResult p2 = hasPairWithSum(test2, 8);
		
		System.out.println();
	}
	
	public static PairResult hasPairWithSum(int[] numbers, int sum){
		HashSet complements = new HashSet(); //We will store the complement of the value we parsed
		int[] result = {-1,-1};
		for(int value: numbers){
			if(complements.contains(value)){
				result[0] = value;
				result[1] = (sum - value);
				return new PairResult(true, result);
			}
			else{
				complements.add(sum - value);
			}
		}
		return new PairResult(false, result);
	}

}
