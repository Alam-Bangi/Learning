package tryouts.inheritance;

public class MultilevelInheritance {
    public static void main(String[] args) {
        SeniorDeveloper sd = new SeniorDeveloper();
        sd.work();          // Employee
        sd.writeCode();     // Developer
        sd.designSystem();  // SeniorDeveloper
    }
}