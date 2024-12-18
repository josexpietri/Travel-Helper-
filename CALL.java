package travelAPI;

import java.util.*;
import java.util.stream.Collectors;


public class CALL {

// Replace with your Yelp API Key

    private static final String ACCESS_TOKEN = "YOUR_FACEBOOK_ACCESS_TOKEN";
    private static final String GRAPH_API_URL = "https://graph.facebook.com/v19.0/search";

    private static final String API_KEY = "YOUR_GOOGLE_API_KEY";
    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    private static final String API_KEY = "YOUR_YELP_API_KEY"; 
    private static final String YELP_API_URL = "https://api.yelp.com/v3/businesses/search";

    private static final String API_KEY = "YOUR_TRIPADVISOR_API_KEY"; 
    private static final String TRIPADVISOR_API_URL = "https://tripadvisor16.p.rapidapi.com/api/v1/UserTerm/searchUserTerms";

    private static final String API_KEY = "YOUR_ANGI_API_KEY";
    private static final String ANGI_API_URL = "https://api.angi.com/v1/businesses/search";


    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        // Original UserTerm map
        Map<String, UserTerm> UserTermMap = new HashMap<>();

        //MAKE USER INPUT 
        String latitude = "37.7749";  // Example: San Francisco -- if app it can access the location of the user 
        String longitude = "-122.4194";

        System.out.print("Enter radius (miles) : ");
        int radius = s1.nextInt();
        System.out.println();

        System.out.println("Enter term : ");
        System.out.println("retaruant");
        System.out.println("hotel");
        System.out.println("parks");
        System.out.println("bars");

        string term  = s1.next();

        //---------------------------------------------------------------------------


        //YELP
        fetchData(latitude, longitude, radius, term, UserTermMap, YELP_API_URL);
        //TripAdvisor
        fetchData(latitude, longitude, radius, term, UserTermMap, TRIPADVISOR_API_URL);
        //Google 
        fetchData(latitude, longitude, radius, term, UserTermMap, GOOGLE_API_URL);
        //Facebook
        fetchData(latitude, longitude, radius, term, UserTermMap, GRAPH_API_URL);
        //Angi
        fetchData(latitude, longitude, radius, term, UserTermMap, ANGI_API_URL);

        //-----------------------------------------------------------------------------

        // Find top 10 
        List<UserTerm> top10o = findTop10(UserTermMap);

        // Print the top 10 
        System.out.println("Top 10 " + term + " by Average Rating:");
        for (int i = 0; i < top10o.size(); i++) {
            UserTerm r = top10o.get(i);
            System.out.printf("%d. %s | Avg Rating: %.2f | Address: %s\n",
                    i + 1, r.name, r.averageRating, r.address);
        }
    }

    // Method to find the top 10 UserTerms by average rating
    public static List<UserTerm> findTop10(Map<String, UserTerm> UserTermMap) {
        return UserTermMap.values().stream()
                .sorted((r1, r2) -> Double.compare(r2.averageRating, r1.averageRating)) // Sort in descending order
                .limit(10) // Take the top 10
                .collect(Collectors.toList()); // Collect into a list
    }
}

