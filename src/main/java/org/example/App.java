package org.example;

package org.example;

import org.example.dao.AppUserDao;
import org.example.model.AppUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class App{

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //using for AnnotationConfigApplicationContext for load this class and used
    AppUserDao dao = context.getBean("appUserDao", AppUserDao.class );
    AppUser addAppUser = dao.save(new AppUser("hema", "hema@gmail.com","11111", "almhult"));
    Optional<AppUser> user = dao.findById(addAppUser.getId());
}