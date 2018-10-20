package com.itmayiedu.entity.req;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ChangePassword {

    private  long memberId;
    private  String oldLoginPwd;
    private  String newLoginPwd;

}
