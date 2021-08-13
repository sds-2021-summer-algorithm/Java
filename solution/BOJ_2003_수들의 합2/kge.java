package P1260;

import java.io.*;
import java.util.*;

public class kge {
	
	static int N, M;
	static int[] nums; // ����
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
        nums = new int[N]; // ũ�� N��ŭ�� �迭 ����
        
        st = new StringTokenizer(br.readLine()); //�̰� �Է¹��������� ���� �ؾ��ϳ�?
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
		
        int start = 0, end = 0, sum = 0, count = 0; // 2 pointers (start, end)
        
        sum = nums[0];
        while (true) {
        	// sum = M
        	if (sum == M) {
        		count++;
        		sum -= nums[start++];
        	}
        	//sum < M
        	else if (sum < M) {
        		sum += nums[++end];
        	}
        	//sum >= M ?
        	else {
        		sum -= nums[start++];
        	}
        	if (end == N - 1) {
        		break;
        	}
        }
        System.out.println(count);

	}
}
