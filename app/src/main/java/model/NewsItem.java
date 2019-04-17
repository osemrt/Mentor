package model;

public class NewsItem {

    private int imageId;
    private String header;
    private String subTitle;

    public NewsItem(int imageId, String header, String subTitle) {
        this.imageId = imageId;
        this.header = header;
        this.subTitle = subTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public String getHeader() {
        return header;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
