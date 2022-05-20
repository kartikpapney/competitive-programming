/*
    Rating: 1378
    Date: 14-05-2022
    Time: 11-02-42
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


class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length == 1) return 0;
        int states = (1<<graph.length)-1;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<graph.length; i++) {
            q.add(new int[]{i, (1<<i)});
        }
        int[][] visited = new int[graph.length][states+1];
        int ans = 0;
        while(!q.isEmpty()) {
            ans++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] poll = q.poll();
                int node = poll[0];
                int path = poll[1];
                for(int nbr : graph[node]) {
                    int npath = path|(1<<nbr);
                    if(visited[nbr][path] == 1) continue;
                    visited[nbr][path] = 1;
                    if(npath == states) return ans;
                    q.add(new int[]{nbr, npath});
                }
            }
        }
        return -1;
    }
}

public class G_White_Black_Balanced_Subtrees {
    public static int[] find(ArrayList<ArrayList<Integer>> tree, int parent, int[] ans, String s) {
        int black = s.charAt(parent-1)=='B'?1:0, white = s.charAt(parent-1)=='B'?0:1;
        int[] crnt = new int[]{black, white};
        for(int child : tree.get(parent)) {
            int[] subtree = find(tree, child, ans, s);
            if(subtree[0] == subtree[1]) ans[0]++;
            crnt[0]+=subtree[0];
            crnt[1]+=subtree[1];
        }
        return crnt;
    }
    public static void s() {
        int n = sc.nextInt();
        int[] arr = sc.readArray(n-1);
        String s = sc.nextLine();
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<=n; i++) tree.add(new ArrayList<>());
        for(int i=0; i<n-1; i++) {
            int child = i+2;
            int parent = arr[i];
            tree.get(parent).add(child);
        }
        // System.out.println(tree);
        int[] ans = new int[1];
        int[] get = find(tree, 1, ans, s);
        if(get[0]==get[1]) ans[0]++;
        p.writeln(ans[0]);
    }
    public static void main(String[] args) {
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