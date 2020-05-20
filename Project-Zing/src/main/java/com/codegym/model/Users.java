package com.codegym.model;



import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String status;
    private String phone;
    private String token;

    @ManyToOne
    private Role role;

    public Users() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users(String fullName, String email, String username, String password, String status, String phone, Role role, String token) {
        this.fullName = fullName;
        this.email=email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.role = role;
        this.token=token;
    }

    public Users(Long id, String fullName, String email, String username, String password, String status, String phone, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email=email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.role = role;
    }

    public Users(String email, String username, String password, String phone) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
    public Users( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
