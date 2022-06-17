import java.util.*;

public class QUE_1 {
    public static void print(String s, StringBuilder asf, boolean[] visited, int vcount) {
        if(vcount == s.length()) {
            System.out.println(asf.toString());
            return;
        }
        for(int i=0; i<s.length(); i++) {
            if(!visited[i]) {
                asf.append(s.charAt(i));
                visited[i] = true;
                print(s, asf, visited, vcount+1);
                visited[i] = false;
                asf.deleteCharAt(asf.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        print(s, new StringBuilder(), new boolean[s.length()], 0);
    }
}