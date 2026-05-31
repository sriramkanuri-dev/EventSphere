import java.util.*;

public class BFSVenue {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Venues: ");
        int v = sc.nextInt();

        ArrayList<ArrayList<Integer>>
                g = new ArrayList<>();

        for(int i=0;i<v;i++)
            g.add(new ArrayList<>());

        System.out.print("Connections: ");
        int e = sc.nextInt();

        for(int i=0;i<e;i++){

            System.out.print("Connect: ");

            int a = sc.nextInt();
            int b = sc.nextInt();

            g.get(a).add(b);
            g.get(b).add(a);
        }

        System.out.print("Start venue: ");
        int s = sc.nextInt();

        Queue<Integer> q =
                new LinkedList<>();

        boolean[] vis =
                new boolean[v];

        q.add(s);
        vis[s]=true;

        while(!q.isEmpty()){

            int n=q.poll();

            System.out.println(
                    "Venue "+n
            );

            for(int x:g.get(n)){

                if(!vis[x]){

                    vis[x]=true;
                    q.add(x);
                }
            }
        }
    }
}