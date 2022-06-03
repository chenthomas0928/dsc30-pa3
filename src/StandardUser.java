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
        if (this.rooms.contains(me) == false) {
            throw new IllegalArgumentException();
        }
        String result = "";
        for (int i = 0; i < me.getLog(this).size(); i++) {
            if (me.getLog(this).get(i) instanceof TextMessage) {
                result += me.getLog(this).get(i) + "\n";

            }
            else {
                result += FETCH_DENIED_MSG + "\n";
            }
        }
        return result;
    }

    public String displayName() {

        return this.username;  // placeholder for checkpoint test.
                               // replace it with your own after checkpoint submission.
    }
}
