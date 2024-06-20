package ma.Anafal_Dahhani.airbnb_back.listing.application;

import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.CreatedListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.SaveListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.domain.Listing;
import ma.Anafal_Dahhani.airbnb_back.listing.mapper.ListingMapper;
import ma.Anafal_Dahhani.airbnb_back.listing.repository.ListingRepository;
import ma.Anafal_Dahhani.airbnb_back.user.application.Auth0Service;
import ma.Anafal_Dahhani.airbnb_back.user.application.UserService;
import ma.Anafal_Dahhani.airbnb_back.user.application.dto.ReadUserDTO;
import org.springframework.stereotype.Service;

@Service
public class LandlordService {
    private final ListingRepository listingRepository;

    private final ListingMapper listingMapper;
    private final UserService userService;
    private final Auth0Service auth0Service;
    private final PictureService pictureService;

    public LandlordService(ListingRepository listingRepository, ListingMapper listingMapper, UserService userService, Auth0Service auth0Service, PictureService pictureService) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
        this.userService = userService;
        this.auth0Service = auth0Service;
        this.pictureService = pictureService;
    }
    public CreatedListingDTO create(SaveListingDTO saveListingDTO) {
        Listing newListing = listingMapper.saveListingDTOToListing(saveListingDTO);

        ReadUserDTO userConnected = userService.getAuthenticatedUserFromSecurityContext();
        newListing.setLandlordPublicId(userConnected.publicId());

        Listing savedListing = listingRepository.saveAndFlush(newListing);

        pictureService.saveAll(saveListingDTO.getPictures(),savedListing);

        auth0Service.addLandlordRoleToUser(userConnected);

        return listingMapper.listingToCreatedListingDTO(savedListing);
    }

}
