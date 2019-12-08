package Lab6.Q2;

public class Member
{

    //Instance fields
    private String name;
    private Role role;
	
	//Constructor
    public Member(String name, Role aState){
        this.name = name;
        this.role = aState;
    }
	
	//Assessor method
    public String getName() {
        return this.name;
    }

    public Role getRole(){return this.role;}

    public String getNameAndRole(){return role.getNameAndRole(this);}

    public void setRole(Role role){ this.role = role;}

    public String getRoleDescription(){return role.getRoleDescription();}
}