package project.lumohacks.psychologyreport.groupInfo;

import java.util.Map;

/**
 * Created by David Liu on 9/15/2018.
 */

public class Member {
    private MemberType memberType;
    private String name;
    private String email;
    private int phoneNumber;
    private String relationWithClient;
    private String password;

    public Member(MemberType memberType, String name, String email, int phoneNumber,
                       String relationWithClient, String password) {
        this.memberType = memberType;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.relationWithClient = relationWithClient;
        this.password = password;
    }

    // make a

    public String getName() {
        return name;
    }

    public String getMemberEmail() {
        return email;
    }

    public int getMemberPhoneNumber() {
        return  phoneNumber;
    }

    public String getMemberRelationWithClient() {
        return relationWithClient;
    }

    public String getPassword() {
        return password;
    }


    public MemberType getMemberType() {
        return memberType;
    }
}
