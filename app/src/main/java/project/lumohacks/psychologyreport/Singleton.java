package project.lumohacks.psychologyreport;

import java.util.ArrayList;
import java.util.List;

import project.lumohacks.psychologyreport.groupInfo.Group;
import project.lumohacks.psychologyreport.groupInfo.MemberType;

//Class to share the data between pages.

public class Singleton {
    //Put the data that you want to share through the page
    private List<Group> group;
    private String userLogin;
    private Group groupLogin;
    private static volatile Singleton singleton = new Singleton();


    private Singleton() {
        //Initialize the data at first
        initializeGroup();

    }

    private void initializeGroup() {
        group = new ArrayList<>();
        Group first_group = new Group("John", 1, 1);
        first_group.addMember(MemberType.HealthProfessional,"Timothy","a@aa.com",1,"Doctor");
        first_group.addMember(MemberType.Client,"John","aa@aa.com",12,"Client");
        first_group.addMember(MemberType.Associate,"Jane","aaa@aa.com",123,"Doctor");
        first_group.addMember(MemberType.Associate,"Sarah","aaaa@aa.com",1234,"Doctor");
        first_group.addMember(MemberType.Associate,"Peter","aaaaa@aa.com",12345,"Doctor");
        group.add(first_group);
    }

    public int getGroupsSize() {return group.size();}
    public Group getGroup(int index){
        return group.get(index);
    }

    public Group getGroup() {
        if(groupLogin != null) {
            return groupLogin;
        }
        return null;
    }

    //To get the data that we need (sharing through pages)
    public static Singleton getInstance() {
        return singleton;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setGroupLogin(Group group_param) { this.groupLogin = group_param; }

    public String getUserLogin() {
        return userLogin;
    }

    public Group memberExist(String username){
        for(Group current_group : group){
            if(current_group.memberExist(username)){
                return current_group;
            }
        }
        return null;
    }
}
