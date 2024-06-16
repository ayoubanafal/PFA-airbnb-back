package ma.Anafal_Dahhani.airbnb_back.listing.repository;

import ma.Anafal_Dahhani.airbnb_back.listing.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
