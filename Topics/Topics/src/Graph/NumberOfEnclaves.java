package Graph;

import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {

                    if(grid[i][j] == 1) {
                        q.add(new int[]{i, j});
                        while(!q.isEmpty()) {
                            int[] top = q.poll();
                            int x = top[0];
                            int y = top[1];
                            if(grid[x][y] == 0) continue;
                            grid[x][y] = 0;
                            if(x+1<n) q.add(new int[]{x+1, y});
                            if(y+1<m) q.add(new int[]{x, y+1});
                            if(x-1>=0) q.add(new int[]{x-1, y});
                            if(y-1>=0) q.add(new int[]{x, y-1});
                        }
                    }

                }

            }
        }
        int sum = 0;
        for(int[] arr : grid) for(int val : arr) sum += val;
        return sum;
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(new int[]{start[i], end[i], i});
        }
        arr.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int meetingcount = 1;
        int cend = arr.get(0)[1];
        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i)[0] >= cend) {
                meetingcount++;
                cend = arr.get(i)[1];
            }
        }
        return meetingcount;
    }
}