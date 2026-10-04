public class Main {
    private static int passedChecks = 0;
    private static int totalChecks = 0;

    public static void main(String[] args) {
        if (args.length == 1 && "--demo".equals(args[0])) {
            runDemo();
            return;
        }

        System.out.println("Run with: java -cp out Main --demo");
    }

    private static void runDemo() {
        Formatter textFormatter = new TextFormatter();
        Formatter htmlFormatter = new HtmlFormatter();

        AttendanceReport attendanceText =
                new AttendanceReport("A-101", textFormatter, 3, 4);

        check(
                "T1",
                "AttendanceReport + TextFormatter",
                attendanceText.execute(),
                "Attendance Report: 3/4 sessions attended (75%)"
        );

        AttendanceReport attendanceHtml =
                new AttendanceReport("A-102", htmlFormatter, 3, 4);

        check(
                "T2",
                "AttendanceReport + HtmlFormatter",
                attendanceHtml.execute(),
                "<h1>Attendance Report</h1><p>3/4 sessions attended (75%)</p>"
        );

        GradeReport gradeText =
                new GradeReport("G-101", textFormatter, new int[]{70, 80, 90});

        check(
                "T3",
                "GradeReport + TextFormatter",
                gradeText.execute(),
                "Grade Report: average of 70, 80, 90 = 80"
        );

        GradeReport gradeHtml =
                new GradeReport("G-102", htmlFormatter, new int[]{70, 80, 90});

        check(
                "T4",
                "GradeReport + HtmlFormatter",
                gradeHtml.execute(),
                "<h1>Grade Report</h1><p>average of 70, 80, 90 = 80</p>"
        );

        checkRuntimeSwitch(textFormatter, htmlFormatter);

        System.out.println(
                "SUMMARY: " + passedChecks + "/" + totalChecks + " PASS"
        );
    }

    private static void checkRuntimeSwitch(
            Formatter textFormatter,
            Formatter htmlFormatter
    ) {
        AttendanceReport report =
                new AttendanceReport("A-200", textFormatter, 3, 4);

        AttendanceReport originalReference = report;

        String originalId = report.getId();
        int originalAttended = report.getAttendedSessions();
        int originalTotal = report.getTotalSessions();

        String expectedBefore =
                "Attendance Report: 3/4 sessions attended (75%)";

        String expectedAfter =
                "<h1>Attendance Report</h1><p>3/4 sessions attended (75%)</p>";

        String before = report.execute();

        report.setImplementation(htmlFormatter);

        String after = report.execute();

        boolean sameObject = originalReference == report;

        boolean stateUnchanged =
                originalId.equals(report.getId())
                        && originalAttended == report.getAttendedSessions()
                        && originalTotal == report.getTotalSessions();

        boolean resultsCorrect =
                before.equals(expectedBefore)
                        && after.equals(expectedAfter);

        boolean passed =
                sameObject && stateUnchanged && resultsCorrect;

        totalChecks++;

        if (passed) {
            passedChecks++;
        }

        System.out.println(
                "T5 " + status(passed)
                        + " | AttendanceReport + TextFormatter -> HtmlFormatter"
                        + " | sameObject=" + sameObject
                        + " | stateUnchanged=" + stateUnchanged
        );

        System.out.println("  before=" + before);
        System.out.println("  after=" + after);

        if (!passed) {
            System.out.println("  expectedBefore=" + expectedBefore);
            System.out.println("  expectedAfter=" + expectedAfter);
            System.out.println("  expectedSameObject=true");
            System.out.println("  expectedStateUnchanged=true");
        }
    }

    private static void check(
            String id,
            String classes,
            String actual,
            String expected
    ) {
        boolean passed = actual.equals(expected);

        totalChecks++;

        if (passed) {
            passedChecks++;
        }

        System.out.println(
                id + " " + status(passed)
                        + " | " + classes
                        + " | result=" + actual
        );

        if (!passed) {
            System.out.println("  expected=" + expected);
        }
    }

    private static String status(boolean passed) {
        return passed ? "PASS" : "FAIL";
    }
}