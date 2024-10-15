package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.dto.CategoryDTO;
import com.cybersoft.projectcyber.dto.MenuDTO;
import com.cybersoft.projectcyber.entity.Categories;
import com.cybersoft.projectcyber.entity.Food;
import com.cybersoft.projectcyber.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Categories getCategoryById(int id) {
        return categoryRepository.findByCategoryId(id);
    }
    public List<CategoryDTO> getAllCategories() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<Categories> list = categoryRepository.findAll(pageRequest);

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for(Categories category : list) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryName(category.getCategoryName());
            List<MenuDTO> listmenudto = new ArrayList<>();
            for(Food food : category.getFoods()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(food.getFoodName());
                menuDTO.setIsFreeShip(food.getIsFreeShip());
                listmenudto.add(menuDTO);
            }
            categoryDTO.setMenuList(listmenudto);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
