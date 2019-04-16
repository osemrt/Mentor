package model;

//for doctor list activity

public class RecyclerViewItem {

    private int imageId;
    private String doctorName;
    private String specialist;
    private float cost;

    public RecyclerViewItem(int imageId, String doctorName, String specialist, float cost) {
        this.imageId = imageId;
        this.doctorName = doctorName;
        this.specialist = specialist;
        this.cost = cost;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialist() {
        return specialist;
    }

    public float getCost() {
        return cost;
    }
}
