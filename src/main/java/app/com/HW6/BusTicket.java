package app.com.HW6;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Bus ticket with various attributes.
 */
class BusTicket {
    private String concertHall;
    private int eventCode;
    private LocalDate date;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private BigDecimal price;

    // Constructor
    public BusTicket(String concertHall, int eventCode, LocalDate date, boolean isPromo,
                     char stadiumSector, double maxBackpackWeight, BigDecimal price) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.date = date;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxBackpackWeight = maxBackpackWeight;
        this.price = price;
    }

    // Getters and setters for each field
    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        this.concertHall = concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
