package tryouts.inheritance;

class SeniorDeveloper extends Developer implements TeamLeader{
    void designSystem() {
        System.out.println("Senior developer designs system");
    }

    @Override
    public void leadTeam() {
        System.out.println("Senior developer leads the team");
    }
}