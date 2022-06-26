import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        
        for(int i=n; i>0; i--){
            for(int j=i; j>0; j--){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
