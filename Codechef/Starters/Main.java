import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static class Pair {
        String s;
        int count;
        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }

    }
    public static void s() {
        int n = sc.nextInt();
        String s = sc.nextLine();
        if(s.length()%2 != 0) {
            p.writeln("NO");
        } else {
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder first = new StringBuilder(), second = new StringBuilder();
            HashMap<String, Integer> map = new HashMap<>();
            boolean check = true;
            for(int i=0; i<count.length; i++) {
                if(count[i] <= 1) continue;
                int instance = count[i] - count[i]%2;
                count[i] -= instance;
                map.put((char)(i + 'a') + "" + (char)(i + 'a') + "", instance/2);
            }
            for(int i=0; i<count.length; i++) {
                if(count[i] == 0) continue;
                for(int j=i+1; j<count.length; j++) {
                    if(count[j] != 0) {
                        map.put((char)(i + 'a') + "" + (char)(j + 'a') + "", 1);
                        count[i]--;
                        count[j]--;
                        break;
                    }
                }
            }
            ArrayList<Pair> arr = new ArrayList<>();
            for(Map.Entry<String, Integer> mp : map.entrySet()) {
                arr.add(new Pair(mp.getKey(), mp.getValue()));
            }
            Deque<Character> dq = new ArrayDeque<>();
            for(int i=0; i<arr.size(); i++) {
                if(arr.get(i).count == 0) continue;
                for(int j=i+1; j<arr.size(); j++) {
                    if(arr.get(j).count == 0) continue;
                    String a = arr.get(i).s;
                    String b = arr.get(j).s;
                    
                }
            }
            for(int i=0; i<ans.length(); i++) {
                if(ans.charAt(i) == ans.charAt(ans.length() - i - 1)) {
                    p.writeln("NO");
                    return;
                }
            }
            p.writeln("YES");
            p.writeln(ans);
        }
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