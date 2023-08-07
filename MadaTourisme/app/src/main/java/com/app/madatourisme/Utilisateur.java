package com.app.madatourisme;

public class Utilisateur {

    private String name;
    private String firstname;
    private String email;
    private String password;
    
    private String function;

    public Utilisateur(String name, String firstname, String email, String password, String function) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
