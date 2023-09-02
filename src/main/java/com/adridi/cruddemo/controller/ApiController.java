package com.adridi.cruddemo.controller;


import com.adridi.cruddemo.models.CrudUser;
import com.adridi.cruddemo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage() {
        return "Hello from Achraf, just testing my restAPI";
    }

    @GetMapping(value = "/users")
    public List<CrudUser> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/createuser")
    public String createUser(@RequestBody CrudUser user) {
        userRepo.save(user);
        return "Saved sucessfully...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return " user deleted successfully...";
    }

    @PutMapping( value = "/updateuser/{id}")
    public String modifyUser(@PathVariable Long id, @RequestBody CrudUser user) {
        CrudUser crudUser = userRepo.getById(id);
        crudUser.setFirstName(user.getFirstName());
        crudUser.setLastName(user.getLastName());
        userRepo.save(crudUser);
        return "User updated successfully...";
    }
}
