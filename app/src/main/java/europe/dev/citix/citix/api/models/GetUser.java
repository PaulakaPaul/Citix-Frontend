package europe.dev.citix.citix.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUser extends PostUser {
    private int id;
    private String email;

    @SerializedName("photo_urls")
    private List<String> photoUrls;

    public GetUser(String firstName, String lastName, String phone, List<Address> addresses,
                   Rating rating, int id, String email, List<String> photoUrls) {
        super(firstName, lastName, phone, addresses, rating);
        this.id = id;
        this.email = email;
        this.photoUrls = photoUrls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
}
