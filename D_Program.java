import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class D_Program {
    public static int find(int[] arr, int h) {
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > h) {
                ans = arr.length - 1 - mid + 1;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String name = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] collection = br.readLine().split(" ");
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(collection[i]);
        Arrays.sort(arr);
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            int h = Integer.parseInt(br.readLine());
            System.out.println(find(arr, h));
        }

    }
}
