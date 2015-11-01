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
    int id;

    //Timestamp of the message
    @Column
    Date timestamp;

    //Author of a message
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_pkey")
    User user;

    //content of a message
    @Column
    String content;
    //link to a picture
    @Column
    String picture_link;


    public static void main(String[] args) {
    }

    public void AddMessage() {
    }

    public void EditMessage() {
    }

    public void RemoveMessage() {
    }

    public void AttachPicture() {
    }

}


