package P2042;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static long[] nums;
	static long[] tree;
	static int S;
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        nums = new long[N + 1];
        

        for (int i = 0; i < N; i++) {
        	nums[i] = Long.parseLong(br.readLine());
        }
        
        S = 1; //S�� leaf �� ����
        while (S < N) {
        	S *= 2; // N�� 5���� ����Ʈ���ϱ� 8���� �ʿ���.
        }
        tree = new long[S * 2];
        
        init();
        
        

        for (int i = 0; i < M+K; i ++) {
            st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
      	
        	
        	if (a == 1) { // ������ �ϰ� �ʹٸ�
            	int b = Integer.parseInt(st.nextToken());
            	long c = Long.parseLong(st.nextToken()); // a == 1�� ��� b��° �ڸ��� c�� �ٲٶ�� �ǵ� c�� ������ int �� ��� ���� ���� (100%���� Numberformat ���� �߻�)
        		update(b, c);
        		
        	}
        	else if (a ==2) { // �������� ���ϰ� ������
            	int b = Integer.parseInt(st.nextToken());
            	int c = Integer.parseInt(st.nextToken());
        		System.out.println(query(b,c));

        	}
        }
        

		bw.flush();
		bw.close();
		br.close();
        	

	}
	
	static void init() {
		//leaf�� ���� �ݿ�
		for (int i = 0; i < N; i++) {
			tree[S + i] = nums[i];
		}
		//���� ��� ä��
		for (int i = S - 1; i > 0; i--) {
			tree[i] = tree [i * 2] + tree[i * 2 + 1];
		}
	}
	
	// left, right : ���� ��� ��ȣ
	//queryleft, queryright : ���� ���� ���ϰ� ���� ����
	static long query(int queryleft, int queryright) {
		int left = S + queryleft - 1;
		int right = S + queryright - 1;
		long sum = 0;
		while (left <= right) {
			// ���� ��尡 Ȧ���̸� ���� ��� �� ����ϰ� ��ĭ ������
			if (left %2 == 1) {
				sum += tree[left++];
			}
			//���� ��尡 ¦���̸� ���� ��� �� ����ϰ� ��ĭ ������
			if (right %2 == 0) {
				sum += tree[right--];
			}
			//����. ���� ��� �θ�� �̵�
			left /= 2;
			right /= 2;
		}
		return sum;
		
	}
	
	
	static void update(int target, long value) {
		int node = S + target - 1; // 3��°�� �ٲٰ� ������ �������۳�� + 3 - 1;
		// ���� ����
		tree[node] = value;
		//root �� �����Ҷ����� ���� ����(Bottom up)
		node /= 2; // �θ����
		while (node > 0) {
			tree[node] = tree[node*2] + tree[node*2 + 1];
			node /=2;
		}
		
	}
	
}