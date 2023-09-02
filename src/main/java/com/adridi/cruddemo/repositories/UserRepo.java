package com.adridi.cruddemo.repositories;

import com.adridi.cruddemo.models.CrudUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<CrudUser, Long> {
}
