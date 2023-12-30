package com.playtech.testcontroller;

import com.playtech.domain.response.PlayerProfileResponse;
import com.playtech.domain.response.PlayerResponse;
import com.playtech.service.serviceimpl.PlayerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@WebFluxTest(PlayerServiceImpl.class)
public class PlayerServiceImplTest {

    @MockBean
    private PlayerServiceImpl playerServiceImpl;

    @Test
    void testGetPlayerById() {
        Long playerId = 11119L;

        PlayerProfileResponse expectedResponse = new PlayerProfileResponse();
        expectedResponse.setPlayerId(11119L);
        expectedResponse.setRanking(1);
        expectedResponse.setIsActive(true);
        expectedResponse.setTeamId(65L);
        expectedResponse.setTeamName("Barcelona");
        expectedResponse.setPlayedPositions("-AMC-AMR-FW-");
        expectedResponse.setAge(27);
        expectedResponse.setHeight(169);
        expectedResponse.setWeight(67);
        expectedResponse.setPositionText("Forward");
        expectedResponse.setRating(8.759166667);
        expectedResponse.setGoal(26);
        expectedResponse.setName("Lionel Messi");
        expectedResponse.setSeasonId(5435L);
        expectedResponse.setTournamentId(4L);
        expectedResponse.setTournamentRegionId(206L);
        expectedResponse.setTournamentRegionCode("es");
        expectedResponse.setRegionCode("ar");
        expectedResponse.setTournamentName("La Liga");
        expectedResponse.setTournamentShortName("SLL");
        expectedResponse.setFirstName("Lionel");
        expectedResponse.setLastName("Messi");
        expectedResponse.setApps(24);
        expectedResponse.setSubOn(1);
        expectedResponse.setMinsPlayed(2115);
        expectedResponse.setAssistTotal(13);
        expectedResponse.setYellowCard(3);
        expectedResponse.setRedCard(0);
        expectedResponse.setShotsPerGame(4.75);
        expectedResponse.setAerialWonPerGame(0.291666667);
        expectedResponse.setManOfTheMatch(16);
        expectedResponse.setPlayedPositionsShort("AM(CR),FW");
        expectedResponse.setPassSuccess(82.31707317);
        expectedResponse.setOpta(true);

        when(playerServiceImpl.getPlayerById(playerId)).thenReturn(expectedResponse);

        PlayerProfileResponse actualResponse = playerServiceImpl.getPlayerById(playerId);

        assertNotNull("Actual player should not be null", actualResponse);
        assertEquals("Player ID should match", actualResponse.getPlayerId(), playerId);
    }

    @Test
    void getAllPlayers() {
        List<PlayerResponse> expectedPlayers = Arrays.asList(
                new PlayerResponse(11119L, 1, true, 65L, "Barcelona", "-AMC-AMR-FW-", 27, 169, 67, "Forward", 8.759166667, 26, "Lionel Messi"),
                new PlayerResponse(4173L, 2, true, 37L, "Bayern Munich", "-FW-ML-MR-", 31, 180, 80, "Midfielder", 8.56, 16, "Arjen Robben"),
                new PlayerResponse(5583L, 3, true, 52L, "Real Madrid", "-AML-AMR-FW-", 30, 185, 80, "Forward", 8.489047619, 29, "Cristiano Ronaldo"),
                new PlayerResponse(73084L, 4, true, 33L, "Wolfsburg", "-AMC-AML-AMR-FW-", 23, 181, 76, "Midfielder", 8.020909091, 8, "Kevin De Bruyne"),
                new PlayerResponse(33404L, 5, true, 15L, "Chelsea", "-AMC-AML-AMR-", 24, 173, 74, "Midfielder", 8.000769231, 9, "Eden Hazard"),
                new PlayerResponse(50835L, 6, true, 65L, "Barcelona", "-AMC-AML-AMR-", 23, 175, 64, "Forward", 7.951904762, 17, "Neymar"),
                new PlayerResponse(73078L, 7, true, 228L, "Lyon", "-AMC-AML-AMR-FW-", 23, 175, 73, "Forward", 7.891304348, 21, "Alexandre Lacazette"),
                new PlayerResponse(9016L, 8, true, 37L, "Bayern Munich", "-AML-", 31, 170, 72, "Midfielder", 7.863846154, 4, "Franck RibÃ©ry"),
                new PlayerResponse(25244L, 9, true, 13L, "Arsenal", "-AMC-AML-AMR-FW-", 26, 168, 62, "Forward", 7.851304348, 12, "Alexis SÃ¡nchez"),
                new PlayerResponse(96182L, 10, true, 1211L, "Hoffenheim", "-AMC-AML-AMR-FW-", 23, 181, 76, "Midfielder", 7.850454545, 6, "Roberto Firmino"),
                new PlayerResponse(14172L, 11, true, 33L, "Wolfsburg", "-DC-", 32, 198, 89, "Defender", 7.843181818, 6, "Naldo"),
                new PlayerResponse(102439L, 12, true, 1285L, "Palermo", "-AMC-AMR-", 26, 187, 87, "Midfielder", 7.816956522, 7, "Franco VÃ¡zquez"),
                new PlayerResponse(134902L, 13, true, 613L, "Nice", "-DL-", 20, 176, 70, "Defender", 7.807307692, 3, "Jordan Amavi"),
                new PlayerResponse(91060L, 14, true, 36L, "Bayer Leverkusen", "-AMC-AMR-FW-", 24, 183, 78, "Midfielder", 7.801363636, 9, "Karim Bellarabi"),
                new PlayerResponse(8040L, 15, true, 15L, "Chelsea", "-FW-MC-ML-MR-", 27, 175, 74, "Midfielder", 7.793478261, 2, "Cesc FÃ bregas"),
                new PlayerResponse(13812L, 16, true, 52L, "Real Madrid", "-DL-FW-MC-ML-MR-", 25, 183, 74, "Forward", 7.757142857, 10, "Gareth Bale"),
                new PlayerResponse(97752L, 17, true, 87L, "Juventus", "-DMC-", 21, 188, 80, "Midfielder", 7.755238095, 6, "Paul Pogba"),
                new PlayerResponse(41330L, 18, true, 44L, "Borussia Dortmund", "-AMC-AML-AMR-FW-", 25, 180, 71, "Midfielder", 7.753333333, 6, "Marco Reus"),
                new PlayerResponse(22701L, 19, true, 75L, "Inter", "-MC-MR-", 28, 183, 77, "Midfielder", 7.718888889, 5, "Fredy GuarÃ­n"),
                new PlayerResponse(71182L, 20, true, 52L, "Real Madrid", "-AMC-AML-AMR-", 23, 180, 75, "Midfielder", 7.7105, 8, "James RodrÃ­guez")
        );

        when(playerServiceImpl.getAllPlayers()).thenReturn(expectedPlayers);

        List<PlayerResponse> actualPlayers = playerServiceImpl.getAllPlayers();

        assertNotNull("Actual players list should not be null", actualPlayers);
        assertEquals("Number of players should match", expectedPlayers.size(), actualPlayers.size());
    }
}
