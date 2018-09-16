package project.lumohacks.psychologyreport;

import project.lumohacks.psychologyreport.groupInfo.Group;
import project.lumohacks.psychologyreport.groupInfo.MemberType;

//Class to share the data between pages.

public class Singleton {
    //Put the data that you want to share through the page
    private Group group;
    private static volatile Singleton singleton = new Singleton();
    private String userLogin;
    private String userPassword;

    private Singleton() {
        //Initialize the data at first
        initializeGroup();

    }

    private void initializeGroup() {
        this.group = new Group("John",1,1);
        this.group.addMember(MemberType.HealthProfessional,"Timothy","a@aa.com",1,"Doctor", "timato");
        this.group.addMember(MemberType.Client,"John","aa@aa.com",12,"Client", "1234");
        this.group.addMember(MemberType.Associate,"Jane","aaa@aa.com",123,"Doctor", "j853");
        this.group.addMember(MemberType.Associate,"Sarah","aaaa@aa.com",1234,"Doctor", "4_32");
        this.group.addMember(MemberType.Associate,"Peter","aaaaa@aa.com",12345,"Doctor", "peteto");
    }

    public Group getGroup(){
        return group;
    }

    //To get the data that we need (sharing through pages)
    public static Singleton getInstance() {
        return singleton;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
