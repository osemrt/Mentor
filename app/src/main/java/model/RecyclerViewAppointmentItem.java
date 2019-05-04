package model;

//for doctor list activity

public class RecyclerViewAppointmentItem {

    private int imageId;
    private String name;
    private String date;
    private String time;

    public RecyclerViewAppointmentItem(int imageId, String name, String date, String time) {
        this.imageId = imageId;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
