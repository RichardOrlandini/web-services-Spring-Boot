package com.richardorlandini.curse.repositories;

import com.richardorlandini.curse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Long> {

}
