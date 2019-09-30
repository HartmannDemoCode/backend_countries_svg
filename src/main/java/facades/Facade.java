package facades;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class Facade {

    private final String URL_STRING_COUNTRY = "http://restcountries.eu/rest/v1/alpha?codes=";
    private static Facade instance;
    private static EntityManagerFactory emf;

    private Facade() {
    }

    public static Facade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    public String getCountryData(String country) {
        String jsonStr = null;
        try {
            URL url = new URL(URL_STRING_COUNTRY + country);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            try (Scanner scan = new Scanner(con.getInputStream())) {
                jsonStr = null;
                if (scan.hasNext()) {
                    jsonStr = scan.nextLine();
                }
            }
            System.out.println(jsonStr);
        } catch (MalformedURLException | ProtocolException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jsonStr;
    }

    public static void main(String[] args) {
        new Facade().getCountryData("dk");
    }
}
