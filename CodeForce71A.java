import java.util.Scanner;

/**
 * Created by user on 2017-03-05.
 */
public class CodeForce71A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        count = sc.nextInt();
        String[] strs = new String[count];
        sc.nextLine();

        for(int i = 0; i < count; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < count; i++) {
            if (strs[i].length() < 11) {
                System.out.println(strs[i]);
            }else {
                System.out.println(strs[i].charAt(0) + "" +
                        (strs[i].length() - 2)+ "" +
                        strs[i].charAt(strs[i].length() - 1));
            }
        }

    }
}
