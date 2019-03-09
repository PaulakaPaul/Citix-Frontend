package europe.dev.citix.citix.models;

import java.util.List;

import europe.dev.citix.citix.api.models.Address;
import europe.dev.citix.citix.api.models.GetUser;
import europe.dev.citix.citix.api.models.Rating;

public class User extends GetUser {
    public User(String firstName, String lastName, String phone, List<Address> addresses, Rating rating, int id, String email, List<String> photoUrls) {
        super(firstName, lastName, phone, addresses, rating, id, email, photoUrls);
    }
}
