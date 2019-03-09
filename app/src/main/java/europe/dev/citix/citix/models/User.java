package europe.dev.citix.citix.models;

import europe.dev.citix.citix.api.models.GetUser;

public class User extends GetUser {

    public User(GetUser getUser) {
        super(getUser.getFirstName(),
                getUser.getLastName(),
                getUser.getPhone(),
                getUser.getAddresses(),
                getUser.getRating(),
                getUser.getId(),
                getUser.getEmail(),
                getUser.getPhotoUrls()
        );
    }
}
