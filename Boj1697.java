import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int X = list.get(0);
        int K = list.get(1);

        System.out.println(bfs(X, K, 0));

    }

    public static int bfs(int x, int K, int t) {
        if (x == K) {
            return 0;
        }
        Queue<List<Integer>> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.add(new ArrayList<>(List.of(x, t)));
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            Integer nowX = poll.get(0);
            Integer time = poll.get(1);
            for (int i = 0; i < 3; i++) {
                int dx = 0;
                if (i == 0) {
                    dx = nowX - 1;
                }
                if (i == 1) {
                    dx = nowX + 1;
                }
                if (i == 2) {
                    dx = nowX * 2;
                }

                if (0 <= dx && dx <= 100000) {
                    if (dx == K) {
                        return time + 1;
                    }
                    if (!visited[dx]) {
                        visited[dx] = true;
                        queue.add(new ArrayList<>(List.of(dx, time + 1)));
                    }
                }
            }
        }
        return 0;
    }
}
