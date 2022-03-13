import java.util.Scanner;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

    List<Integer> arr = new ArrayList<Integer>();
		for (int test_case = 1; test_case <= T; test_case++) {

			System.out.print("#" + test_case + " ");
			
			arr.clear();
			long in_num = sc.nextLong();

			// 약수 얻기
			for (int i = 1; i <= in_num; i++) {
				if (in_num % i == 0) {
					arr.add(i);
				}
			}
			
			if (arr.size() % 2 != 0) { //약수의 개수 : 홀수
				if (arr.get(arr.size() / 2) < 10) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else { //약수의 개수 : 짝수
				if(arr.get(arr.size()/2 - 1) < 10 && arr.get(arr.size()/2) < 10) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}
}
