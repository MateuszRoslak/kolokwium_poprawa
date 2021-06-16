package edu.iis.mto.testreactor.reservation;

import edu.iis.mto.testreactor.money.Money;
import edu.iis.mto.testreactor.offer.DiscountPolicy;
import edu.iis.mto.testreactor.offer.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ReservationTest {

    @Mock
    public DiscountPolicy discountPolicy;

    private Reservation reservation;
    private Id id;
    private Reservation.ReservationStatus status;
    private ClientData clientData;
    private Date createDate;

    @BeforeEach
    void setup(){
        id = new Id("7");
        clientData = new ClientData(id, "John");
        status = Reservation.ReservationStatus.OPENED;
        createDate = new Date();
        reservation = new Reservation(id, status, clientData, createDate);
    }
    @Test
    public void itCompiles(){
        assertEquals(1,1);
    }

    @Test
    public void happyPath(){
        Offer offer = reservation.calculateOffer(discountPolicy);

    }

    @Test
    public void itShouldReturnsEmptyOfferWhenNoItemsGiven(){
        Offer offer = reservation.calculateOffer(discountPolicy);
        Offer emptyOffer = new Offer(new ArrayList<>(), new ArrayList<>());
        assertEquals(emptyOffer, offer);
    }

    @Test
    public void itShouldThrowErrorWhenTryingToAddProductToClosedReservation(){
        reservation = new Reservation(id, Reservation.ReservationStatus.CLOSED, clientData, createDate);
        Money money = new Money( new BigDecimal("9.99"));
        Product product = new Product(new Id("33"), money, "exampleName", ProductType.DRUG);
        assertThrows(DomainOperationException.class, () -> reservation.add(product, 5));
    }

    @Test
    public void itShouldThrowErrorWhenAddedProductIsNotAvailable(){}

    @Test
    public void itShouldThrowErrorWhenTryingToCloseAlreadyClosedReservation(){
        reservation = new Reservation(id, Reservation.ReservationStatus.CLOSED, clientData, createDate);
        assertThrows(DomainOperationException.class, () -> reservation.close());
    }

    @Test
    public void itShouldSetAllReservationDataCorrectly(){
        assertEquals(clientData, reservation.getClientData());
        assertEquals(createDate, reservation.getCreateDate());
        assertEquals(new ArrayList<>(), reservation.getReservedProducts());
        assertEquals(Reservation.ReservationStatus.OPENED, reservation.getStatus());
    }

    @Test
    public void itShouldReturnReservationContainingGivenItem(){
        Money money = new Money( new BigDecimal("11.1"));
        Product product = new Product(new Id("33"), money, "exampleName", ProductType.DRUG);
        reservation.add(product, 5);
        assert(reservation.contains(product));
    }

    @Test
    public void itShouldReturnReservationContainingExactAmountOfGivenItem(){
        Money money = new Money( new BigDecimal("4.44"));
        Product product = new Product(new Id("44"), money, "exampleName", ProductType.STANDARD);
        reservation.add(product, 2);
        List<ReservedProduct> list =  reservation.getReservedProducts();
        assertEquals(2, list.get(0).getQuantity());
    }
}