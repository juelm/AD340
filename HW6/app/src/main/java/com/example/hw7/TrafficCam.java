package com.example.hw6;

public class TrafficCam {
    private String id;
    private String description;
    private String imageURL;
    private String type;

    public TrafficCam(String id, String description, String imageURL, String type) {
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
