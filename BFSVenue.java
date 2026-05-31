import java.util.*;

public class BFSVenue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of venues: ");
        int v = sc.nextInt();

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            g.add(new ArrayList<>());
        }

        System.out.print("Enter number of connections: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {

            System.out.print("Enter connected venues (example 0 1): ");

            int a = sc.nextInt();
            int b = sc.nextInt();

            g.get(a).add(b);
            g.get(b).add(a);
        }

        System.out.print("Enter starting venue: ");
        int start = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        q.add(start);
        vis[start] = true;

        System.out.println("\nAccessible Venues:");

        while (!q.isEmpty()) {
            int n = q.poll();

            System.out.println("Venue " + n);

            for (int x : g.get(n)) {
                if (!vis[x]) {
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
    }
}