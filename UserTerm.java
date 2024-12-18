package travelAPI;

public class UserTerm {
    String name;
    String address;
    double yelpRating;
    double tripAdvisorRating;
    //other rating apps 
    double goolge; 
    double angi;
    double facebook;
    //----------------------
    double averageRating;

    public UserTerm(String name, String address) {
        this.name = name;
        this.address = address;
        this.yelpRating = 0.0;
        this.tripAdvisorRating = 0.0;
        this.rate2 = 0.0;
        this.angi = 0.0;
        this.facebook = 0.0;
        this.averageRating = 0.0;
    }

    public void updateAverage() {
        this.averageRating = (this.yelpRating + this.tripAdvisorRating; + this.rate2 + this.angi + this.facebook )/5; // Update this logic once you include other APIs
    }
}
