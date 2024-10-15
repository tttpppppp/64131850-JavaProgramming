package com.cybersoft.projectcyber.payload.request;

import org.springframework.web.multipart.MultipartFile;


public class RestaurantRequest {
    MultipartFile file;
    private String restaurantTitle;
    private String restaurantDesc;
    private int isFreeShip;
    private String address;
    private String openDate;
    private String restaurantSubTitle;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public String getRestaurantDesc() {
        return restaurantDesc;
    }

    public void setRestaurantDesc(String restaurantDesc) {
        this.restaurantDesc = restaurantDesc;
    }

    public int getIsFreeShip() {
        return isFreeShip;
    }

    public void setIsFreeShip(int isFreeShip) {
        this.isFreeShip = isFreeShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getRestaurantSubTitle() {
        return restaurantSubTitle;
    }

    public void setRestaurantSubTitle(String restaurantSubTitle) {
        this.restaurantSubTitle = restaurantSubTitle;
    }
}
