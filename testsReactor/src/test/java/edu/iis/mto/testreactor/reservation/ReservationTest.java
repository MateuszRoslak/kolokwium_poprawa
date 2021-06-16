package edu.iis.mto.testreactor.reservation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationTest {

    @Test
    public void itCompiles(){
        assertEquals(1,1);
    }

    @Test
    public void happyPath(){}

    @Test
    public void itShouldReturnsEmptyOfferWhenNoItemsGiven(){}

    @Test
    public void itShouldThrowErrorWhenTryingToAddProductToClosedReservation(){}

    @Test
    public void itShouldThrowErrorWhenAddedProductIsNotAvailable(){}

    @Test
    public void itShouldThrowErrorWhenTryingToCloseAlreadyClosedReservation(){}

    @Test
    public void itShouldSetAllReservationDataCorrectly(){};

    @Test
    public void itShouldReturnReservationContainingGivenItem(){};
}