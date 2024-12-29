import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

class X {
    private Scanner scanner;

    public X() {
        scanner = new Scanner(System.in);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public int inputInt(String prompt) {
        print(prompt);
        while (!scanner.hasNextInt()) {
            println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String inputString(String prompt) {
        print(prompt);
        return scanner.next();
    }

    public Date inputDate(String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        while (true) {
            print(prompt);
            String input = scanner.next();
            try {
                return dateFormat.parse(input);
            } catch (Exception e) {
                println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
            }
        }
    }

    public double inputDouble(String prompt) {
        print(prompt);
        while (!scanner.hasNextDouble()) {
            println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
