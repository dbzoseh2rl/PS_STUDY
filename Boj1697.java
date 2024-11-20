import java.io.*;
import java.util.*;

public class Boj1697 {
    static int[] visited = new int[100001];
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, -1);
        if(n==k) {
            System.out.println(0);
        } else {
            bfs(n);
        }
    }
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            int first = u + 1;
            int second = u -1;
            int third = u * 2;
            if (first <= 100000 && visited[first] == -1) {
                visited[first] = visited[u] + 1;
                if (first == k) {
                    System.out.println(visited[first]);
                    return;
                }
                q.offer(first);
            }
            if (second >= 0 && visited[second] == -1) {
                visited[second] = visited[u] + 1;
                if (second == k) {
                    System.out.println(visited[second]);
                    return;
                }
                q.offer(second);
            }
            if (third <= 100000 && visited[third] == -1) {
                visited[third] = visited[u] + 1;
                if (third == k) {
                    System.out.println(visited[third]);
                    return;
                }
                q.offer(third);
            }
        }


    }
}
