package com.dealdove.dealdove.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;

    @Entity
    @Table(name = "user")
    public class User {
        @Id
        @Column(name = "userID" , nullable = false , unique = true)
        private Integer userID;

        @Column(name = "userName" , nullable = false , unique = true)
        private String userName;

        @Column(name = "password" , nullable = false)
        private String password;

        @Column(name = "email" , nullable = false , unique = true)
        private String email;

        @Column(name = "status" , nullable = false)
        private boolean status;

        @Column(name = "gender" , nullable = true)
        private int gender;

        @Column(name = "birthDate" , nullable = true)
        private ZonedDateTime birthday;

        @Column(name = "createTime" , nullable = false)
        private ZonedDateTime createTime;

        @Column(name = "avatar" , nullable = true)
        private String avatar;
        public User() {
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        // Constructor for User
        public User(Integer ID, String userName, String password, String email, boolean status, int gender, ZonedDateTime birthday, ZonedDateTime createTime, ZonedDateTime lastEdit,String avatar) {
            this.userID = ID;
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.status = status;
            this.gender = gender;
            this.birthday = birthday;
            this.createTime = createTime;
            this.lastEdit = lastEdit;
            this.avatar = avatar;
        }


        public Integer getUserID() {
            return userID;
        }

        public void setUserID(Integer userID) {
            this.userID = userID;
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

        public ZonedDateTime getBirthday() {
            return birthday;
        }

        public void setBirthday(ZonedDateTime birthday) {
            this.birthday = birthday;
        }

        public ZonedDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(ZonedDateTime createTime) {
            this.createTime = createTime;
        }

        public ZonedDateTime getLastEdit() {
            return lastEdit;
        }

        public void setLastEdit(ZonedDateTime lastEdit) {
            this.lastEdit = lastEdit;
        }

        @Column(name = "lastEdit" , nullable = false)
        private ZonedDateTime lastEdit;

    }

