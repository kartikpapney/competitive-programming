/*
    Rating: 1461
    Date: 31-03-2022
    Time: 20-40-17
    Author: Kartik Papney
    Linkedin: https://www.linkedin.com/in/kartik-papney-4951161a6/
    Leetcode: https://leetcode.com/kartikpapney/
    Codechef: https://www.codechef.com/users/kartikpapney
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D_Maximum_Product_Strikes_Back {
    public static boolean debug = false;
    static void debug(String st) {
        if(debug) p.writeln(st);
    }
    public static int[] find(int[] arr, int start, int end) {
        int cnt = 0;
        int neg = 0;
        for(int i=start; i<=end; i++) {
            if(Math.abs(arr[i]) == 2) cnt++;
            if(arr[i] < 0) neg++;
        }
        if(neg%2 == 0) {
            return new int[]{start, end+1};
        }
        int[] lans = new int[]{}, rans =  new int[]{};
        int left = cnt;
        int right = cnt;
        for(int i=start; i<=end; i++) {
            if(Math.abs(arr[i]) == 2) left--;
            if(arr[i] < 0) {
                lans = new int[]{i+1, end+1};
                break;
            }
        }
        for(int i=end; i>=start; i--) {
            if(Math.abs(arr[i]) == 2) right--;
            if(arr[i] < 0) {
                rans = new int[]{start, i};
                break;
            }
        }
        if(left >= right) {
            return lans;
        } else {
            return rans;
        }
    }
    public static void s() {
        int n = sc.nextInt();
        int[] arr = sc.readArray(n);
        int start = -1;
        int[] cans = new int[]{0, 0};
        int ctwo = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                cans = new int[]{i, i+1};
                ctwo = 1;
            }
        }
        for(int end=0; end<arr.length; end++) {
            // p.writeln(start + " " + end);
            if(arr[end] == 0) {
                int[] mans = find(arr, start + 1, end - 1);
                int mtwo = 0;
                for(int i=mans[0]; i<mans[1]; i++) {
                    if(Math.abs(arr[i]) == 2) mtwo++;
                }
                if(ctwo < mtwo) {
                    cans = mans;
                    ctwo = mtwo;
                }
                start = end;
            }
        }
        int end = arr.length;
        // p.writeln(start + " " + end);
        int[] mans = find(arr, start + 1, end-1);
        int mtwo = 0;
        for(int i=mans[0]; i<mans[1]; i++) {
            if(Math.abs(arr[i]) == 2) mtwo++;
        }
        if(ctwo < mtwo) {
            cans = mans;
            ctwo = mtwo;
        }
        p.writeln(cans[0] + " " + (n - cans[1]));
        // p.writeln();
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

        static void sort(int... a) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static void sort(long... a) {
            ArrayList<Long> l = new ArrayList<>();
            for (long i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static int max(int... a) {
            int max = Integer.MIN_VALUE;
            for (int val : a) max = Math.max(val, max);
            return max;
        }

        static int min(int... a) {
            int min = Integer.MAX_VALUE;
            for (int val : a) min = Math.min(val, min);
            return min;
        }

        static long min(long... a) {
            long min = Long.MAX_VALUE;
            for (long val : a) min = Math.min(val, min);
            return min;
        }

        static long max(long... a) {
            long max = Long.MIN_VALUE;
            for (long val : a) max = Math.max(val, max);
            return max;
        }

        static long sum(long... a) {
            long sum = 0;
            for (long val : a) sum += val;
            return sum;
        }

        static int sum(int... a) {
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

        public void yes() {
            char c = '\n';
            writeln("YES");
        }

        public void no() {
            writeln("NO");
        }

        public void writeln() {
            char c = '\n';
            strb.append(c);
        }

        public void writes(int... arr) {
            for (int val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writes(long... arr) {
            for (long val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writeln(int... arr) {
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