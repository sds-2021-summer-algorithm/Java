import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// ��, ��, ��, �Ʒ� 
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};

    static int R, C; //���� ũ��
    static char[][] map;
    static int[][] dp; //�ִܰŸ� ����� ��
    static Queue<Point> queue;
    static boolean foundAnswer;
    
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("src/DAY01/P3055/input.txt"));
    	Scanner sc = new Scanner(System.in);
    	
    	R = sc.nextInt();
    	C = sc.nextInt();
    	
    	map = new char[R][C];
    	dp = new int[R][C];
    	queue = new LinkedList<>();
    	
    	Point st = null;
    	for (int r = 0; r < R; r++) {
    		String line = sc.next();
    		for (int c = 0; c < C; c++) {
    			map[r][c] = line.charAt(c);
    			if (map[r][c] == 'S') {
    				st = new Point(r, c, 'S');
    			} else if (map[r][c] == '*') {
    				queue.add(new Point(r, c, '*'));
    			}
    		}
    	}
    	
		while (!queue.isEmpty()) {
			// 1. ť���� ������ => S
			Point p = queue.poll();
			// 2. �������ΰ�? if(p == D)
			if (p.type == 'D') {
				System.out.println(dp[p.y][p.x]);
				foundAnswer = true;
				break;
			}
			//3. �� �� �ִ� ���� ��ȸ for(��, ��, ��, �Ʒ�)
			for (int i = 0; i < 4; i++) {
				int ty = p.y + my[i]; // +0
				int tx = p.x + mx[i]; // -1
				// 4. �� �� �ִ°�? if(���� ����� �ʰ�, [.]�̰ų� [D]�̰ų�)
				if (0 <= ty && ty < R && 0 <= tx && tx < C) {
					if (p.type =='*') {
						if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
							// 5. üũ��
							map[ty][tx] = '*';
							// 6. ť�� ���� queue.add(next)
							queue.add(new Point(ty, tx, '*'));
						}
					}else {
						// [.]�̰ų� [D]�̰ų� 
						if(map[ty][tx] == '.' || map[ty][tx] == 'D') {
							if (dp[ty][tx] == 0) {
								// 5. üũ��
								dp [ty][tx] = dp[p.y][p.x] + 1;
								// 6. ť�� ���� queue.add(next)
								queue.add(new Point(ty, tx, map[ty][tx]));
							}
						}
					}
				}
			}
		}

			if (foundAnswer == false) {
				System.out.println("KAKTUS");
			}
		}

    }

 
class Point {
	int y;
	int x;
	char type;
	
	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}
	
	@Override
	public String toString() { return "[y=" + y + ", x=" + x + ", type=" + type + "]"; }
}