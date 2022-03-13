import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		StringBuilder sbAnswer = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			
			sbAnswer.append("#" + test_case + " ");
			
			int input_num = sc.nextInt();

			boolean isTrue = false;
			
			int quotient=0, remainder=0;
			for (int i = 1; i <= 9; i++) {
				quotient = input_num/i;
				remainder = input_num%i;
				
				if(remainder == 0 && quotient < 10) {
					isTrue = true;
					break;
				}
			}
			
			sbAnswer.append(isTrue ? "Yes\n" : "No\n");
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
		System.out.println(sbAnswer);
	}
}
