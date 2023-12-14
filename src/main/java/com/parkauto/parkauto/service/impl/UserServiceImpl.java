package com.parkauto.parkauto.service.impl;

import com.parkauto.parkauto.entity.User;
import com.parkauto.parkauto.exception.EmailNotFoundException;
import com.parkauto.parkauto.repository.IUserRepository;
import com.parkauto.parkauto.service.EmailService;
import com.parkauto.parkauto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;


    @Autowired
    private EmailService emailService;
    private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Autowired
    public UserServiceImpl(IUserRepository userRepository, EmailService emailService){
        this.userRepository = userRepository;
        this.emailService = emailService;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void deleteUser(long idUser){
        userRepository.deleteById(idUser);
    }

    // Méthode qui permet de réinitialiser le mot de passe de l'utilisateur
    @Override
    public void resetPassword(String email)throws EmailNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        if(user == null){
            throw new EmailNotFoundException("No user found by email");
        }
        String lien = "URL vers API";
        //Logger.info("lien" + lien);
        LOGGER.info("lien" + lien);
        emailService.sendResetPassword(user.get().getEmail(),user.get().getFirstname(),lien);
    }


    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(
                                ()-> new UsernameNotFoundException("user is not found")
                        );
            }
        };
    }
}