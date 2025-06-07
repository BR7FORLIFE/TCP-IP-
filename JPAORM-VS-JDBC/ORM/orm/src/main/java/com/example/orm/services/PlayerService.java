package com.example.orm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orm.models.Player;
import com.example.orm.repository.PlayerRepositoryImp;

@Service
public class PlayerService {
    private final PlayerRepositoryImp playerRepositoryImp;

    public PlayerService(PlayerRepositoryImp playerRepositoryImp1){
        this.playerRepositoryImp = playerRepositoryImp1;
    }

    public List<Player> getAllPlayers(){
        return playerRepositoryImp.findAll();
    }

    public Player getPlayerById(int id){
        return playerRepositoryImp.findById(id);
    }

    public void savePlayer(Player player){
        playerRepositoryImp.savePlayer(player);
    }

    public void deletePlayer(int id){
        playerRepositoryImp.deletePlayer(id);
    }
}
