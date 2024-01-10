package com.dealdove.dealdove.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "messageID", nullable = false, unique = true)
    private Integer messageID;

    @Column(name = "receiverid", nullable = false)
    private Integer receiverid;

    @Column(name = "senderid", nullable = false)
    private Integer senderid;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "timestamp", nullable = false)
    private ZonedDateTime timestamp;

    public Message() {

    }
    public Message(Integer messageID, Integer receiverid, Integer senderid, Boolean messagetype, String text, String image, ZonedDateTime timestamp) {
        this.messageID = messageID;
        this.receiverid = receiverid;
        this.senderid = senderid;
        this.text = text;
        this.image = image;
        this.timestamp = timestamp;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
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

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
