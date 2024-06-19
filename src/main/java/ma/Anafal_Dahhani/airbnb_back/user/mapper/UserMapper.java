package ma.Anafal_Dahhani.airbnb_back.user.mapper;

import ma.Anafal_Dahhani.airbnb_back.user.application.dto.ReadUserDTO;
import ma.Anafal_Dahhani.airbnb_back.user.domain.Authority;
import ma.Anafal_Dahhani.airbnb_back.user.domain.User;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper {

    ReadUserDTO readUserDTOToUser(User user);

    default String mapAuthoritiesToString(Authority authority) {
        return authority.getName();
    }

}