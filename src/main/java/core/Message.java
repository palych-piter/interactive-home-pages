package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Andrey on 10/6/2015.
 * Message on the board
 */

// Hibernate annotations

@Entity
@Table(name = "Message")
public class Message {

    //ID of a message
    @Column
    int id;
    //Author of a message
    @Column
    String author;
    //content of a message
    @Column
    String content;
    //Date and time of a message

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


