import java.util.ArrayList;

/*HappyNumbers determines whether a given int is happy or not. A happy number eventually yields
 * 1 when summing the squares of the individual digits. A number is not happy if it creates a cycle.*/
public class HappyNumbers {

	public static void main(String[] args) {
		ArrayList<Integer> seenNums = new ArrayList<>();
		int toCheck = 113;
		if (isHappy(toCheck, seenNums)) {
			System.out.println(toCheck + " is a happy number!");
		} else {
			System.out.println(toCheck + " is a sad number.");
		}
	}
	
	/*Check if a cycle has been found using a straightforward for each loop.*/
	public static boolean alreadySeen(int num, ArrayList<Integer> seenNums) {
		for (Integer x : seenNums) {
			if (x.intValue() == num) {
				return true;
			}
		}
		return false;
	}
	
	/*Check whether the passed int value is a happy number.
	 * toCheck: the number to check if it is happy
	 * seenNums: arraylist used to track generated values and identify a cycle
	 * returns true if the number is happy, false if a cycle is identified*/
	public static boolean isHappy(int toCheck, ArrayList<Integer> seenNums) {
		// check if num is on our list
		if (alreadySeen(toCheck, seenNums)) {
			return false;
		} else {
			//add to seenNums
			seenNums.add(toCheck);
			int sum = 0;
			int tempToCheck = toCheck;
			while (tempToCheck > 0) {
				int temp = tempToCheck % 10;
				tempToCheck /= 10;
				sum += (int) (Math.pow(temp, 2));
			}
			if (sum == 1) {
				return true;
			} else {
				if (isHappy(sum, seenNums)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
}
