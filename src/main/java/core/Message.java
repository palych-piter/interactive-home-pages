package core;

import javax.persistence.*;
import java.util.Date;


/**
 * Implementing the Message class, the class contains
 * messages which have been added by users, including
 * a guest user
 *
 */

// Hibernate annotations

@Entity
// You need to ESCAPE every field/table name that has
// capital letters using \""

@Table(name = "\"Message\"")
public class Message {

    //ID of a message
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Timestamp of the message
    @Column
    private Date timestamp;

    //Author of a message
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_pkey")
    private User user;

    //content of a message
    @Column
    private String content;
    //link to a picture
    @Column
    private String picture_link;

    public String getcontent() {
        return content;
    }

    public void setContent(String newContent) {
        content = newContent;
    }

    public Date gettimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date newDate) {
        timestamp = newDate;
    }

    public String getpicture_link() {
        return picture_link;
    }

    public void setPicture_Link(String newPictureLink) {
        picture_link = newPictureLink;
    }

    public Integer getid() {
        return id;
    }

    public User getuser() {
        return user;
    }

    public void setUser(User newUser) {
        user = newUser;

    }

}


