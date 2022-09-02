import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Queen_Blocks {
    public static void print(int[][] grid) {
        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid.length; j++) {
                p.writes(grid[i][j]);
            }
            p.writeln();
        }
    }
    public static boolean valid(int x) {
        return x>=1&&x<=8;
    }
    public static boolean ss(int[][] ans, boolean[] row, boolean[] col, boolean[] diag, boolean[] rdiag, int rem, int a, int b) {
        if(rem == 0) {
            int[][] pos = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            boolean check = row[a] == false && col[b] == false && diag[a+b] == false && rdiag[a-b+8] == false;
            for(int i=0; i<pos.length; i++) {
                int nx =a+pos[i][0];
                int ny =b+pos[i][1];
                if(valid(nx) && valid(ny)) {
                    check = (check&&(row[nx]||col[ny]||diag[nx+ny]||rdiag[nx-ny+8]));
                }
            }
            return check;
        }
        for(int i=1; i<=8; i++) {
            for(int j=1; j<=8; j++) {
                if(ans[i][j] != 0) continue;
                boolean pr = row[i], pc = col[j], pd = diag[i+j], prd = rdiag[i-j+8];
                ans[i][j] = 2;
                row[i] = true;
                col[j] = true;
                diag[i+j] = true;
                rdiag[i-j+8] = true;
                boolean check = ss(ans, row, col, diag, rdiag, rem-1, a, b);
                if(check) {
                    return true;
                }
                ans[i][j] = 0;
                row[i] = pr;
                col[j] = pc;
                diag[i+j] = pd;
                rdiag[i-j+8] = prd;
            }
        }
        return false;
    }
    public static void s(int a, int b) {
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] diag = new boolean[17];
        boolean[] rdiag = new boolean[16];
        int[][] grid = new int[9][9];
        grid[a][b] = 1;
        boolean cans = ss(grid, row, col, diag, rdiag, 1, a, b);
        if(cans) {
            print(grid);
        } else {
            grid = new int[9][9];
            grid[a][b] = 1;
            cans = ss(grid, row, col, diag, rdiag, 2, a, b);
            print(grid);
        }
    }
    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- != 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            // for(int i=1; i<=8; i++) {
            //     for(int j=1; j<=8; j++) {
            //         s(i, j);
            //         // p.writeln();
            //     }
            // }
            s(a, b);
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