package com.richardorlandini.curse.repositoryes;

import com.richardorlandini.curse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
