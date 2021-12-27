import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] map = new char[8][8];
    static Queue<Point> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static boolean flag = false;    // 도달할 수 있는지를 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
        }
        q.offer(new Point(7, 0));

        while (!q.isEmpty() && !flag) {
            bfs();
            moveWall();
        }

        if (flag) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.close();
        br.close();
    }

    static void bfs() {
        int sizeQ = q.size();

        for (int i = 0; i < sizeQ; i++) {
            if (flag) { // 이미 도착하는 방법을 찾았다면 리턴
                return;
            }

            Point cur = q.poll();

            if (map[cur.x][cur.y] == '#') { // 현재 위치가 벽으로 바뀌면 컨티뉴
                continue;
            }

            if (cur.x == 0 && cur.y == 7) { // 최우상단에 도착했으면 도착 가능을 표시하고 리턴
                flag = true;
                return;
            }

            for (int j = 0; j < 9; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if (inRange(nx, ny) && map[nx][ny] == '.') {
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    static void moveWall() {
        // 마지막 줄
        for (int i = 0; i < 7; i++) {
            map[7][i] = '.';
        }

        // 맨 아랫 줄을 제외한 줄들의 벽을 한 칸 내림
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i + 1][j] = '#';
                    map[i][j] = '.';
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return true;
        }
        return false;
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
