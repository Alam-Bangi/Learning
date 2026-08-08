package tryouts.inheritance;

interface Programmer {
    void writeCode();
}

interface Manager {
    void manageTeam();
}

class TeamLead implements Programmer, Manager {

    public void writeCode() {
        System.out.println("Team lead writes code");
    }

    public void manageTeam() {
        System.out.println("Team lead manages the team");
    }
}