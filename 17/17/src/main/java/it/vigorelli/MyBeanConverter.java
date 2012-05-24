package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class MyBeanConverter implements Serializable {
    @Future private Date myDate = new Date();
    @NotNull private Integer myNumber;
    @Size(min = 3) private String myString;
    @NotNull @AssertTrue private Boolean myBoolean;
    private Persona myPersona;

    public Persona getMyPersona() {
        return myPersona;
    }

    public void setMyPersona(Persona myPersona) {
        this.myPersona = myPersona;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public Integer getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(Integer myNumber) {
        this.myNumber = myNumber;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public Boolean getMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(Boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String myAction() {
        System.out.println("myNumber = " + myNumber);
        System.out.println("myDate = " + myDate);
        System.out.println("myString = " + myString);
        System.out.println("myBoolean = " + myBoolean);
        System.out.println("myPersona = " + myPersona);
        return null;
    }
}
