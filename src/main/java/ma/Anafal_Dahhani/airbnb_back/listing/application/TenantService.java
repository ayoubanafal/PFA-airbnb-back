package ma.Anafal_Dahhani.airbnb_back.listing.application;

import org.springframework.transaction.annotation.Transactional;
import ma.Anafal_Dahhani.airbnb_back.booking.application.BookingService;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.DisplayCardListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.DisplayListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.sub.LandlordListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.domain.BookingCategory;
import ma.Anafal_Dahhani.airbnb_back.listing.domain.Listing;
import ma.Anafal_Dahhani.airbnb_back.listing.mapper.ListingMapper;
import ma.Anafal_Dahhani.airbnb_back.listing.repository.ListingRepository;
import ma.Anafal_Dahhani.airbnb_back.sharedKernel.service.State;
import ma.Anafal_Dahhani.airbnb_back.user.application.UserService;
import ma.Anafal_Dahhani.airbnb_back.user.application.dto.ReadUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TenantService {
    private final ListingRepository listingRepository;

    private final ListingMapper listingMapper;

    private final UserService userService;


    public TenantService(ListingRepository listingRepository, ListingMapper listingMapper, UserService userService, BookingService bookingService) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
        this.userService = userService;

    }
    public Page<DisplayCardListingDTO> getAllByCategory(Pageable pageable, BookingCategory category) {
        Page<Listing> allOrBookingCategory;
        if (category == BookingCategory.ALL) {
            allOrBookingCategory = listingRepository.findAllWithCoverOnly(pageable);
        } else {
            allOrBookingCategory = listingRepository.findAllByBookingCategoryWithCoverOnly(pageable, category);
        }

        return allOrBookingCategory.map(listingMapper::listingToDisplayCardListingDTO);
    }
    @Transactional(readOnly = true)
    public State<DisplayListingDTO, String> getOne(UUID publicId) {
        Optional<Listing> listingByPublicIdOpt = listingRepository.findByPublicId(publicId);

        if (listingByPublicIdOpt.isEmpty()) {
            return State.<DisplayListingDTO, String>builder()
                    .forError(String.format("Listing doesn't exist for publicId: %s", publicId));
        }

        DisplayListingDTO displayListingDTO = listingMapper.listingToDisplayListingDTO(listingByPublicIdOpt.get());

        ReadUserDTO readUserDTO = userService.getByPublicId(listingByPublicIdOpt.get().getLandlordPublicId()).orElseThrow();
        LandlordListingDTO landlordListingDTO = new LandlordListingDTO(readUserDTO.firstName(), readUserDTO.imageUrl());
        displayListingDTO.setLandlord(landlordListingDTO);

        return State.<DisplayListingDTO, String>builder().forSuccess(displayListingDTO);
    }
}
