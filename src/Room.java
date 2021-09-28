public class Room {
    private String roomId;
    private String roomType;

    public Room(String roomId, String roomType){
        this.setId(roomId);
        this.setType(roomType);

    }

    public String getId() {
        return roomId;
    }

    public void setId(String roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return roomType;
    }

    public void setType(String roomType) {
        this.roomType = roomType;
    }
}
