package com.example.hw7;

public class TrafficCam {
    private String id;
    private String description;
    private String imageURL;
    private String type;
    private String latitude;
    private String longitude;

    public TrafficCam(String id, String description, String imageURL, String type, String lat, String lon) {
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.type = type;
        this.latitude = lat;
        this.longitude = lon;

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
