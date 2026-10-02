import java.time.LocalDate;
import java.util.*;

public class Q2 {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getLoanPeriod();
        abstract String getType();

        LocalDate getDueDate() {
            LocalDate currentDate =
                    LocalDate.of(2023, 10, 26);

            return currentDate.plusDays(getLoanPeriod());
        }
    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 14;
        }

        String getType() {
            return "BOOK";
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 7;
        }

        String getType() {
            return "DVD";
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        int getLoanPeriod() {
            return 3;
        }

        String getType() {
            return "MAGAZINE";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } 
            else if (type.equals("DVD")) {
                item = new DVD(title);
            } 
            else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}