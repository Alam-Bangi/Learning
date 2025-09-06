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

        boolean isSeStudentsInput = false;
        boolean isBadmintonPlayersInput = false;
        boolean isCricketPlayersInput = false;
        boolean isFootballPlayersInput = false;

        public Task1() {
            this.seStudents = new String[]{"a","b","c","d","e"};
            this.badmintonPlayers = new String[]{"a","b"};
            this.cricketPlayers = new String[]{"b","c"};
            this.footballPlayers = new String[]{"a","b","c","e"};
            // this.commonPlayerOfCricketAndFootball = this.commonPlayersForCricketAndFootball();
            // this.commonPlayerOfCricketAndBadminton = this.commonPlayersForCricketAndBadminton();
            // this.commonPlayerOfFootballAndBadminton = this.commonPlayersForFootballAndBadminton();
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
        public String[] addPlayers(String gameName) {
            String[] players = new String[]{};
            System.out.printf("Enter the number of students who play %s: ",gameName);
            Scanner scanner = new Scanner(System.in);
            int noOfStudents = scanner.nextInt();
            players = new String[noOfStudents];
            int numberOfPlayers = 0;
            if(noOfStudents<=seStudents.length) {
                while(noOfStudents!=numberOfPlayers) {
                    for (int i=0; i<noOfStudents; ) {
                        System.out.println("Enter name of student "+(i+1)+":");
                        String studentName = scanner.next();
                        boolean isMatch = false;
                        for(String name:seStudents) {
                            if(studentName.equals(name)) {
                                isMatch = true;
                                players[i] = studentName;
                                numberOfPlayers++;
                                i++;
                            }
                        }
                        if(!isMatch) {
                            System.out.println("Please enter a valid name");
                        }
                    }
                }
                switch (gameName) {
                    case "badminton":
                        this.badmintonPlayers = players;
                        isBadmintonPlayersInput = true;
                        break;
                    case "cricket":
                        this.cricketPlayers = players;
                        isCricketPlayersInput = true;
                        break;
                    case "football":
                        this.footballPlayers = players;
                        isFootballPlayersInput = true;
                        break;
                    default:
                        break;
                }
                    System.out.printf("Players for %s are %d", gameName,numberOfPlayers).println();
                    System.out.printf("Students who play %s in SE are %s%n", gameName, Arrays.toString(players));
            } else {
                System.out.println("Entered number should be less than or equal to "+seStudents.length);
            }
            return players;
        }
        public void  getSeStudents() {
            System.out.println("Students in SE are "+Arrays.toString(seStudents));
        }
        public String[] setSeStudents() {
            System.out.println("Enter the number of students: ");
            Scanner scanner = new Scanner(System.in);
            int noOfStudents = scanner.nextInt();
            this.seStudents = new String[noOfStudents];
            for (int i=0; i<noOfStudents; i++) {
                System.out.println("Enter name of student "+(i+1)+":");
                String studentName = scanner.next();
                this.seStudents[i] = studentName;
            }
            isSeStudentsInput = true;
            System.out.println("Students in SE are "+ Arrays.toString(seStudents));
            return seStudents;
        }
        public void getBadmintonPlayers() {
            System.out.println("Students who play badminton in SE are "+Arrays.toString(badmintonPlayers));
        }
        public void setBadmintonPlayers() {
            addPlayers("badminton");
            // return badmintonPlayers;
        }
        public void getCricketPlayers() {
            System.out.println("Students who play cricket in SE are "+Arrays.toString(cricketPlayers));
        }
        public void setCricketPlayers() {
            addPlayers("cricket");
        }
        public void getFootballPlayers() {
            System.out.println("Students who play football in SE are "+Arrays.toString(footballPlayers));
        }
        public void setFootballPlayers() {
            addPlayers("football");
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
            System.out.println("Students who play both cricket and football are "+number+" "+Arrays.toString(players));
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
            System.out.println("Students who play both cricket and badminton are "+number1+" "+Arrays.toString(players1));
            return players1;
        }
        public String[] commonPlayersForFootballAndBadminton() {
            this.commonPlayerOfFootballAndBadminton = new String[seStudents.length];
            for (int i = 0; i < badmintonPlayers.length; i++) {
                for (int j = 0; j < footballPlayers.length; j++) {
                    if (badmintonPlayers[i].equals(footballPlayers[j])) {
                        this.commonPlayerOfFootballAndBadminton[i] = badmintonPlayers[i];
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
            System.out.println("Students who play both football and badminton are "+number2+" "+Arrays.toString(players2));
            return players2;
        }
        public void describeElement() {
            System.out.println("Enter the name ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if(isSeStudentsInput) {
                boolean plays = false;
                if(isSeStudentsInput) {
                    for(int i =0; i<badmintonPlayers.length; i++) {
                        if(badmintonPlayers[i].equals(name)) {
                            plays = true;
                            System.out.println("Plays Badminton ");
                        }
                    } if(!plays) {
                        System.out.println("Does not play Badminton");
                    }

                    plays = false;
                    for(int i =0; i<cricketPlayers.length; i++) {
                        if(cricketPlayers[i].equals(name)) {
                            plays = true;
                            System.out.println("Plays Cricket ");
                        }
                    } if(!plays) {
                        System.out.println("Does not play Cricket");
                    }
                plays = false;
                    for(int i =0; i<footballPlayers.length; i++) {
                        if(footballPlayers[i].equals(name)) {
                            plays = true;
                            System.out.println("Plays Football ");
                        }
                    }if(!plays) {
                        System.out.println("Does not play Football");
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
            }else {
                System.out.println("Name not valid");
            }
        }
        public void displayInput() {
            if (isSeStudentsInput) {
                System.out.println("Students in SE are: " + Arrays.toString(seStudents));
            } else {
                System.out.println("No students added");
            }
            if (isBadmintonPlayersInput) {
                System.out.println("Students who play badminton in SE are: " + Arrays.toString(badmintonPlayers));
            } else {
                System.out.println("No badminton players added ");
            }
            if (isCricketPlayersInput){
                System.out.println("Students who play cricket in SE are: " + Arrays.toString(cricketPlayers));
            } else {
                System.out.println("No cricket players added");
            }
            if (isFootballPlayersInput) {
                System.out.println("Students who play football in SE are: " + Arrays.toString(footballPlayers));
            } else {
                System.out.println("No football players added");
            }
            if (isCricketPlayersInput && isFootballPlayersInput){
                commonPlayersForCricketAndFootball();
            } else {
                System.out.println("Students who play both cricket and football are 0 []");
            }
            if (isCricketPlayersInput && isBadmintonPlayersInput) {
                commonPlayersForCricketAndBadminton();
            } else {
                System.out.println("Students for both cricket and badminton are 0 []");
            }
            if (isFootballPlayersInput && isBadmintonPlayersInput) {
                commonPlayersForFootballAndBadminton();
            } else {
                System.out.println("Students for both football and badminton are 0 []");
            }
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
                System.out.println("8. Enter name to see what sports he/she participates.");
                System.out.println("9. Display all inputs");
                System.out.println("10. Exit");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Enter your choice: ");
                Scanner scanner1= new Scanner(System.in);
                choice = scanner1.nextInt();
                switch (choice) {
                    case 0:
                        assign = new Task1();
                        assign.getSeStudents();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.getBadmintonPlayers();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.getCricketPlayers();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.getFootballPlayers();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.commonPlayersForCricketAndFootball();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.commonPlayersForCricketAndBadminton();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.commonPlayersForFootballAndBadminton();
                        // System.out.println("--------------------------------------------------------------------------");
                        assign.describeElement();
                        break;                
                    case 1:
                        assign2.setSeStudents();
                        break;
                    case 2:
                        if(assign2.isSeStudentsInput) {
                            assign2.setBadmintonPlayers();
                        } else {
                            System.out.println("Cannot add as there is no student data ");
                        }
                        break;
                    case 3:
                        if(assign2.isSeStudentsInput) {
                            assign2.setCricketPlayers();
                        } else {
                            System.out.println("Cannot add as there is no student data ");
                        }
                        break;
                    case 4:
                        if(assign2.isSeStudentsInput) {
                            assign2.setFootballPlayers();
                        } else {
                            System.out.println("Cannot add as there is no student data ");
                        }
                        break;
                    case 5:
                        if (assign2.isSeStudentsInput && (assign2.isCricketPlayersInput && assign2.isFootballPlayersInput)){
                            assign2.commonPlayersForCricketAndFootball();
                        } else {
                            System.out.println("Data not found");
                        } 
                        
                        break;
                    case 6:
                        if (assign2.isSeStudentsInput && (assign2.isCricketPlayersInput && assign2.isBadmintonPlayersInput)){
                            assign2.commonPlayersForCricketAndBadminton();
                        } else {
                            System.out.println("Data not found");
                        }
                        break;
                    case 7:
                        if (assign2.isSeStudentsInput && (assign2.isBadmintonPlayersInput && assign2.isFootballPlayersInput)){
                            assign2.commonPlayersForFootballAndBadminton();
                        } else {
                            System.out.println("Data not found");
                        }
                        break;
                    case 8:
                        // if(assign2.isSeStudentsInput) {
                            assign2.describeElement();
                        // } else {
                            // System.out.println("Enter student data first");
                        // }
                        break;
                    case 9:
                        assign2.displayInput();
                        break;
                    case 10:
                        System.out.println("Exiting the program");
                        scanner1.close();
                        return ;
                    default:
                        System.out.println("Invalid Input.");
                }
            } 
        }
    }
