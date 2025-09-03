    import java.util.Arrays;
    import java.util.Scanner;

    class Task1 {
        String[] seStudents = new String[10];
        String[] badmintonPlayers = new String[5];
        String[] cricketPlayers = new String[5];
        String[] footballPlayers = new String[5];
        String[] commonPlayerOfCricketAndFootball;
        String[] commonPlayerOfCricketAndBadminton;
        String[] commonPlayerOfFootballAndBadminton;

        public Task1() {
            this.seStudents = new String[]{"a","b","c","d","e"};
            this.badmintonPlayers = new String[]{"a","b"};
            this.cricketPlayers = new String[]{"b","c"};
            this.footballPlayers = new String[]{"a","b","c","e"};
            this.commonPlayerOfCricketAndFootball = this.commonPlayersForCricketAndFootball();
            this.commonPlayerOfCricketAndBadminton = this.commonPlayerForCricketAndBadminton();
            this.commonPlayerOfFootballAndBadminton = this.commonPlayerForFootballAndBadminton();
        }
        public Task1(String[] seStudents) {
            this.seStudents = new String[]{};
            this.badmintonPlayers = new String[]{};
            this.cricketPlayers = new String[]{};
            this.footballPlayers = new String[]{};
            this.commonPlayerOfCricketAndFootball = new String[]{};
            this.commonPlayerOfCricketAndBadminton = new String[]{};
            this.commonPlayerOfFootballAndBadminton = new String[]{};
        }
        public void  getSeStudents() {
            System.out.println("Students in SE are "+Arrays.toString(seStudents));
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
            System.out.println("Students in SE are "+ Arrays.toString(seStudents));
        }
        public void getBadmintonPlayers() {
            System.out.println("Students who play badminton in SE are "+Arrays.toString(badmintonPlayers));
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
            System.out.println("Students who play badminton in SE are "+ Arrays.toString(badmintonPlayers));
        }
        public void getCricketPlayers() {
            System.out.println("Students who play cricket in SE are "+Arrays.toString(cricketPlayers));
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
            System.out.println("Students who play cricket in SE are "+ Arrays.toString(cricketPlayers));
        }
        public void getFootballPlayers() {
            System.out.println("Students who play football in SE are "+Arrays.toString(footballPlayers));
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
            System.out.println("Students who play football in SE are "+ Arrays.toString(footballPlayers));
        }
        public String[] commonPlayersForCricketAndFootball() {
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
            return players;
        }
        public String[] commonPlayersForCricketAndBadminton() {
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
            return players1;
        }
        public String[] commonPlayersForFootballAndBadminton() {
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
            return players2;
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
        public void displayInput() {
            System.out.println("Students in SE are "+Arrays.toString(seStudents));
            System.out.println("Students who play badminton in SE are "+Arrays.toString(badmintonPlayers));
            System.out.println("Students who play cricket in SE are "+Arrays.toString(cricketPlayers));
            System.out.println("Students who play football in SE are "+Arrays.toString(footballPlayers));
            System.out.println("Students who play both cricket and football are "+Arrays.toString(commonPlayerOfCricketAndFootball));
            System.out.println("Students who play both cricket and badminton are "+Arrays.toString(commonPlayerOfCricketAndBadminton));
            System.out.println("Students who play both badminton and football are "+Arrays.toString(commonPlayerOfFootballAndBadminton));
        }
        public static void main(String[] args) {
            Task1 assign = new Task1();  
            Task1 assign2 = new Task1();
            int choice = 0 ;
            while(choice !=10) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("0. Perform all given below.");
            System.out.println("1. Enter SE students.");
            System.out.println("2. Enter SE students who play badminton.");
            System.out.println("3. Enter SE students who play cricket.");
            System.out.println("4. Enter SE students who play football.");
            System.out.println("5. Students who play cricket and football.");
            System.out.println("6. Students who play cricket and badminton.");
            System.out.println("7. Students who play football and badminton.");
            System.out.println("8. Enter name to see what sports he\she participates.");
            System.out.println("9. Display all inputs");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner= new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    assign.getSeStudents();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.getBadmintonPlayers();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.getCricketPlayers();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.getFootballPlayers();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.commonPlayersForCricketAndFootball();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.commonPlayersForCricketAndBadminton();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.commonPlayersForFootballAndBadminton();
                    System.out.println("--------------------------------------------------------------------------");
                    assign.describeElement();
                    System.out.println("--------------------------------------------------------------------------");
                    break;                
                case 1:
                    assign2.setSeStudents();
                    break;
                    case 2:
                    assign2.setBadmintonPlayers();
                    break;
                case 3:
                    assign2.setCricketPlayers();
                    break;
                case 4:
                    assign2.setFootballPlayers();
                    break;
                case 5:
                    assign2.commonPlayersForCricketAndFootball();
                    break;
                case 6:
                    assign2.commonPlayersForCricketAndBadminton();
                    break;
                case 7:
                    assign2.commonPlayersForFootballAndBadminton();
                    break;
                case 8:
                    assign2.describeElement();
                    break;
                case 9:
                    assign2.displayInput();
                    break;
                case 10:
                    System.out.println("Exiting the program");
                    scanner.close();
                    return ;
                default:
                    System.out.println("Invalid Input.");
                }
                // System.out.println("Do you want to continue?\n1. Continue \n2. Exit");
                // Scanner scanner1 = new Scanner(System.in);
                // int Y = scanner1.nextInt();
                // if(Y==1) {
                    
                // } else if(Y==2) {
                //     System.out.println("Exiting the program");
                //     scanner1.close();
                //     return ;
                // }
            } 
        }
    }
