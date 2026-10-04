public class GradeReport extends Report {
    private final int[] grades;

    public GradeReport(String id, Formatter formatter, int[] grades) {
        super(id, formatter);
        this.grades = grades.clone();
    }

    @Override
    protected String getTitle() {
        return "Grade Report";
    }

    @Override
    protected String createContent() {
        int sum = 0;
        StringBuilder values = new StringBuilder();

        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];

            if (i > 0) {
                values.append(", ");
            }

            values.append(grades[i]);
        }

        int average = sum / grades.length;
        return "average of " + values + " = " + average;
    }

    public int[] getGrades() {
        return grades.clone();
    }
}