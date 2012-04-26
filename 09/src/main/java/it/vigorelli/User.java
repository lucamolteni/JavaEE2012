package it.vigorelli;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("user")
@SessionScoped
public class User implements Serializable {
    private String name = "";
    private String password = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGreeting() {
        if(name.length() == 0) return "";
        return String.format("Welcome to JSF2 + ajax %s!"
                , name);
    }
}
