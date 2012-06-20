package it.vigorelli;

import it.vigorelli.model.User;
import it.vigorelli.persistence.UserQuery;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoggedUser  implements Serializable {
    @Inject UserQuery userQuery;
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void init() {
        user = userQuery.findUser("luca.molteni@me.com");
    }
}
