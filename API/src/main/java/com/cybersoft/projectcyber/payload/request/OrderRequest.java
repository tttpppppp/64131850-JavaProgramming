package com.cybersoft.projectcyber.payload.request;

public class OrderRequest {
    private int userrId;
    private int restaurantId;
    private int[] foodId;

    public int getUserrId() {
        return userrId;
    }

    public void setUserrId(int userrId) {
        this.userrId = userrId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int[] getFoodId() {
        return foodId;
    }

    public void setFoodId(int[] foodId) {
        this.foodId = foodId;
    }
}
