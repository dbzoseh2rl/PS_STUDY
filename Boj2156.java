import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] l = new int[n + 1];
        int[][] d = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            l[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(l[1]);
            return;
        }

        d[1][0] = 0;
        d[1][1] = l[1];
        d[1][2] = 0;

        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][1] = d[i - 1][0] + l[i];
            d[i][2] = d[i - 1][1] + l[i];
        }

        int answer = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
        System.out.println(answer);
    }
}
