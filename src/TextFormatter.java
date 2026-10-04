public class TextFormatter implements Formatter {
    @Override
    public String format(String reportTitle, String reportContent) {
        return reportTitle + ": " + reportContent;
    }
}