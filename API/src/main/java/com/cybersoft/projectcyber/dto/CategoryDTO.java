package com.cybersoft.projectcyber.dto;

import java.util.List;

public class CategoryDTO {
    private String categoryName;
    private List<MenuDTO> menuList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }
}
