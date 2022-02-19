/*
    Rating: 1367
    Date: 25-01-2022
    Time: 21-23-38
    Author: Kartik Papney
    Linkedin: https://www.linkedin.com/in/kartik-papney-4951161a6/
    Leetcode: https://leetcode.com/kartikpapney/
    Codechef: https://www.codechef.com/users/kartikpapney
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A_Portal {
    public static final int countBlack(int[][] arr, int a, int b, int c, int d) {
        return arr[c][d] - arr[a-1][d] - arr[c][b-1] + arr[a-1][b-1];
    }
    public static final int countWhite(int[][] arr, int a, int b, int c, int d) {
        int x = c - a + 1;
        int y = d - b + 1;
        return x*y - countBlack(arr, a, b, c, d);
    }
    static final int[][] arr = new int[402][402];
    public static void s() {
        int n = sc.nextInt(), m = sc.nextInt();
        String[] map = new String[n + 1];
        for(int i=1; i<=n; i++) map[i] = sc.nextLine();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++) {
                arr[i][j] = (map[i].charAt(j-1) - '0') + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        int dp = 16;
        int mincost = 16;
        for(int l=1; l<=m; l++) {
            for(int r=l+3; r<=m; r++) {
                for(int i=5; i<=n; i++) {
                    int a = 
                        countBlack(arr, i-3, l+1, i-1, r-1)
                        + countWhite(arr, i, l+1, i, r-1)
                        + countWhite(arr, i-4, l+1, i-4, r-1)
                        + countWhite(arr, i-3, l, i-1, l)
                        + countWhite(arr, i-3, r, i-1, r);
                    int b = Integer.MAX_VALUE;
                    if(i > 5) {
                        b = 0;
                        b = dp
                            - countWhite(arr, i-1, l+1, i-1, r-1)
                            + countBlack(arr, i-1, l+1, i-1, r-1)
                            + countWhite(arr, i, l+1, i, r-1)
                            + countWhite(arr, i-1, l, i-1, l)
                            + countWhite(arr, i-1, r, i-1, r);
                    }
                    dp = Math.min(a, b);
                    mincost = Math.min(mincost, dp);
                }
            }
        }
        p.writeln(mincost);
    }

    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- != 0) {
            s();
        }
        p.print();
    }


    static final Integer MOD = (int) 1e9 + 7;
    static final FastReader sc = new FastReader();
    static final Print p = new Print();

    static class Functions {

        static void sort(int[] a) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static void sort(long[] a) {
            ArrayList<Long> l = new ArrayList<>();
            for (long i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static int max(int[] a) {
            int max = Integer.MIN_VALUE;
            for (int val : a) max = Math.max(val, max);
            return max;
        }

        static int min(int[] a) {
            int min = Integer.MAX_VALUE;
            for (int val : a) min = Math.min(val, min);
            return min;
        }

        static long min(long[] a) {
            long min = Long.MAX_VALUE;
            for (long val : a) min = Math.min(val, min);
            return min;
        }

        static long max(long[] a) {
            long max = Long.MIN_VALUE;
            for (long val : a) max = Math.max(val, max);
            return max;
        }

        static long sum(long[] a) {
            long sum = 0;
            for (long val : a) sum += val;
            return sum;
        }

        static int sum(int[] a) {
            int sum = 0;
            for (int val : a) sum += val;
            return sum;
        }

        public static long mod_add(long a, long b) {
            return (a % MOD + b % MOD + MOD) % MOD;
        }

        public static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) != 0)
                    res = mod_mul(res, a);
                a = mod_mul(a, a);
                b >>= 1;
            }
            return res;
        }

        public static long mod_mul(long a, long b) {
            long res = 0;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) > 0) {
                    res = mod_add(res, a);
                }
                a = (2 * a) % MOD;
                b >>= 1;
            }
            return res;
        }

        public static long gcd(long a, long b) {
            if (a == 0) return b;
            return gcd(b % a, a);
        }

        public static long factorial(long n) {
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = (i % MOD * res % MOD) % MOD;
            }
            return res;
        }

        public static int count(int[] arr, int x) {
            int count = 0;
            for (int val : arr) if (val == x) count++;
            return count;
        }

        public static ArrayList<Integer> generatePrimes(int n) {
            boolean[] primes = new boolean[n];
            for (int i = 2; i < primes.length; i++) primes[i] = true;
            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    for (int j = i * i; j < primes.length; j += i) {
                        primes[j] = false;
                    }
                }
            }
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < primes.length; i++) {
                if (primes[i]) arr.add(i);
            }
            return arr;
        }
    }

    static class Print {
        StringBuffer strb = new StringBuffer();

        public void write(Object str) {
            strb.append(str);
        }

        public void writes(Object str) {
            char c = ' ';
            strb.append(str).append(c);
        }

        public void writeln(Object str) {
            char c = '\n';
            strb.append(str).append(c);
        }

        public void writeln() {
            char c = '\n';
            strb.append(c);
        }

        public void writes(int[] arr) {
            for (int val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writes(long[] arr) {
            for (long val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writeln(int[] arr) {
            for (int val : arr) {
                writeln(val);
            }
        }

        public void print() {
            System.out.print(strb);
        }

        public void println() {
            System.out.println(strb);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        double[] readArrayDouble(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        String nextLine() {
            String str = new String();
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}