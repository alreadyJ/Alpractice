import java.util.Scanner;
/**
 * Created by user on 2017-03-05.
 */
public class TheatreSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, a;
        long width, height;
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();

        if (n % a > 0) {
            width = n / a + 1;
        }else {
            width = n / a;
        }
        if (m % a > 0) {
            height = m / a + 1;
        }else {
            height = m / a;
        }
        System.out.println(width * height);
    }
}
