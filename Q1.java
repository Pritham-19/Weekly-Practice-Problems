public class Q1 {
    private double savings;
    private final String id;

    Q1(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    double getSavings() {
        return savings;
    }

    public static void main(String[] args) {

        System.out.println("Pritham M");

        Q1 pb = new Q1("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}