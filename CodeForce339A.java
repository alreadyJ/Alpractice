import java.util.Scanner;

/**
 * Created by user on 2017-03-09.
 * 식을 입력 받아서 소팅된 덧셈으로 출력
 */
public class CodeForce339A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        str = sc.nextLine();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i += 2) {
            for (int j = i + 2; j < charArray.length; j += 2) {
                if ((int)(charArray[i] - 48) > (int)(charArray[j] - 48)) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        System.out.println(charArray);

    }
}
