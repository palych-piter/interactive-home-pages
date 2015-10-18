package core;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Andrey on 10/6/2015.
 * Message on the board
 */

// Hibernate annotations

@Entity
@Table(name = "Message")
public class Message {

    //ID of a message
    @Id
    @GeneratedValue
    int id;
    //Timestamp of the message
    @Column
    Date timestamp;
    //Author of a message
    @Column
    String author;
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

    ;

    public void EditMessage() {
    }

    ;

    public void RemoveMessage() {
    }

    ;

    public void AttachPicture() {
    }

}


