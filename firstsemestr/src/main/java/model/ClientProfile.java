package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientProfile {
    private Long id;
    private String name;
    private String age;
    private String birthdate;


    public ClientProfile(){

    }

    public ClientProfile(Long id, String name, String age, String birthdate){//Long id, String name, int age, String birthdate
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

}
