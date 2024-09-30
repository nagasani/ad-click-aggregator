package com.example.adclick.model;

public class AdClickEvent {

    private String adId;
    private String userId;
    private long timestamp;

    public AdClickEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public AdClickEvent(String adId, String userId) {
        this.adId = adId;
        this.userId = userId;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and Setters

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // No setter for timestamp to prevent external modification
}
