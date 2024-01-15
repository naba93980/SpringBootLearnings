package com.springboot.basic;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springboot.basic.interfaces.IStaff;

import jakarta.annotation.PostConstruct;

@Component
// @Scope(value = "prototype")   - this works if u dont define any bean in config
public class Doctor implements IStaff, BeanNameAware {

    private String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public void assist() {
        System.out.println("Doctor needs assistance");
    }

    @PostConstruct
    public void postConstructProcesor(){
        System.out.println("inside postConstruct");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("set bean name is called");
    }

}
