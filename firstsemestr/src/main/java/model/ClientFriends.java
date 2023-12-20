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

    public ClientFriends(String username, String friendusername){
        this.username = username;
        this.friendusername = friendusername;

    }

}
