import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of venues: ");
        int n = sc.nextInt();

        int[][] g = new int[n][n];

        System.out.println("Enter distance matrix:");

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = sc.nextInt();

        int[] dist = new int[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int c = 0; c < n - 1; c++) {
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!vis[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;
            }

            vis[u] = true;

            for (int v = 0; v < n; v++) {
                if (g[u][v] != 0 &&
                        dist[u] + g[u][v] < dist[v]) {

                    dist[v] = dist[u] + g[u][v];
                }
            }
        }

        System.out.println("Shortest Distances:");
        System.out.println(Arrays.toString(dist));
    }
}