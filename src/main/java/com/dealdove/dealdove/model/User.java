package com.dealdove.dealdove.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.ZonedDateTime;

    @Entity
    @DynamicInsert
    @Table(name = "user")
    public class User {

        @Id
        @Column(name = "userID" , nullable = false , unique = true)
        private String userID;

        @Column(name = "username" , nullable = false , unique = true)
        private String username;

        @Column(name = "password" , nullable = true)
        private String password;

        @Column(name = "email" , nullable = false , unique = true)
        private String email;

        @Column(name = "status" , nullable = false)
        private boolean status;

        @Column(name = "gender" , nullable = true)
        private int gender;

        @Column(name = "birthdate" , nullable = true)
        private ZonedDateTime birthdate;

        @Column(name = "createtime" , nullable = true)
        private ZonedDateTime createtime;

        @Column(name = "avatar" , nullable = true)
        private String avatar;

        @Column(name = "lastedit")
        private ZonedDateTime lastedit;
        public User() {
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        // Constructor for User
        public User(String ID, String username, String password, String email, boolean status, int gender, ZonedDateTime birthdate, ZonedDateTime createtime, ZonedDateTime lastedit,String avatar) {
            this.userID = ID;
            this.username = username;
            this.password = password;
            this.email = email;
            this.status = status;
            this.gender = gender;
            this.birthdate = birthdate;
            this.createtime = createtime;
            this.lastedit = lastedit;
            this.avatar = avatar;
        }


        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserName() {
            return username;
        }

        public void setUserName(String userName) {
            this.username = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public ZonedDateTime getBirthDate() {
            return birthdate;
        }

        public void setBirthDate(ZonedDateTime birthDate) {
            this.birthdate = birthDate;
        }

        public ZonedDateTime getCreateTime() {
            return createtime;
        }

        public void setCreateTime(ZonedDateTime createTime) {
            this.createtime = createTime;
        }

        public ZonedDateTime getLastEdit() {
            return lastedit;
        }

        public void setLastEdit(ZonedDateTime lastEdit) {
            this.lastedit = lastEdit;
        }



    }

