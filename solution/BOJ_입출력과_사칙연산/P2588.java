package practice;

import java.io.*;
import java.util.*;

public class P2588 {
	public static void main(String[] args) throws Exception{
		//����
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //���� ��ü �Է� ���� ��
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        

        br.close();
        
        System.out.println(A * (B%10));
        System.out.println(A * ((B%100)/10));
        System.out.println(A * (B/100));
        System.out.println(A * B);
	}

}
