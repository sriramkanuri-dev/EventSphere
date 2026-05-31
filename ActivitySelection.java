import java.util.*;

public class ActivitySelection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sessions: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] start = new String[n];
        String[] finish = new String[n];
        int[] finishValue = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nSession " + (i + 1));

            System.out.print("Start time (example 10AM): ");
            start[i] = sc.nextLine().trim().toUpperCase();

            System.out.print("End time (example 2PM): ");
            finish[i] = sc.nextLine().trim().toUpperCase();

            finishValue[i] = convertTime(finish[i]);
        }

        System.out.println("\nSelected Sessions:");

        int i = 0;

        System.out.println(
            "Session 1 (" + start[0] + " - " + finish[0] + ")"
        );

        for (int j = 1; j < n; j++) {

            if (convertTime(start[j]) >= finishValue[i]) {

                System.out.println(
                    "Session " + (j + 1) +
                    " (" + start[j] + " - " + finish[j] + ")"
                );

                i = j;
            }
        }
    }

    static int convertTime(String t) {

        int hour =
            Integer.parseInt(
                t.substring(0, t.length() - 2)
            );

        String period =
            t.substring(t.length() - 2);

        if (period.equals("PM") && hour != 12)
            hour += 12;

        if (period.equals("AM") && hour == 12)
            hour = 0;

        return hour;
    }
}