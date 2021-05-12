import java.util.*;
import java.io.*;

public class Main{
    
  static ArrayList<Integer>[] list;
  static boolean[] visited;
  static int N,M;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    list = new ArrayList[N+1];

    for(int i = 1; i<=N; i++){
      list[i] = new ArrayList<Integer>();
    }
    for(int i = 1; i <= M; i++){
      String [] tmp = br.readLine().split(" ");
      int x = Integer.parseInt(tmp[0]);
      int y = Integer.parseInt(tmp[1]);
      list[x].add(y);
      list[y].add(x);
    }
    // DFS로 판별한다.
    // 연결 간선이 있다면 +1
    visited = new boolean[N+1];
    for(int i = 1; i<=N; i++){
      DFS(i,"f");
    }
    bw.write(answer + "\n");
    bw.flush();
    bw.close();
  }
  static void DFS(int v, String state){
    if(visited[v]) return;
    visited[v] = true;
    if("f".equals(state)){
      answer++;
    }
    for(int x : list[v]){
      if(!visited[x]){
        DFS(x,"c");
      }
    }
  }
}
