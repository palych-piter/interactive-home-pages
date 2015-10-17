package core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Andrey on 10/6/2015.
 */

@Entity
@Table(name = "User")
public class User {

    @Column
    public String name;
    @Column
    public String email;
    @Column
    public String status;

    public static void main(String[] args) {

    }

    public void AddUser() {
    }

    public void EditUser() {
    }

    public void RemoveUser() {
    }

}
