import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MessageFinalTest {
    @Test
    public void testGetIDForGeneralCategory() {
        String myID = IDGenerator.getID(5, "GENERAL");
        assertEquals("1.4", myID);
    }

    @Test
    public void testGetIDForVolunteerCategory() {
        String myID = IDGenerator.getID(2, "VOLUNTEER");
        assertEquals("2.1", myID);
    }

    @Test
    public void testGetIDForNightlifeCategory() {
        String myID = IDGenerator.getID(10, "NIGHTLIFE");
        assertEquals("3.9", myID);
    }
    @Test
    public void testGetIDForTravelCategory() {
        String myID = IDGenerator.getID(7, "TRAVEL");
        assertEquals("4.6", myID);
    }
    @Test
    public void testGetIDForFoodCategory() {
        String myID = IDGenerator.getID(12, "FOOD");
        assertEquals("5.11", myID);
    }
    @Test
    public void testGetIDForUniversityCategory() {
        String myID = IDGenerator.getID(18, "UNIVERSITY");
        assertEquals("6.17", myID);
    }
}
   



