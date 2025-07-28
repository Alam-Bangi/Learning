
class Main {
    public static void main(String[] args) {
        int minutes = 901825;
        int hours;
        int days;
        int months;
        int years;
        hours = minutes/60;
        minutes = minutes%60;
        days = hours/24;
        months= days/30;
        years = months/12;
        if(days>0){
        hours = hours%24;
        }
        if(months>0) {
            days = days%30;
        }
        if(years>0) {
            months = months%12;
        }
        System.out.println("Years:" +years+ " Months:" +months+ " Days:"+days+" Hours:"+hours+ " Minutes:"+minutes);
    }
}