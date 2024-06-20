package ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub;


import jakarta.validation.constraints.NotNull;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.DescriptionVO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.TitleVO;

public record DescriptionDTO(
        @NotNull TitleVO title,
        @NotNull DescriptionVO description
        ) {
}
