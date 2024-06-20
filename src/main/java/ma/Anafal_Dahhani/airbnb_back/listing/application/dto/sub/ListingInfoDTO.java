package ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.BathsVO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.BedroomsVO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.BedsVO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.GuestsVO;

public record ListingInfoDTO(
        @NotNull @Valid GuestsVO guests,
        @NotNull @Valid BedroomsVO bedrooms,
        @NotNull @Valid BedsVO beds,
        @NotNull @Valid BathsVO baths) {
}
