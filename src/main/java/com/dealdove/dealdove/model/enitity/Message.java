package com.dealdove.dealdove.model.enitity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.ZonedDateTime;

@Entity
@DynamicInsert //新增一筆資料時排除已有預設值或空欄位
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageID", nullable = false, unique = true)
    private Integer messageID;

    @Column(name = "receiverId", nullable = false)
    private Integer receiverId;

    @Column(name = "senderId", nullable = false)
    private Integer senderId;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "timeStamp")
    private ZonedDateTime timeStamp;

    public Message() {

    }
    public Message(Integer messageID, Integer receiverId, Integer senderId,  String text, String image, ZonedDateTime timeStamp) {
        this.messageID = messageID;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.text = text;
        this.image = image;
        this.timeStamp = timeStamp;
    }

    public Integer getMessageID() {
        return messageID;
    }


    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
