package com.cybersoft.projectcyber.controller;

import com.cybersoft.projectcyber.payload.ReponseData;
import com.cybersoft.projectcyber.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        ReponseData reponseData = new ReponseData();
        if(categoryService.getCategoryById(id) != null) {
            reponseData.setMessage("success");
            reponseData.setData(categoryService.getCategoryById(id));
            return new ResponseEntity<>(reponseData, HttpStatus.OK);
        }
        reponseData.setMessage("None data");
        return new ResponseEntity<>(reponseData , HttpStatus.OK);
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory() {
        ReponseData reponseData = new ReponseData();
        if(!categoryService.getAllCategories().isEmpty()) {
            reponseData.setMessage("success");
            reponseData.setData(categoryService.getAllCategories());
            return new ResponseEntity<>(reponseData, HttpStatus.OK);
        }
        reponseData.setMessage("None data");
        return new ResponseEntity<>(reponseData , HttpStatus.OK);
    }
}
