package com.parkauto.parkauto.service;

import com.parkauto.parkauto.entity.User;
import com.parkauto.parkauto.exception.EmailNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {

    // Méthode qui permet de réinitialiser le mot de passe de l'utilisateur
    void resetPassword(String email)throws EmailNotFoundException;
    List<User> getUsers();
    void deleteUser(long idUser);
    UserDetailsService userDetailsService();

    }
