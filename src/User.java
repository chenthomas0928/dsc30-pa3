import java.util.ArrayList;

public abstract class User {

    /* Error message to use in OperationDeniedException */
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";
    protected static final String INVALID_MSG_TYPE =
            "Cannot send this type of message to the specified room.";

    /* instance variables */
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;

    public User(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.username = username;
            this.bio = bio;
        }
    }

    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.bio = newBio;
        }
    }

    public String displayBio() {

        return this.bio;
    }

    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        if (this.rooms.contains(me)) {
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        }
        else {
            me.addUser(this);
        }
    }

    public void quitRoom(MessageExchange me) {
        if (me == null) {
            throw new IllegalArgumentException();
        }
        else {
            me.removeUser(this,this);
        }
    }

    public MessageExchange createChatRoom(ArrayList<User> users) {
        ChatRoom room = new ChatRoom();
        if (users == null) {
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < users.size(); i++) {
                try {
                    room.addUser(users.get(i));
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return room;
    }

    public void sendMessage(MessageExchange me, MessageType msgType, String contents) {
        if (me == null || msgType == null || contents == null) {
            throw new IllegalArgumentException();
        }
        if (msgType != MessageType.PHOTO || msgType != MessageType.TEXT) {
            throw new IllegalArgumentException();
        }
        if (this.rooms.contains(me) == false) {
            throw new IllegalArgumentException();
        }
        if (msgType == MessageType.TEXT) {
            try {
                TextMessage text = new TextMessage(this, contents);
                me.recordMessage(text);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (msgType == MessageType.PHOTO) {
            try {
                PhotoMessage text = new PhotoMessage(this, contents);
                me.recordMessage(text);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public abstract String fetchMessage(MessageExchange me);

    public abstract String displayName();
}
