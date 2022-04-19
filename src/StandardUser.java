import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

    /* Message to append when fetching non-text message */
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";

    public StandardUser(String username, String bio) {
        super(username,bio);
    }

    public String fetchMessage(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        
        return null;
    }

    public String displayName() {

        return this.username;  // placeholder for checkpoint test.
                               // replace it with your own after checkpoint submission.
    }
}
