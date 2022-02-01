import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CLS {
    public static void main(String[] args) throws ParseException {

        // Task 3. Создать класс Календарь с внутреним классом, с помощью объектов которого можно хранить
        // информацию о выходных и праздничных днях

        CalendarDays calendarDays = new CalendarDays();
        calendarDays.enterDate();
        calendarDays.printDate();
    }
}

class CalendarDays {
    private Calendar calendar;
    private final SimpleDateFormat simpleDateFormat;
    private Date date;
    public String[] arrayString;
    private String string;
    private DayOff dayOff;
    private int day;
    private int month;
    private int year;

    public CalendarDays() {
        this.simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.EEEE");
    }

    public void enterDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day: ");
        this.day = scanner.nextInt();
        System.out.println("Enter month: ");
        this.month = scanner.nextInt();
        this.month = (month-1);
        System.out.println("Enter year: ");
        this.year = scanner.nextInt();
        string = String.valueOf(this.day);

        this.calendar = new GregorianCalendar(getYear(),getMonth(),getDay());
        this.date = new Date();
        this.arrayString = simpleDateFormat.format(calendar.getTime()).split("\\.");
    }

    public void printDate() {
        this.dayOff = new DayOff();

        dayOff.weekendCheck(arrayString);
        dayOff.holidayCheck(arrayString);
    }

    public String[] getArrayString() {
        return arrayString;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    static class DayOff extends CalendarDays {
        public void weekendCheck(String[] arrayString) {

            if (Objects.equals(arrayString[0], "01") || Objects.equals(arrayString[0], "02")) {
                if (Objects.equals(arrayString[1], "01")) {
                    System.out.println("January 1 and 2 - New Year");
                }
            }
            if (Objects.equals(arrayString[0], "07")) {
                if (Objects.equals(arrayString[1], "01")) {
                    System.out.println("January 7 - Christmas (Orthodox Christmas)");
                }
            }
            if (Objects.equals(arrayString[0], "08")) {
                if (Objects.equals(arrayString[1], "03")) {
                    System.out.println("March 8 - Women's Day");
                }
            }
            if (Objects.equals(arrayString[0], "01")) {
                if (Objects.equals(arrayString[1], "05")) {
                    System.out.println("May 1 - Labor Day");
                }
            }
            if (Objects.equals(arrayString[0], "03")) {
                if (Objects.equals(arrayString[1], "05")) {
                    System.out.println("May 3 - Radunitsa");
                }
            }
            if (Objects.equals(arrayString[0], "09")) {
                if (Objects.equals(arrayString[1], "05")) {
                    System.out.println("May 9 - Victory Day");
                }
            }
            if (Objects.equals(arrayString[0], "03")) {
                if (Objects.equals(arrayString[1], "07")) {
                    System.out.println("July 3 - Independence Day of the Republic of Belarus");
                }
            }
            if (Objects.equals(arrayString[0], "07")) {
                if (Objects.equals(arrayString[1], "11")) {
                    System.out.println("November 7 - October Revolution Day");
                }
            }
            if (Objects.equals(arrayString[0], "25")) {
                if (Objects.equals(arrayString[1], "12")) {
                    System.out.println("December 25 - Christmas (Catholic Christmas)");
                }
            }
        }

        public void holidayCheck(String[] arrayString) {
            if (Objects.equals(arrayString[3], "суббота")) {
                System.out.println("It's a holiday! Sunday");
            }
            if (Objects.equals(arrayString[3], "воскресенье")) {
                System.out.println("It's a holiday! Saturday");
            }
        }
    }
}