public class MarkdownFormatter implements Formatter {
    @Override
    public String format(String reportTitle, String reportContent) {
        return "# " + reportTitle + "\n\n" + reportContent;
    }
}