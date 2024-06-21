package ma.Anafal_Dahhani.airbnb_back.booking.application.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record BookedDateDTO (
        @NotNull OffsetDateTime startDate,
        @NotNull OffsetDateTime endDate
) {
}
