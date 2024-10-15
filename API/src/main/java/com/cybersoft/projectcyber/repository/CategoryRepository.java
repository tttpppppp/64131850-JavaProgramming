package com.cybersoft.projectcyber.repository;

import com.cybersoft.projectcyber.entity.Categories;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    Categories findByCategoryId(int id);
}