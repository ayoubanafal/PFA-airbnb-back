package ma.Anafal_Dahhani.airbnb_back.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({"ma.Anafal_Dahhani.airbnb_back.user.repository",
                        "ma.Anafal_Dahhani.airbnb_back.listing.repository",
                        "ma.Anafal_Dahhani.airbnb_back.booking.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConfiguration {
}