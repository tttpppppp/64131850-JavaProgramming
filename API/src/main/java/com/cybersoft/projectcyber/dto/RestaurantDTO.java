package com.cybersoft.projectcyber.dto;

import java.util.List;

public class RestaurantDTO {
    private String image;
    private String restaurantTitle;
    private String restaurantDes;
    private String restaurantSubTitle;
    private int isFreeShip;
    private double  rating;
    private List<CategoryDTO> listcategories;

    public double getRating() {
        return rating;
    }

    public List<CategoryDTO> getListcategories() {
        return listcategories;
    }

    public void setListcategories(List<CategoryDTO> listcategories) {
        this.listcategories = listcategories;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public String getRestaurantDes() {
        return restaurantDes;
    }

    public void setRestaurantDes(String restaurantDes) {
        this.restaurantDes = restaurantDes;
    }

    public String getRestaurantSubTitle() {
        return restaurantSubTitle;
    }

    public void setRestaurantSubTitle(String restaurantSubTitle) {
        this.restaurantSubTitle = restaurantSubTitle;
    }

    public int getIsFreeShip() {
        return isFreeShip;
    }

    public void setIsFreeShip(int isFreeShip) {
        this.isFreeShip = isFreeShip;
    }
}
