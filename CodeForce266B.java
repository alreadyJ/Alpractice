import java.util.Scanner;

/**
 * Created by root on 3/9/17. 
 * BG가 순서대로 있음 
 * 1 ~ n BG이면 GB로 바꿔줌 
 */
public class CodeForce266B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countClass, sec;
        String sequance = null;
        char[] charSequanceArray = null;
        countClass = sc.nextInt();
        sec = sc.nextInt();
        sc.nextLine(); // clear buffer

        sequance = sc.nextLine();
        charSequanceArray = sequance.toCharArray();

        for (int j = 0; j < sec; j++) {

            for (int i = 0; i < countClass - 1; i++) {

                if (charSequanceArray[i] == 'B' && charSequanceArray[i + 1] == 'G') {
                    char temp = charSequanceArray[i + 1];
                    charSequanceArray[i + 1] = charSequanceArray[i];
                    charSequanceArray[i] = temp;
                    i++;
                }
            }

        }
        System.out.println(charSequanceArray);
    }
}