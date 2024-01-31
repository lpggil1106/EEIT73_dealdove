package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.annotation.meta.TypeQualifierNickname;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@DynamicInsert
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userID", nullable = false, unique = true)
    private String userID;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "gender", nullable = true)
    private int gender;

    @Column(name = "birthdate", nullable = true)
    private LocalDate birthdate;

    @Column(name = "createtime", nullable = true)
    private ZonedDateTime createtime;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "lastedit")
    private ZonedDateTime lastedit;

    @OneToMany
    @JoinColumn(name = "userID")
    private List<ShoppingCartItem> shoppingCartItems;


    public User() {
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // Constructor for User
    public User(String ID, String username, String password, String email, boolean status, int gender, LocalDate birthdate, ZonedDateTime createtime, ZonedDateTime lastedit, String avatar) {
        this.userID = ID;
        this.userName = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.gender = gender;
        this.birthdate = birthdate;
        this.createtime = createtime;
        this.lastedit = lastedit;
        this.avatar = avatar;
    }
}

