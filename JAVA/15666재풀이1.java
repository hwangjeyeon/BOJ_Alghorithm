import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식: backtracking(n,m,depth, start)
 * 2. base condition: m == depth
 * 3. 재귀식: backtracking(n,m,depth+1, i)
 *
 * - 이전 문제에 start 파라미터를 추가하면 된다. 인수로는 자기자신을 포함해야 하므로 i+1이 아닌 i를 넘긴다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] input;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[m];
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backtracking(n,m,0, 0);


        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void backtracking(int n , int m , int depth, int start){
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = start; i < n; i++) {
            if(before != input[i]){
                before = input[i];
                arr[depth] = input[i];
                backtracking(n,m,depth+1, i);
            }
        }


    }
}

