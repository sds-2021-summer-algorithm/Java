package practice;

import java.io.*;
import java.util.*;

public class P10998 {
	public static void main(String[] args) throws Exception{
		//����
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // space�� ���� ������� �� ���
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        //������ �Է��̸�, ����ȯ �ʼ�
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        System.out.println(A * B);
	}

}
