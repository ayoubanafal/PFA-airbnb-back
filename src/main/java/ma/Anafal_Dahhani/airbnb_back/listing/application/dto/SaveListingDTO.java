package ma.Anafal_Dahhani.airbnb_back.listing.application.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub.DescriptionDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub.ListingInfoDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub.PictureDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.vo.PriceVO;
import ma.Anafal_Dahhani.airbnb_back.listing.domain.BookingCategory;

import java.util.List;

public class SaveListingDTO {

    @NotNull
    BookingCategory category;

    @NotNull String location;

    @NotNull @Valid
    ListingInfoDTO infos;

    @NotNull @Valid
    DescriptionDTO description;

    @NotNull @Valid
    PriceVO price;

    @NotNull
    List<PictureDTO> pictures;

    public BookingCategory getCategory() {
        return category;
    }

    public void setCategory(BookingCategory category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ListingInfoDTO getInfos() {
        return infos;
    }

    public void setInfos(ListingInfoDTO infos) {
        this.infos = infos;
    }

    public DescriptionDTO getDescription() {
        return description;
    }

    public void setDescription(DescriptionDTO description) {
        this.description = description;
    }

    public PriceVO getPrice() {
        return price;
    }

    public void setPrice(PriceVO price) {
        this.price = price;
    }

    public List<PictureDTO> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureDTO> pictures) {
        this.pictures = pictures;
    }
}
