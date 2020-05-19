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
    private String userName;
    private String password;
    private String status;
    private String phone;
    @ManyToOne
    private Role role;

    public Users() {
    }

    public Users(String fullName, String email, String userName, String password, String status, String phone, Role role) {
        this.fullName = fullName;
        this.email=email;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.role = role;
    }

    public Users(Long id, String fullName, String email, String userName, String password, String status, String phone, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email=email;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.role = role;
    }

    public Users(String email, String userName, String password, String phone) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }
    public Users( String userName, String password) {
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
