import java.util.*;
import java.text.*;

public class EventDateQuery {

    public static void main(String[] args)
            throws Exception {

        Scanner sc = new Scanner(System.in);

        TreeMap<Date,String> events =
                new TreeMap<>();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Events: ");
        int n =
                Integer.parseInt(
                        sc.nextLine());

        for(int i=0;i<n;i++){

            System.out.print("Date: ");
            Date d =
                    sdf.parse(
                            sc.nextLine());

            System.out.print("Event Name: ");
            String name =
                    sc.nextLine();

            events.put(d,name);
        }

        System.out.print("Start date: ");
        Date s =
                sdf.parse(sc.nextLine());

        System.out.print("End date: ");
        Date e =
                sdf.parse(sc.nextLine());

        for(var x :
                events.subMap(
                        s,true,e,true
                ).entrySet()){

            System.out.println(
                    sdf.format(x.getKey())
                            +" - "+
                            x.getValue()
            );
        }
    }
}