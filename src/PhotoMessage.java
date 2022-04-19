public class PhotoMessage extends Message {

    /* Error message to use in OperationDeniedException */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /* instance variable */
    private String extension;

    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        super(sender);
        if (sender == null || photoSource == null) {
            throw new IllegalArgumentException();
        }
        if (sender instanceof StandardUser) {
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        String[] valid = new String[]{"jpg", "jpeg", "gif", "png", "tif", "tiff", "raw"};
        boolean check = false;
        for (int i = 0; i < valid.length; i++) {
            if (photoSource.split(".")[-1].toLowerCase() == valid[i]) {
                this.extension = "." + valid[i];
                check = true;
            }
        }
        if (check == false) {
            throw new OperationDeniedException(INVALID_INPUT);
        }
        this.contents = photoSource;
    }

    public String getContents() {
        String result = "";
        result = this.getSender().displayName() + " " + this.getDate().toString() + ": Picture at " + this.contents;
        return null;
    }

    public String getExtension() {

        return this.extension;
    }

}
