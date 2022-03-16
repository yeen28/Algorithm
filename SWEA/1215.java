import java.util.Scanner;

class Solution
{
    public static int cnt = 0;

	public static void proc(String[] arr, int T) {
		boolean isPalindrome_horizontal = true; //가로
		boolean isPalindrome_vertical = true; //세로
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < (8-T)+1; j++) {
				isPalindrome_horizontal = true;
				isPalindrome_vertical = true;
				
				for(int k=0; k < T/2; k++) {
					// 가로 훑기
					if(isPalindrome_horizontal && arr[i].charAt(j+k) != arr[i].charAt((j+T)-1-k)) {
						isPalindrome_horizontal = false;
					}

					// 세로 훑기
					if(isPalindrome_vertical && arr[j+k].charAt(i) != arr[j+T-1-k].charAt(i)) {
						isPalindrome_vertical = false;
					}
				}
				
				if(isPalindrome_horizontal == true)
					cnt++;
				if(isPalindrome_vertical == true)
					cnt++;
			}
		}
    }
    public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;

		for (int test_case = 1; test_case <= 10; test_case++) {
			cnt=0;
			T = sc.nextInt();
			
			String[] arr = new String[8];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.next();
			}
			proc(arr, T);
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
