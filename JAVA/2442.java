import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 종료조건: n이 0이 될때 종료한다
 * - 함수 실행마다 StringBuilder에 n의 크기만큼 별을 넣어준다
 * - 재귀함수는 n-1로 호출해서 0에 도달할 수 있게 해주고, 문제에서 요구하는 줄어드는 별 모양을 만든다
 * - 이번에는 위 재귀함수에 한가지 조건을 추가하기 위해 count라는 파라미터를 하나 더해줬다.
 *  - 이번에는 별의 개수가 2개씩 늘어나기때문에 재귀함수에 n+2 인수와 빈칸이 1칸씩 줄어드니까 count-1을 인수로 넘겨주었다.
 *  - 초기값은 각각 1과 n-1이다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star(int n, int count){
        if(count < 0){
            return;
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        sb.append("\n");
        star(n+2, count-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star(1,n-1);

        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

