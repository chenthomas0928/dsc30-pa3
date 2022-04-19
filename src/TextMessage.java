public class TextMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    public TextMessage(User sender, String text)
            throws OperationDeniedException {
        super(sender);
        if (sender == null || text == null) {
            throw new IllegalArgumentException();
        }
        if (text.length() > 500) {
            throw new OperationDeniedException(EXCEED_MAX_LENGTH);
        }
        this.contents = text;
    }

    public String getContents() {
        String result = "";
        result = this.getSender().displayName() + " " + this.getDate().toString() + ": " + this.contents;

        return result;
    }

}
