package practice2;

import java.io.*;
import java.util.*;

public class P1330 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        br.close();
        
        //A�� B���� ū ���
        if (A > B)
        	System.out.println(">");
        //A�� B���� ���� ���
        else if (A < B)
        	System.out.println("<");
        //A�� B���� ���� ���
        else
        	System.out.println("==");
	}

}
