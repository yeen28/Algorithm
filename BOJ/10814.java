import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static class Human{
		int age;
		String name;
		
		public Human(int age, String name){
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.proc(main.input());
	} // main

	public Human[] input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(br.readLine());

		Human[] humans = new Human[T];
		
		for(int i=0; i<T; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int age = Integer.parseInt(stk.nextToken());
			String name = stk.nextToken();
			humans[i] = new Human(age, name);
		} //end for i
		
		return humans;
	} //input
	
	private void proc(Human[] humans) {
		Arrays.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.age - o2.age;
			}
		});
		
		for(Human val : humans) {
			System.out.print(val.toString());
		}
	}
}
