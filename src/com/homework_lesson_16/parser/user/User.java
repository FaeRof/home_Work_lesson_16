package com.homework_lesson_16.parser.user;

public class User {
    private String firstname;
    private String lastname;
    private String city;
    private int id;

    public User(int id, String firstname, String lastname, String city ){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.city = city;
    }


    public String getFirstname(){return firstname;}
    public void setFirstname(String firstname){this.firstname=firstname;}

    public String getLastname(){return lastname;}
    public void setLastname(String lastname){this.lastname=lastname;}

    public String getCity(){return city;}
    public void setCity(String city){this.city=city;}

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
}
