package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientProfile {
    private String username;
    private String name;
    private String age;
    private String birthdate;
    private String userinfo;


    public ClientProfile(){

    }

    public ClientProfile(String username, String name, String age, String birthdate, String userinfo){//Long id, String name, int age, String birthdate
        this.username = username;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.userinfo = userinfo;
    }

}
