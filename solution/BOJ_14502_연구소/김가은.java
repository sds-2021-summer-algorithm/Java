package P14502;

import java.io.*;
import java.util.*;


public class Main {
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M; // ������ ũ�� N X M
	static int[][] map; //������
	static int[][] copy; // ������ ���纻
	static int max = 0; // �ִ� ���� ����
	
	//�����¿�
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	// ���̷��� ��ġ ����
	static ArrayList<Point> vList;

	
	public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken()); //���� ũ��
      M = Integer.parseInt(st.nextToken()); //���� ũ��
      
      map = new int[N+1][M+1];
      copy = new int[N+1][M+1];
      vList = new ArrayList<Point>();
      
      for (int i = 0; i < N; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  for (int j = 0; j < M; j++) {
    		  map[i][j] = Integer.parseInt(st.nextToken());
    		  if (map[i][j] == 2) {
    			  vList.add(new Point(i, j));
    		  }
    		  
    	  }
      } //������ �Է�
      
      
      dfs(0);
      
      bw.write(max + "\n");
      
      bw.flush();
      bw.close();
      br.close();
      
	}
	
	//���� ����� �Լ� --> dfs
	public static void dfs(int cnt) {
		//���� 3�� ���� ���
		if (cnt == 3) {
			bfs(); //���̷��� ��Ʈ����
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // ��ĭ�̶��
					map[i][j] = 1; // �� �����
					dfs(cnt + 1);
					map[i][j] = 0; // ���� ����� ���� ���ؼ� ����!
				}
			}
		}
	}
	
	// ���̷����� ��Ʈ���� �Լ� --> bfs
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j]; //map ����
			}
		}
		
		for (int i = 0; i < vList.size(); i++) {
			q.add(new Point(vList.get(i).x, vList.get(i).y));
		} //�Է½� �����ߴ� ���̷����� ť�� ��� ����
			
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2) { // ���̷����� �ִٸ�
					q.add(new Point(i,j)); //ť�� �ֱ�
				}
			}
		}
		
		while (!q.isEmpty()) {
			Point p = q.poll(); //ť���� ������
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < 4; i++) { // �������� Ž��
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) { //���� �ȿ� ������
					if (copy[nx][ny] == 0) {
						copy[nx][ny] = 2;
						q.add(new Point(nx,ny));
					}
					
				}
			}
		}
		max = Math.max(max, safe());
	}
	
	//���������� ���ϴ� �Լ�
	public static int safe() {
		int cnt = 0;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=M; j++) {
				if (copy[i][j] == 0) { // ��ĭ�̶��
					cnt ++;
				}
			}
		}
		return cnt;
			
	}
	
}