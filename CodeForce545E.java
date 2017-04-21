import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by kjm81 on 2017-04-20.
 */
public class CodeForce545E {
    static long min[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Edge> q = new PriorityQueue<>();  // 우선 순위 큐
        int n, m, a, b, c, end;
        n = sc.nextInt();
        m = sc.nextInt();
        List<Edge>[] g = new List[n + 1];   // Edge Class의 List를 생성
        for (int i = 0 ; i < n + 1; i++) {
            g[i] = new ArrayList<Edge>();    //각 List에 ArrayList를 만듬
        }


        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            g[a].add(new Edge(i + 1, b, c, c));
            g[b].add(new Edge(i + 1, a, c, c));
            // 그래프의 node에 Edge(index값 설정, 연결된 노드, weight, edge)
        }
        end = sc.nextInt();
        long[] min = new long[n + 1];      // 최소값 설정
        int countNode = 0;                  // 노드 카운터
        boolean[] visited = new boolean[n + 1];// 방문 확인

        for (Edge e : g[end]) { // 엣지 배열 e, end 번째 노드
            q.add(e);           // 우선순위 큐에 push 함
        }

        q.add(new Edge(0, end, 0, 0));
        Integer[] eg = new Integer[n];
        long sum = 0;

        while (countNode < n) {
            Edge e = q.poll();
            while (visited[e.node]) {
                e = q.poll();
            }
            sum += e.edge;
            visited[e.node] = true;
            eg[countNode] = e.index;
            countNode++;
            for(Edge eo : g[e.node]) {
                if(!visited[eo.node]) {
                    q.add(new Edge(eo.index, eo.node,
                            eo.edge + e.weight, eo.edge));
                }
            }
        }
        StringBuffer str = new StringBuffer();
        str.append(sum);

        if (n == 1) {
            System.out.println(0);
            return;
        }
        str.append('\n');
        for (int i = 1; i < n; i++) {
            if (i > 1) {
                str.append(' ');
            }
            str.append(eg[i]);
        }
        System.out.println(str);
    }
}
class Edge implements Comparable<Edge>{
    int index;
    int node;
    long weight;
    long edge;

    public Edge(int index, int node, long weight, long edge) {
        this.index = index;
        this.node = node;
        this.weight = weight;
        this.edge = edge;
    }

    @Override
    public int compareTo(Edge e) {
        if (e.weight != this.weight) {
            return Long.compare(this.weight, e.weight);
        }
        return Long.compare(this.edge, e.edge);
    }
};