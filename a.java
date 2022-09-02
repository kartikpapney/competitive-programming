import java.util.*;
public class a {
    static int MAX = 1000006;
    static boolean[] prime = new boolean[MAX];
    static int[] count = new int[MAX];
    static boolean[] check = new boolean[MAX];
    static boolean isPal(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static void printPalPrimesLessThanN()
    {
        Arrays.fill(prime, true);
        for (long p = 2; p*p < MAX; p++)
        {
            if (prime[(int)p])
            {
                // Update all multiples of p
                for (long i = p*2; i < MAX; i += p){
                    prime[(int)i] = false;}
            }
        }
        for (int p = 2; p < MAX; p++){
           if (prime[p] && isPal(p+"")){
                count[p]++;
                check[p] = true;
              }
           }
           for(int i=1; i<count.length; i++) count[i]+=count[i-1];
    }
    public static int find(int L, int R) {
        return count[R] - count[L];
    }
//     101
// 131
// 151
// 181
// 191
    public static void main(String[] args) {
        printPalPrimesLessThanN();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            
            int ans = find(L, R) + (check[L]?1:0);
            System.out.println( ans );
        }
    }
}