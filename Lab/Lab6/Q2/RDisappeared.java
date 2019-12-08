package Lab6.Q2;

public class RDisappeared implements Role {

    public String getNameAndRole(Member member) {
        return member.getName() + "[x]";
    }

    public String genTeamContactMsg(Team team) {
        Member leader = team.getLeader(); //call team.getLeader();
        if (leader==null) //is it null? compare with: null
            return "There is no leader in your team.  Please contact your instructor.";
        else
            return "When you are back, please contact your leader: " + leader.getName(); //call leader.getName();
    }


    public String getRoleDescription() {
        return "a disappeared member";
    }
}
