
class Main {
    public static void main(String[] args) {
        int minutes = 111825;
        int hours;
        int days;
        int months;
        hours = minutes/60;
        minutes = minutes%60;
        days = hours/24;
        months= days/30;
        if(days>0){
        hours = hours%24;
        }
        if(months>0) {
            days = days%30;
        }
        System.out.println("Months:" +months+ " Days:"+days+" Hours:"+hours+ " Minutes:"+minutes);
    }
}