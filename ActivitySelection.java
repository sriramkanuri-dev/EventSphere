import java.util.*;

public class ActivitySelection {

    public static void main(
            String[] args){

        Scanner sc =
                new Scanner(System.in);

        System.out.print(
                "Sessions: "
        );

        int n=
                Integer.parseInt(
                        sc.nextLine());

        String[] start=
                new String[n];

        String[] finish=
                new String[n];

        int[] f=
                new int[n];

        for(int i=0;i<n;i++){

            System.out.println(
                    "\nSession "+(i+1)
            );

            System.out.print(
                    "Start time: "
            );

            start[i]=
                    sc.nextLine()
                            .trim()
                            .toUpperCase();

            System.out.print(
                    "End time: "
            );

            finish[i]=
                    sc.nextLine()
                            .trim()
                            .toUpperCase();

            f[i]=convert(
                    finish[i]);
        }

        int i=0;

        System.out.println(
                "Session 1 ("
                        +start[0]
                        +" - "
                        +finish[0]
                        +")"
        );

        for(int j=1;j<n;j++){

            if(convert(start[j])
                    >=f[i]){

                System.out.println(
                        "Session "
                                +(j+1)
                                +" ("
                                +start[j]
                                +" - "
                                +finish[j]
                                +")"
                );

                i=j;
            }
        }

        sc.close();
    }

    static int convert(
            String t){

        int h=
                Integer.parseInt(
                        t.substring(
                                0,
                                t.length()-2
                        ));

        String p=
                t.substring(
                        t.length()-2);

        if(p.equals("PM")
                && h!=12)

            h+=12;

        if(p.equals("AM")
                && h==12)

            h=0;

        return h;
    }
}