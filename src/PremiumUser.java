import java.util.ArrayList;

public class PremiumUser extends User {

    /* instance variable */
    private String customTitle;

    public PremiumUser(String username, String bio) {
        super(username, bio);
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
            result += me.getLog(this).get(i) + "\n";
        }
        return result;
    }

    public String displayName() {

        return "<" + this.customTitle + "> " + this.username;  // placeholder for checkpoint test.
                                    // replace it with your own after checkpoint submission.
    }

    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;
    }

    public MessageExchange createModeratedRoom(ArrayList<User> users) {
        /* TODO */
        return null;
    }

    public boolean banUser(ModeratedRoom room, User u) {
        /* TODO */
        return false;
    }

    public boolean unbanUser(ModeratedRoom room, User u) {
        /* TODO */
        return false;
    }

    public boolean setNumVisibleLog(ModeratedRoom room, int newNum) {
        /* TODO */
        return false;
    }

}
