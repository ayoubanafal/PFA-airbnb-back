package ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub;

import jakarta.validation.constraints.NotNull;

public record LandlordListingDTO(@NotNull String firstname,
                                 @NotNull String imageUrl) {
}
