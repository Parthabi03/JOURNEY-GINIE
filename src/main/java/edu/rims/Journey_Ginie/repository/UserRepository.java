 package edu.rims.Journey_Ginie.repository;


 import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Journey_Ginie.entity.User;

 public interface UserRepository extends JpaRepository<User, Integer>{
    
}
