
package core;

import javax.persistence.*;
import java.util.Date;

/**
 * Implementing the Message view class, the class contains
 * message list representation including all fields existed in
 * a message table plus a user field from a joined User table
 **/

// Hibernate annotations
@Entity
// You need to ESCAPE every field/table name that has
// capital letters using \""

@NamedNativeQuery(name = "viewMessages",
        query = "select * from vMessageList order by TIMESTAMP",
        resultClass = vMessageList.class)

public class vMessageList implements java.io.Serializable {

    //ID of a message
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Timestamp of the message
    @Column
    private Date timestamp;

    //Author of a message
    private String user;

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

    public void setDate(Date newDate) {
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

    public String getuser() {
        return user;
    }

}


