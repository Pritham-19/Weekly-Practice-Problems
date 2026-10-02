public class Q5 {

    private String[] students;
    private int count;

    Q5(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    void markPresent(String name) {

        if (isPresent(name)) {
            return;
        }

        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Pritham M");

        Q5 sheet = new Q5(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}