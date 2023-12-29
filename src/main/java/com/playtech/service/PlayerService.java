package com.playtech.service;

import com.playtech.domain.Player;
import com.playtech.domain.response.PlayerProfileResponse;
import com.playtech.domain.response.PlayerResponse;

import java.util.List;

public interface PlayerService {
    void saveAllPlayers(List<Player> players);
    List<PlayerResponse> getAllPlayers();
    PlayerProfileResponse getPlayerById(Long playerId);
}
