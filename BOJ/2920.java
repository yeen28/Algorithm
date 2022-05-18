import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        Main main = new Main();
        main.input();
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        String scales = sc.nextLine();
        
        StringTokenizer stk = new StringTokenizer(scales, " ");
        Integer[] arrScales = new Integer[8];

        for (int i = 0; i < arrScales.length; i++) {
            if (stk.hasMoreTokens()) {
                arrScales[i] = Integer.parseInt(stk.nextToken());
            } // end if
        } // end for

        proc(arrScales);
    }// input

    private void proc(Integer[] arrScales) {
        Integer[] sortArrScales = new Integer[arrScales.length];
        for(int i=0; i<arrScales.length; i++) sortArrScales[i] = arrScales[i];
        
        Arrays.sort(sortArrScales);
        if(Arrays.equals(sortArrScales, arrScales)) {
            System.out.println("ascending");
            return;
        }
		
        Arrays.sort(sortArrScales, Collections.reverseOrder());
        if(Arrays.equals(sortArrScales, arrScales)) {
            System.out.println("descending");
            return;
        }
        
        System.out.println("mixed");
    }
}
