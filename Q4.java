import java.util.*;

public class Q4 {

    static abstract class Question {

        String questionText;
        String correctAnswer;
        String studentAnswer;
        double points;

        Question(String questionText,
                 String correctAnswer,
                 String studentAnswer,
                 double points) {

            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double calculateScore();
        abstract String getType();
    }

    static class MCQ extends Question {

        MCQ(String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

            super(questionText,
                  correctAnswer,
                  studentAnswer,
                  points);
        }

        double calculateScore() {

            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }

        String getType() {
            return "MCQ";
        }
    }

    static class TF extends Question {

        TF(String questionText,
           String correctAnswer,
           String studentAnswer,
           double points) {

            super(questionText,
                  correctAnswer,
                  studentAnswer,
                  points);
        }

        double calculateScore() {

            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }

        String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {

        Essay(String questionText,
              String correctAnswer,
              String studentAnswer,
              double points) {

            super(questionText,
                  correctAnswer,
                  studentAnswer,
                  points);
        }

        double calculateScore() {

            String student =
                    studentAnswer.toLowerCase();

            String[] keywords =
                    correctAnswer.split(",");

            int count = 0;

            for (String keyword : keywords) {

                keyword = keyword.trim().toLowerCase();

                if (student.contains(keyword)) {
                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            }
            else if (count == 1) {
                return points * 0.50;
            }
            else {
                return 0;
            }
        }

        String getType() {
            return "ESSAY";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            /*
             * Input contains quoted strings.
             * This regular expression separates
             * quoted and non-quoted values.
             */

            String[] parts =
                    line.split("\"");

            String type =
                    parts[0].trim().split("\\s+")[0];

            String questionText =
                    parts[1];

            String correctAnswer =
                    parts[3];

            String studentAnswer =
                    parts[5];

            String remaining =
                    parts[6].trim();

            double points =
                    Double.parseDouble(remaining);

            Question question;

            if (type.equals("MCQ")) {

                question =
                        new MCQ(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points
                        );

            }
            else if (type.equals("TF")) {

                question =
                        new TF(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points
                        );

            }
            else {

                question =
                        new Essay(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points
                        );
            }

            double score =
                    question.calculateScore();

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score
            );

            totalScore += score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}