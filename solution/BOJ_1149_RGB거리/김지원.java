import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] Cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            Cost[i][0] = Integer.parseInt(st.nextToken());
            Cost[i][1] = Integer.parseInt(st.nextToken());
            Cost[i][2] = Integer.parseInt(st.nextToken());

        }

        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
        for (int i = 1; i < N; i++) {
            Cost[i][0] += Math.min(Cost[i - 1][1], Cost[i - 1][2]);
            Cost[i][1] += Math.min(Cost[i - 1][0], Cost[i - 1][2]);
            Cost[i][2] += Math.min(Cost[i - 1][0], Cost[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(Cost[N - 1][0], Cost[N - 1][1]), Cost[N - 1][1]));
    }
}
