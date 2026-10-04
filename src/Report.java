public abstract class Report {
    private final String id;
    private Formatter formatter;

    protected Report(String id, Formatter formatter) {
        this.id = id;
        this.formatter = formatter;
    }

    public final String execute() {
        return formatter.format(getTitle(), createContent());
    }

    public final void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public final String getId() {
        return id;
    }

    protected abstract String getTitle();

    protected abstract String createContent();
}