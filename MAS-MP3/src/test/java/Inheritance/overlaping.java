package Inheritance;

import model.Competition;
import model.Offline;
import model.Online;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class overlaping {

    @Test
    public void testOfflineCompetitionCreation() {
        Competition competition = new Competition(LocalDate.now(), "Offline Competition", "123 Main St", 100);
        assertNotNull(competition);
        assertNotNull(competition.getOffline());
        assertNull(competition.getOnline());
    }

    @Test
    public void testOnlineCompetitionCreation() {
        Competition competition = new Competition(LocalDate.now(), "Online Competition", "https://example.com");
        assertNotNull(competition);
        assertNotNull(competition.getOnline());
        assertNull(competition.getOffline());
    }

    @Test
    public void testOfflineOnlineCompetitionCreation() {
        Competition competition = new Competition(LocalDate.now(), "Hybrid Competition", "123 Main St", 100, "https://example.com");
        assertNotNull(competition);
        assertNotNull(competition.getOnline());
        assertNotNull(competition.getOffline());
    }

    @Test
    public void testOfflineOnlineCompetitionCreationFail() {
        assertThrows(Exception.class, () -> {
            Competition competition = new Competition(LocalDate.now(), "Hybrid Competition", "123 Main St", -1, "https://example.com");
        });
    }




}


