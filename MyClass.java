import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt(), b = sc.nextInt();
        if(b > n/2) {
            int copy = a;
            a = b;
            b = a;
        }
        if((b-a)==n/2) System.out.println(0);
        else System.out.println((b-a-1));
    }
}
