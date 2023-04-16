package com.richardorlandini.curse.repositoryes;

import com.richardorlandini.curse.entities.Category;
import com.richardorlandini.curse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
