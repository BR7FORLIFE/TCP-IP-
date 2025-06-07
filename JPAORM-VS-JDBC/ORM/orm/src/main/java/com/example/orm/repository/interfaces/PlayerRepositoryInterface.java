package com.example.orm.repository.interfaces;

import java.util.List;

import com.example.orm.models.Player;

public interface PlayerRepositoryInterface {
    List<Player> findAll();
    Player findById(int id);
    void savePlayer(Player player);
    void deletePlayer(int id);
}
