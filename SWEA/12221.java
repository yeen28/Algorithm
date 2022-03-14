import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

    int a=0, b=0;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
      sb.append("#" + test_case + " ");
			
			a = sc.nextInt(); b = sc.nextInt();
			if(a > 9 || b > 9) sb.append("-1\n");
	    else sb.append((a*b) + "\n");   
    }
		System.out.println(sb);
	}
}
