package core;

import javax.persistence.*;

/**
 * Implementing the User class, the class contains
 * users which are allowed to leave messages, including
 * a guest user
 */

@Entity
@Table(name = "\"User\"")
public class User {

    @Column
    public String name;
    @Column
    public String email;
    @Column
    public String status;
    //ID of a user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public static void main(String[] args) {

    }

    public void AddUser() {
    }

    public void EditUser() {
    }

    public void RemoveUser() {
    }

    public String getname() {
        return name;
    }


}
