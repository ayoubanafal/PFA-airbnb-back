package ma.Anafal_Dahhani.airbnb_back.listing.repository;

import ma.Anafal_Dahhani.airbnb_back.listing.domain.ListingPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingPictureRepository extends JpaRepository<ListingPicture, Long> {
}
