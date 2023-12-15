package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientFriends {
    private String username;
    private String friendusername;


    public ClientFriends(){

    }

    public ClientFriends(String username, String friendusername){//Long id, String name, int age, String birthdate
        this.username = username;
        this.friendusername = friendusername;

    }

}
