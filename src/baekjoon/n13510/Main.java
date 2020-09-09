package baekjoon.n13510;
// 어디가 틀렸는지 모르겠다!
import java.util.Scanner;

class Edge {
    private int weight;

    Edge(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        int N = Integer.parseInt(s.nextLine());
        if (N < 2 || N > 100000) {
            s.close();
            return;
        }

        String[] temp;
        Edge[] e = new Edge[N];
        for (int i = 1; i < N; i++) {
            e[i] = new Edge(0);
            temp = s.nextLine().split(" ");
            init(e, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }

        int M = Integer.parseInt(s.nextLine());
        if (M < 1 || M > 100000) {
            s.close();
            return;
        }
        int[] _2answer = new int[M];

        for (int i = 0; i < M; i++) {
            temp = s.nextLine().split(" ");
            query(e, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), _2answer);
        }

        for (int i = 0; i < M; i++) {
            if (_2answer[i] != 0) {
                System.out.println(_2answer[i]);
            }
        }

        s.close();
    }
    static void init(Edge[] e, int u, int v, int w) {
        if (w < 0 || w > 1000000) {
            s.close();
            System.exit(0);
        } else {
            e[u].setWeight(w);
        }
    }

    static void query(Edge[] e, int q, int u, int v, int[] ans) {
        int totalWeight = 0;
        if (q == 1) {
            if (u < 0 || u > 1000000) {
                s.close();
                System.exit(0);
            } else {
                e[u].setWeight(v);
            }
        } else if (q == 2) {
            for (int i = u; i < v; i++) {
                totalWeight += e[i].getWeight();
            }
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == 0) {
                    ans[i] = totalWeight;
                    break;
                }
            }
        }
    }
}
