public class Q3 {

    private final String firstName;
    private final String lastName;

    Q3(String fullName) {

        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {

        System.out.println("Pritham M");

        Q3 tag = new Q3("Maria Gomez");

        System.out.println("Nickname: " + tag.getNickname());
    }
}
