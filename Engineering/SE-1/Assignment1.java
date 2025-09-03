import java.util.Arrays;
import java.util.Scanner;

class Assignment1 {
    String[] seStudents = new String[10];
    String[] badmintonPlayers = new String[5];
    String[] cricketPlayers = new String[5];
    String[] footballPlayers = new String[5];
    String[] commonPlayerOfCricketAndFootball;
    String[] commonPlayerOfCricketAndBadminton;
    String[] commonPlayerOfFootballAndBadminton;
    String[] commonPlayersInCricAndFoot;

    public Assignment1() {
        this.seStudents = new String[]{"a","b","c","d","e","f"};
        this.badmintonPlayers = new String[]{"a","b","f","e"};
        this.cricketPlayers = new String[]{"b","c","f"};
        this.footballPlayers = new String[]{"d","a","e","f"};
        this.commonPlayerOfCricketAndFootball = new String[]{"Players"};
        this.commonPlayerOfCricketAndBadminton = new String[]{"Players"};
        this.commonPlayerOfFootballAndBadminton = new String[]{"Players"};
    }
    public String[] getSeStudents() {
        return seStudents;
    }
    public void setSeStudents() {
        System.out.println("Enter the number of students: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        this.seStudents = new String[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter name of student "+(i+1)+":");
            String studentName = scanner.next();
            this.seStudents[i] = studentName;
        }
    }
    public String[] getBadmintonPlayers() {
        return badmintonPlayers;
    }
     public void setBadmintonPlayers() {
        System.out.println("Enter the number of students who play badminton: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        this.badmintonPlayers = new String[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter name of student "+(i+1)+":");
            String studentName = scanner.next();
            this.badmintonPlayers[i] = studentName;
        }
    }
    public String[] getCricketPlayers() {
        return cricketPlayers;
    }
     public void setCricketPlayers() {
        System.out.println("Enter the number of students who play cricket: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        this.cricketPlayers = new String[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter name of student "+(i+1)+":");
            String studentName = scanner.next();
            this.cricketPlayers[i] = studentName;
        }
    }
    public String[] getFootballPlayers() {
        return footballPlayers;
    }
    public void setFootballPlayers() {
        System.out.println("Enter the number of students who play football: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        this.footballPlayers = new String[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter name of student "+(i+1)+":");
            String studentName = scanner.next();
            this.footballPlayers[i] = studentName;
        }
    }
    public void commonPlayersForCricketAndFootball() {
        this.commonPlayerOfCricketAndFootball = new String[seStudents.length];
        for (int i = 0; i < cricketPlayers.length; i++) {
            for (int j = 0; j < footballPlayers.length; j++) {
                if (cricketPlayers[i].equals(footballPlayers[j])) {
                    this.commonPlayerOfCricketAndFootball[i] = cricketPlayers[i];
                }
            }
        }
        int number = 0;
        for(String player : this.commonPlayerOfCricketAndFootball) {
            if(player!=null) {
                number++;
            }
        }
        String[] players = new String[number];
        int i =0;
        for(String player : this.commonPlayerOfCricketAndFootball) {
            if(player!=null) {
                players[i]=player;
                i++;
            }
        }
        System.out.println("Students who play both cricket and football are "+number +" "+ Arrays.toString(commonPlayerOfCricketAndFootball)+" "+Arrays.toString(players));
    }
    public void commonPlayersForCricketAndBadminton() {
        this.commonPlayerOfCricketAndBadminton = new String[Math.min(cricketPlayers.length,badmintonPlayers.length)];
        for (int i = 0; i < cricketPlayers.length; i++) {
            for (int j = 0; j < badmintonPlayers.length; j++) {
                if (cricketPlayers[i].equals(badmintonPlayers[j])) {
                    this.commonPlayerOfCricketAndBadminton[i] = cricketPlayers[i];
                }
            }
        }
        int number1 = 0;
        for(String player : this.commonPlayerOfCricketAndBadminton) {
            if(player!=null) {
                number1++;
            }
        }
        String[] players1 = new String[number1];
        int i =0;
        for(String player : this.commonPlayerOfCricketAndBadminton) {
            if(player!=null) {
                players1[i]=player;
                i++;
            }
        }
        System.out.println("Students who play both cricket and badminton are "+number1+" "+Arrays.toString(commonPlayerOfCricketAndBadminton)+Arrays.toString(players1));
    }
    public void commonPlayersForFootballAndBadminton() {
        this.commonPlayerOfFootballAndBadminton = new String[seStudents.length];
        for (int i = 0; i < footballPlayers.length; i++) {
            for (int j = 0; j < badmintonPlayers.length; j++) {
                if (footballPlayers[i].equals(badmintonPlayers[j])) {
                    this.commonPlayerOfFootballAndBadminton[i] = footballPlayers[i];
                }
            }
        }
        int number2 = 0;
        for(String player : this.commonPlayerOfFootballAndBadminton) {
            if(player!=null) {
                number2++;
            }
        }
        String[] players2 = new String[number2];
        int i =0;
        for(String player : this.commonPlayerOfFootballAndBadminton) {
            if(player!=null) {
                players2[i]=player;
                i++;
            }
        }
        System.out.println("Students who play both football and badminton are "+number2+" "+Arrays.toString(commonPlayerOfFootballAndBadminton)+Arrays.toString(players2));
    }
    public void describeElement() {
        System.out.println("Enter the name ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(int i =0; i<badmintonPlayers.length; i++) {
            if(badmintonPlayers[i].equals(name)) {
                System.out.println("Plays Badminton ");
            }
        }
        for(int i =0; i<cricketPlayers.length; i++) {
            if(cricketPlayers[i].equals(name)) {
                System.out.println("Plays Cricket ");
            }
        }
        for(int i =0; i<footballPlayers.length; i++) {
            if(footballPlayers[i].equals(name)) {
                System.out.println("Plays Football ");
            }
        } 
        boolean found = false;
        for(String inputName : seStudents) {
            if(inputName.equals(name)) {
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Name not valid");
        }   
    }
    public static void main(String[] args) {
        Assignment1 assign = new Assignment1();
        // assign.setSeStudents();
        // assign.setBadmintonPlayers();
        // assign.setCricketPlayers();
        // assign.setFootballPlayers();
        System.out.println("Students in SE are "+ Arrays.toString(assign.seStudents));
        System.out.println("Students who play badminton in SE are "+ Arrays.toString(assign.badmintonPlayers));
        System.out.println("Students who play cricket in SE are "+ Arrays.toString(assign.cricketPlayers));
        System.out.println("Students who play football in SE are "+ Arrays.toString(assign.footballPlayers));
        assign.commonPlayersForCricketAndFootball();
        // System.out.println("Students who play both cricket and football are"+Arrays.toString(assign.commonPlayerOfCricketAndFootball));
        assign.commonPlayersForCricketAndBadminton();
        // System.out.println("Students who play both cricket and badminton are"+Arrays.toString(assign.commonPlayerOfCricketAndBadminton));
        assign.commonPlayersForFootballAndBadminton();
        // System.out.println("Students who play both football and badminton are"+Arrays.toString(assign.commonPlayerOfFootballAndBadminton));  
        assign.describeElement();    
    }
}
