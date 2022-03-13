import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			/////////////////////////////////////////////////////////////////////////////////////////////
            String str = sc.next();
            System.out.print("#" + test_case + " ");
            proc(str);   
        }
    }
    
    public static void proc(String str){
        int k = str.length();
        if(k < 8){
            System.out.println("YES");
            return;
        }

        int xCnt = 0;
        for(int i=0; i<k; i++){
            if(str.charAt(i) == 'x'){
                xCnt++;
            }
        }
        if(xCnt > 7){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        return;
		/////////////////////////////////////////////////////////////////////////////////////////////
    }
}
