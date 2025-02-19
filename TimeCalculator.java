package TimeCalculator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        double totalHours = 0;

        while (true) {
            System.out.print("Enter start time (hh:mm AM/PM) or 'exit' to finish: ");
            String startInput = scanner.nextLine();
            if (startInput.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter end time (hh:mm AM/PM): ");
            String endInput = scanner.nextLine();

            try {
                LocalTime startTime = LocalTime.parse(startInput, formatter);
                LocalTime endTime = LocalTime.parse(endInput, formatter);

                long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime);
                double hours = minutesBetween / 60.0;
                totalHours += hours;

                System.out.printf("Time difference: %.2f hrs\n", hours);
                System.out.printf("Total accumulated time: %.2f hrs\n", totalHours);
            } catch (Exception e) {
                System.out.println("Invalid input format. Please enter time as hh:mm AM/PM.");
            }
        }
        // new feature practice for git learning [creating conflict to commit]
        // new feature practice for git learning (code)[Learning about conflicts]
        System.out.printf("Final total time: %.2f hrs\n", totalHours);
        scanner.close();
    }
}
