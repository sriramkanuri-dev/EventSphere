import java.util.*;
import java.text.*;

public class EventDateQuery {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        TreeMap<Date, String> events = new TreeMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter number of events: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter event date (dd/MM/yyyy): ");
            String dateInput = sc.nextLine();

            Date date = sdf.parse(dateInput);

            System.out.print("Enter event name: ");
            String name = sc.nextLine();

            events.put(date, name);
        }

        System.out.print("Enter start date (dd/MM/yyyy): ");
        Date start = sdf.parse(sc.nextLine());

        System.out.print("Enter end date (dd/MM/yyyy): ");
        Date end = sdf.parse(sc.nextLine());

        System.out.println("\nEvents in selected range:");

        for (Map.Entry<Date, String> e :
                events.subMap(start, true, end, true).entrySet()) {

            System.out.println(
                    sdf.format(e.getKey()) + " - " + e.getValue()
            );
        }
    }
}