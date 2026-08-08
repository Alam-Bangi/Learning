package tryouts.inheritance;

public class HybridInheritance {
    public static void main(String[] args) {

        SeniorDeveloper sd = new SeniorDeveloper();

        sd.work();       // Employee
        sd.writeCode();  // Developer
        sd.leadTeam();  // TeamLeader
    }
}