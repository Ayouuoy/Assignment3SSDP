public class AttendanceReport extends Report {
    private final int attendedSessions;
    private final int totalSessions;

    public AttendanceReport(String id, Formatter formatter, int attendedSessions, int totalSessions) {
        super(id, formatter);
        this.attendedSessions = attendedSessions;
        this.totalSessions = totalSessions;
    }

    @Override
    protected String getTitle() {
        return "Attendance Report";
    }

    @Override
    protected String createContent() {
        int percentage = attendedSessions * 100 / totalSessions;
        return attendedSessions + "/" + totalSessions + " sessions attended (" + percentage + "%)";
    }

    public int getAttendedSessions() {
        return attendedSessions;
    }

    public int getTotalSessions() {
        return totalSessions;
    }
}