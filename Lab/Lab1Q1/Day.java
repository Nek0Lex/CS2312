package Lab1Q1;

public class Day {
    private int year,month,day;

    public Day(int y, int m, int d) {
        this.year=y;
        this.month=m;
        this.day=d;
    }

    public String toString() {
        final String[] MonthNames = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        return day+" "+ MonthNames[month-1] + " "+ year;
    }

    static public boolean isLeapYear(int y)
    {
        if (y%400==0)
            return true;
        else if (y%100==0)
            return false;
        else if (y%4==0)
            return true;
        else
            return false;
    }

    static public boolean valid(int y, int m, int d)
    {
        if (m<1 || m>12 || d<1) return false;
        switch(m){
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return d<=31;
            case 4: case 6: case 9: case 11:
                return d<=30;
            case 2:
                if (isLeapYear(y))
                    return d<=29;
                else
                    return d<=28;
        }
        return false;
    }

}
