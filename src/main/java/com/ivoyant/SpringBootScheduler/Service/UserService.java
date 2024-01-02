package com.ivoyant.SpringBootScheduler.Service;

import com.ivoyant.SpringBootScheduler.Model.User;
import com.ivoyant.SpringBootScheduler.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Scheduled(fixedRate = 5000)
    public void addToDb(){
        User user=new User();
        user.setName("user"+new Random().nextInt(78654));
        repository.save(user);
        System.out.println("add service call in" + new Date().toString());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDbJob(){
        List<User> users=repository.findAll();
        System.out.println(" fetch service call in " + new Date().toString());
        System.out.println(" no of record fetched : " + users.size());
        logger.info("users : {}", users);
    }
}
