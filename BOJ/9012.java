import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		
		int num = scanner.nextInt();
		int i;
		String[] sarr;
		
		for(int repeat = 0; repeat < num; repeat++) {
			stack.clear();
			
			String str = scanner.next();
			sarr = str.split("");

			for(i = 0; i < sarr.length; i++){
					
				if(sarr[i].contains("(")){
					stack.push(sarr[i]);
				}
				else if(sarr[i].contains(")")){
					try{
						stack.pop();
					} catch(Exception e){
						System.out.println("NO");
						break;
					}
				}
			}
			
			if(i == sarr.length){
				
				if(stack.empty()){
					System.out.println("YES");
				}
				else System.out.println("NO");

			}

		}
	}
}
