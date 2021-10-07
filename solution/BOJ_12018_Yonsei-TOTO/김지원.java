import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] minArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 과목 수
        M = Integer.parseInt(st.nextToken()); // 주어진 마일리지
        minArr = new int[N]; //각 과목별로 수강신청 하기위해 필요한 최소 마일리지 목록

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 과목에 신청한 사람 수
            int l = Integer.parseInt(st.nextToken()); // 과목당 수강인원
            Integer[] mList = new Integer[p]; // 이미 신청한 사람들의 마일리지, 내림차순 위해 Integer[]선언
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < p; j++) {
                mList[j] = Integer.parseInt(st.nextToken());
            }
            //1. 만약 기존에 신청한 인원수 < 수강인원 Then, 1점을 리스트에 저장
            if(p < l) {
                minArr[i] = 1;
                continue;
            }else {
                //2. 과목마다 내림차순 정렬
                Arrays.sort(mList, Collections.reverseOrder());
                //2-1. 수강인원(l)번째 사람만큼의 마일리지만 넣으면 수강신청이 됨. 해당 마일리지 리스트에 넣기
                minArr[i] = mList[l-1];
            }
        }

        //3. 리스트를 오름차순 정렬, 0번째부터 마일리지의 합 < 주어진 마일리지(m) 까지 갯수 출력
        Arrays.sort(minArr);
        int cnt = 0; // 수강신청 가능한 갯수
        int mSum = 0; // 0번째부터 마일리지의 합
        for(int i = 0; i < N; i++) {
            mSum += minArr[i];
            if(mSum > M) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
