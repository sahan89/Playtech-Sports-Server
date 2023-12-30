package com.playtech.testcontroller;

import com.playtech.controller.PlayerController;
import com.playtech.domain.response.PlayerProfileResponse;
import com.playtech.domain.response.PlayerResponse;
import com.playtech.exceptiondomain.DataNotFoundException;
import com.playtech.exceptiondomain.constant.ExceptionConstant;
import com.playtech.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@WebFluxTest(PlayerController.class)
public class PlayerControllerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PlayerService playerService;

    @Test
    public void testGetPlayerByCorrectId() {
        logger.info("-- ENTER -- testGetPlayerByCorrectId --");

        Long playerId = 5583L;
        PlayerProfileResponse mockPlayerProfile = new PlayerProfileResponse();
        mockPlayerProfile.setPlayerId(5583L);
        mockPlayerProfile.setFirstName("Cristiano");
        mockPlayerProfile.setLastName("Ronaldo");
        mockPlayerProfile.setTeamName("teamName");

        when(playerService.getPlayerById(eq(playerId))).thenReturn(mockPlayerProfile);
        webTestClient.get()
                .uri("/api/player/{playerId}", playerId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(PlayerProfileResponse.class)
                .isEqualTo(mockPlayerProfile);
    }

    @Test
    public void testGetPlayerByIncorrectId() {
        logger.info("-- ENTER -- testGetPlayerByIncorrectId --");

        Long playerId = 1234L;

        Mockito.when(playerService.getPlayerById(Mockito.eq(playerId)))
                .thenThrow(new DataNotFoundException(ExceptionConstant.PLAYER_NOT_FOUND));

        webTestClient.get()
                .uri("/api/player/{playerId}", playerId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(PlayerProfileResponse.class)
                .isEqualTo(new PlayerProfileResponse());
    }

    @Test
    public void testGetAllPlayers() {
        logger.info("-- ENTER -- testGetAllPlayers --");

        List<PlayerResponse> mockPlayers = Arrays.asList(
                new PlayerResponse(11119L, 1, true, 65L, "Barcelona", "-AMC-AMR-FW-", 27, 169, 67, "Forward", 8.759166667, 26, "Lionel Messi"),
                new PlayerResponse(4173L, 2, true, 37L, "Bayern Munich", "-FW-ML-MR-", 31, 180, 80, "Midfielder", 8.56, 16, "Arjen Robben"),
                new PlayerResponse(5583L, 3, true, 52L, "Real Madrid", "-AML-AMR-FW-", 30, 185, 80, "Forward", 8.489047619, 29, "Cristiano Ronaldo")
        );

        when(playerService.getAllPlayers()).thenReturn(mockPlayers);

        webTestClient.get()
                .uri("/api/players")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PlayerResponse.class)
                .isEqualTo(mockPlayers);
    }

    @Test
    public void testGetAllPlayersEmpty() {
        logger.info("-- ENTER -- testGetAllPlayersEmpty --");

        List<PlayerResponse> mockPlayers = List.of();

        when(playerService.getAllPlayers()).thenReturn(mockPlayers);

        webTestClient.get()
                .uri("/api/players")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(PlayerResponse.class)
                .isEqualTo(mockPlayers);
    }
}
