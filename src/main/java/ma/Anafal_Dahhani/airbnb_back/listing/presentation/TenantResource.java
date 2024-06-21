package ma.Anafal_Dahhani.airbnb_back.listing.presentation;


import ma.Anafal_Dahhani.airbnb_back.listing.application.TenantService;
import ma.Anafal_Dahhani.airbnb_back.listing.application.dto.DisplayCardListingDTO;
import ma.Anafal_Dahhani.airbnb_back.listing.domain.BookingCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenant-listing")
public class TenantResource {
    private final TenantService tenantService;


    public TenantResource(TenantService tenantService) {
        this.tenantService = tenantService;
    }
    @GetMapping("/get-all-by-category")
    public ResponseEntity<Page<DisplayCardListingDTO>> findAllByBookingCategory(Pageable pageable,
                                                                                @RequestParam BookingCategory category) {
        return ResponseEntity.ok(tenantService.getAllByCategory(pageable, category));
    }
}
