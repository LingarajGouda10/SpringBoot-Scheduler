package com.ivoyant.SpringBootScheduler.Repository;

import com.ivoyant.SpringBootScheduler.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
