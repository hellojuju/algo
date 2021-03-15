/**
[BOJ] 13023번 ABCDE (DFS)
 - 다른 경로에서의 방문을 위한 false 처리
 - DFS
 - 관계를 어떻게 ArrayList 에 담을지?
*/

import java.util.*;
import java.io.*;

public class Main{
    
  static int N;
  static int M;
  static int ans = 0;
  static ArrayList<Integer>[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    map = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      map[i] = new ArrayList<>();
    }
    // 관계 저장
    for (int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      map[a].add(b);
      map[b].add(a);
    }
      
    // 0번 친구부터 확인한다
    for (int i = 0; i < N; i++) {
      if (ans == 1) {
        break;
      }
      dfs(new boolean[N], i, 0);
    }
    bw.write(ans+"\n");
    bw.flush();
  }

  public static void dfs(boolean[] visited, int num, int cnt) {
    if (ans == 1) return;
    if (cnt >= 5) {
      ans = 1;
      return;
    }
    for (int i = 0; i < map[num].size(); i++) {
      int x = map[num].get(i);
      if (!visited[x]) {
        visited[x] = true;
        dfs(visited, x, cnt + 1);
        visited[x] = false;  // 다른경로에서 사용할수있으니 false 처리
      }
    }
  }
}
