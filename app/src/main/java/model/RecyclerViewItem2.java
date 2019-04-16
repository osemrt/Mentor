package model;

// for review activity

public class RecyclerViewItem2 {


    private String name;
    private String review;
    private String date;

    public RecyclerViewItem2(String name, String review, String date) {
        this.name = name;
        this.review = review;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getDate() {
        return date;
    }
}
