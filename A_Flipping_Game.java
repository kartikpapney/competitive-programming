/*
    Rating: 1367
    Date: 24-02-2022
    Time: 16-19-05
    Author: Kartik Papney
    Linkedin: https://www.linkedin.com/in/kartik-papney-4951161a6/
    Leetcode: https://leetcode.com/kartikpapney/
    Codechef: https://www.codechef.com/users/kartikpapney
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A_Flipping_Game {
    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        for(int val : nums) {
            while(true) {
                long lastelement = res.isEmpty()?1:res.getLast();
                long gcd = gcd(lastelement, val);
                if(gcd == 1) break;
                val*=lastelement;
                val/=gcd;
            }   
            res.add(val);
        }
        return res;
    }

    public static boolean debug = false;
    static void debug(String st) {
        if(debug) p.writeln(st);
    }
    static ArrayList<Long> nm = new ArrayList<>();
    static HashSet<ArrayList<Long>> cln = new HashSet<>();
    public static void fi(int i, long sum, long nt) {
        if(i == nm.size()) {
            if(cntBit(sum) == 1) return;
            ArrayList<Long> x = new ArrayList<>();
            x.add(sum);
            x.add(nt);
            cln.add(x);
            return;
        }
        fi(i+1, sum + nm.get(i), nt + 1);
        fi(i+1, sum, nt);
        Collections.rev
    }
    public static void f() {
        HashSet<Long> set = new HashSet<>();
        long f = 1;
        long c = 1;
        while(f <= 1e12) {
            set.add(f);
            f*=(c+1);
            c++;
        }
        for(long val : set) nm.add(val);
        // Collections.sort(cln);
        fi(0, 0l, 0l);
    }
    static int cntBit(long n) {
        int c = 0;
        while(n != 0) {
            c++;
            n -= (n&(-n));
        }
        return c;
    }
    public static void s() {
        long n = sc.nextLong();
        long c = cntBit(n);
        for(ArrayList<Long> ar : cln) {
            long val = ar.get(0);
            long nt = ar.get(1);
            if((n|val) == n && n-val != 1) {
                int copy = cntBit(n-val);
                // c = Math.min(c, cntBit(copy));
                if(c > copy + nt) {
                    c = copy + nt;
                    // p.writeln(n + " " + val + " ");
                }
            }
        }
        p.writeln(c);
        // p.writeln();
    }
    public static void main(String[] args) {
        f();
        int t = 1;
        // p.writes(cln.size());
        // p.writeln();
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