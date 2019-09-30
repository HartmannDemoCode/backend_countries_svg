package facades;

import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeTest {

    private static EntityManagerFactory emf;
    private static Facade facade = Facade.getFacadeExample(emf);

    public FacadeTest() {
    }

    
    @Test
    public void testAFacadeMethod() {
        String expected = "[{\"name\":\"Denmark\",\"topLevelDomain\":[\".dk\"],\"alpha2Code\":\"DK\",\"alpha3Code\":\"DNK\",\"callingCodes\":[\"45\"],\"capital\":\"Copenhagen\",\"altSpellings\":[\"DK\",\"Danmark\",\"Kingdom of Denmark\",\"Kongeriget Danmark\"],\"region\":\"Europe\",\"subregion\":\"Northern Europe\",\"population\":5678348,\"latlng\":[56.0,10.0],\"demonym\":\"Danish\",\"area\":43094.0,\"gini\":24.0,\"timezones\":[\"UTC-04:00\",\"UTC-03:00\",\"UTC-01:00\",\"UTC\",\"UTC+01:00\"],\"borders\":[\"DEU\"],\"nativeName\":\"Danmark\",\"numericCode\":\"208\",\"currencies\":[\"DKK\"],\"languages\":[\"da\"],\"translations\":{\"de\":\"Dänemark\",\"es\":\"Dinamarca\",\"fr\":\"Danemark\",\"ja\":\"デンマーク\",\"it\":\"Danimarca\"},\"relevance\":\"1.5\"}]";
        assertEquals(expected, facade.getCountryData("dk"), "Expects json data about Denmark");
    }

}
