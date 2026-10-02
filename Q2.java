public class Q2 {

    private boolean[] results;
    private int count;

    Q2(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        } else {
            System.out.println("Cannot record more answers");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        System.out.println("Pritham M");

        Q2 sc = new Q2(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}