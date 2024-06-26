package app.com.HW6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for bus ticket.
 */
public class BusTicketService {

    private List<BusTicket> tickets = new ArrayList<>();

    /**
     * Creates a new bus ticket and adds it to the in memory storage.
     */
    public void createBusTicket(String concertHall, int eventCode, LocalDate date, boolean isPromo,
                                char stadiumSector, double maxBackpackWeight, BigDecimal price) {
        BusTicket ticket = new BusTicket(concertHall, eventCode, date, isPromo, stadiumSector, maxBackpackWeight, price);
        tickets.add(ticket);
    }

    /**
     * Stores the specified bus ticket in the in-memory storage.
     */
    public void storeTicket(BusTicket ticket) {
        tickets.add(ticket);
    }

    /**
     * Removes a bus ticket from the storage by its ID (event code).
     */
    public void removeTicket(int eventCode) {
        tickets.removeIf(ticket -> ticket.getEventCode() == eventCode);
    }

    /**
     * Retrieves a bus ticket by its ID (event code).
     */
    public Optional<BusTicket> getTicketById(int eventCode) {
        return tickets.stream()
                .filter(ticket -> ticket.getEventCode() == eventCode)
                .findFirst();
    }

    /**
     * Searches for bus tickets by type (isPromo) and price range.
     * @param isPromo the type of the ticket (promo or not)
     * @param priceA  the minimum price
     * @param priceB  the maximum price
     * @return the list of bus tickets matching the specified criteria
     */
    public List<BusTicket> searchTickets(boolean isPromo, BigDecimal priceA, BigDecimal priceB) {
        return tickets.stream()
                .filter(ticket -> ticket.isPromo() == isPromo && ticket.getPrice().compareTo(priceA) >= 0 && ticket.getPrice().compareTo(priceB) <= 0)
                .collect(Collectors.toList());
    }

    // Example usage, just for test
    public static void main(String[] args) {
        BusTicketService service = new BusTicketService();

        // Create and store tickets
        service.createBusTicket("Hall A", 101, LocalDate.of(2024, 6, 1), true, 'A', 5.0, new BigDecimal("50.00"));
        service.createBusTicket("Hall B", 102, LocalDate.of(2024, 6, 2), false, 'B', 7.0, new BigDecimal("75.00"));

        // Get a ticket by ID
        Optional<BusTicket> ticket = service.getTicketById(101);
        ticket.ifPresent(t -> System.out.println("Found ticket: " + t.getConcertHall()));

        // Search tickets by type and price
        List<BusTicket> promoTickets = service.searchTickets(true, new BigDecimal("40.00"), new BigDecimal("60.00"));
        promoTickets.forEach(t -> System.out.println("Promo ticket: " + t.getConcertHall()));

        // Remove a ticket
        service.removeTicket(101);
    }
}
