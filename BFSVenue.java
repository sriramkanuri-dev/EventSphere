import java.util.*;

public class BFSVenue {
    public static void main(String[] args) {

<<<<<<< HEAD
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter number of venues: ");
            int v = sc.nextInt();
=======
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of venues: ");
        int v = sc.nextInt();
>>>>>>> 9bb4cdda35e1ea215884e46fee2aed6f4e95045f

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            g.add(new ArrayList<>());
        }

        System.out.print("Enter number of connections: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {

<<<<<<< HEAD
            System.out.print("Enter connection " + (i + 1) + " (example 0 1): ");
=======
            System.out.print("Enter connected venues (example 0 1): ");
>>>>>>> 9bb4cdda35e1ea215884e46fee2aed6f4e95045f

            int a = sc.nextInt();
            int b = sc.nextInt();

<<<<<<< HEAD
            if (a >= 0 && a < v && b >= 0 && b < v) {
                g.get(a).add(b);
                g.get(b).add(a);
            } else {
                System.out.println("Invalid venue number. Try again.");
                i--;
            }
=======
            g.get(a).add(b);
            g.get(b).add(a);
>>>>>>> 9bb4cdda35e1ea215884e46fee2aed6f4e95045f
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
<<<<<<< HEAD
}
=======
>>>>>>> 9bb4cdda35e1ea215884e46fee2aed6f4e95045f
}