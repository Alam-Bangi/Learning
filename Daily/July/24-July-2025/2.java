
class Main {
    public static void main(String[] args) {
        int money = 1;
        int double1=0;
        int day = 1;
        int valueCheck = 10;
        
        for (day=1; ; day++) {
            double1 = money + money;
            money = double1;
            if (double1>=valueCheck) {
                System.out.println(valueCheck + " rupees requires " +day+" days");
                 valueCheck = valueCheck * 10;
                if(valueCheck>10000000) {
                    break;
                }
            }
        }
    }
}