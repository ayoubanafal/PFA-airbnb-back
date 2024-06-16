package ma.Anafal_Dahhani.airbnb_back.booking.repository;

import ma.Anafal_Dahhani.airbnb_back.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
