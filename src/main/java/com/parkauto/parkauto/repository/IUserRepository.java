package com.parkauto.parkauto.repository;

import com.parkauto.parkauto.entity.Camion;
import com.parkauto.parkauto.entity.Role;
import com.parkauto.parkauto.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.parkauto.parkauto.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    Optional<User>findByEmail(String userName);

    User findByRole(Role role);

}
