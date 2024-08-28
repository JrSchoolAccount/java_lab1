package lab1;

public class Price {
    private final String hour;
    private final int price;


    Price(int price, String hour) {
        this.hour = hour;
        this.price = price;
    }

    int getPrice() {return price;}
    String getHour() {return hour;}
}
