/*
    Rating: 1378
    Date: 18-05-2022
    Time: 11-57-10
    Author: Kartik Papney
    Linkedin: https://www.linkedin.com/in/kartik-papney-4951161a6/
    Leetcode: https://leetcode.com/kartikpapney/
    Codechef: https://www.codechef.com/users/kartikpapney

----------------------------Jai Shree Ram----------------------------

*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class E_2_Close_Tuples_hard_version {
    static long[] fac;
    private static int bs(int[] arr, int val) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] <= val) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
    static long power(long x, long y, long p)
    {
 
        // Initialize result
        long res = 1;
 
        // Update x if it is more than or
        // equal to p
        x = x % p;
 
        while (y > 0) {
 
            // If y is odd, multiply x
            // with result
            if (y % 2 == 1)
                res = (res * x) % p;
 
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
 
        return res;
    }
 
    // Returns n^(-1) mod p
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }
 
    // Returns nCr % p using Fermat's
    // little theorem.
    static long nCrModPFermat(long n, long r,
                             long p)
    {
 
          if (n<r)
              return 0;
      // Base case
        if (r == 0)
            return 1;

        return (fac[(int)n] * modInverse(fac[(int)r], p)
                % p * modInverse(fac[(int)(n - r)], p)
                % p)
            % p;
    }

    private static long ncr(long n, long r) {
        return nCrModPFermat(n, r, MOD);
    }
    public static void s() {
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        
        int[] arr = sc.readArray(n);
        Functions.sort(arr);
        long ans = 0;
        for(int i=0; i<arr.length; i++) {
            int upper = bs(arr, arr[i]+k);
            int diff = upper - i;
            long val = ncr(diff, m-1);
            if(val == -1) continue;
            ans += val;
            ans%=MOD;
        }
        p.writeln(ans);
    }
    public static void main(String[] args) {
        fac = new long[(int)2e5 + 1];
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++)
            fac[i] = fac[i - 1] * i % MOD;
        int t = 1;
        t = sc.nextInt();
        while (t-- != 0) {
            s();
        }
        p.print();
    }


    public static boolean debug = false;
    static void debug(String st) {
        if(debug) p.writeln(st);
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

        public void writeln() {
            char c = '\n';
            strb.append(c);
        }
        public void yes() {
            char c = '\n';
            writeln("YES");
        }

        public void no() {
            writeln("NO");
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