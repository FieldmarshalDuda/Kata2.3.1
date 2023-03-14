package katapackage.model;

import jakarta.persistence.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="name",nullable = false)
    @NotEmpty(message="Name should not be empty")
    @Size(min=2,max = 32,message="Name length:{2;32}")
    private String name;
    @NotEmpty(message="Lastname should not be empty")
    @Size(min=2,max = 32,message="Lastname length: {2;32}")
    @Column(name="lastname",nullable = false)
    private String lastname;
    @Email(message = "Enter valid email")
    @NotEmpty(message = "Email should not be empty")
    @Column(name="email")
    private String email;

    public User() {

    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastname = lastName;
        this.email = email;
    }

    public User(int id, String name, String lastname, String email) {
        this.id=id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
       return ("Name:"+ name+" / "+"Last name: "+ lastname+" / "+"Identification: "+id);
    }
}
