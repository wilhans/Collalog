package project.lumohacks.psychologyreport;

import project.lumohacks.psychologyreport.groupInfo.Group;
import project.lumohacks.psychologyreport.groupInfo.MemberType;

public class Singleton {
    //Put the data that you want to share through the page
    Group group;
    private static volatile Singleton singleton = new Singleton();
    private Singleton() {
        //Initialize the data at first
        initializeGroup();

    }

    private void initializeGroup() {
        Group group = new Group("John",1,1);
        group.addMember(MemberType.HealthProfessional,"Timothy","a@aa.com",1,"Doctor");
        group.addMember(MemberType.Client,"John","aa@aa.com",12,"Client");
        group.addMember(MemberType.Associate,"Jane","aaa@aa.com",123,"Doctor");
        group.addMember(MemberType.Associate,"Sarah","aaaa@aa.com",1234,"Doctor");
        group.addMember(MemberType.Associate,"Peter","aaaaa@aa.com",12345,"Doctor");
    }

    //To get the data that we need (sharing through pages)
    public static Singleton getInstance() {
        return singleton;
    }
}
