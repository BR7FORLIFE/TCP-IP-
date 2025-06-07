package com.example.orm.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.orm.models.Player;
import com.example.orm.repository.interfaces.PlayerRepositoryInterface;

@Repository
public class PlayerRepositoryImp implements PlayerRepositoryInterface {

    // class for do querys
    private final JdbcTemplate jdbcTemplate;

    public PlayerRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // result set -> rs
    private static final RowMapper<Player> playerRowMapper = (rs, rowInt) -> {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setName(rs.getString("name"));
        player.setLastname(rs.getString("lastname"));
        player.setAge(rs.getInt("age"));
        player.setPosition(rs.getString("position"));
        player.setExperience(rs.getFloat("experience"));
        player.setTeam(rs.getString("team"));
        return player;
    };

    @Override
    public List<Player> findAll() {
        String query = "SELECT id, name, lastname, age, position, experience, team FROM player";
        List<Player> players = jdbcTemplate.query(query, playerRowMapper);
        return players;
    }

    @Override
    public Player findById(int id) {
        String query = "SELECT id, nombre, lastname, age, position, experience, team FROM player WHERE id = ?";

        try {
            Player player = jdbcTemplate.queryForObject(query, playerRowMapper, id);
            return player;

        } catch (DataAccessException e) {
            System.out.println("No se encuentra dicho jugador con la id: " + id);
        }
        return null;
    }

    @Override
    public void savePlayer(Player player) {
        String query = "INSERT INTO player (id, name, lastname, age, position, experience, team) VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(query, player.getId(), player.getName(), player.getLastname(), player.getAge(),
                player.getPosition(),
                player.getExperience(), player.getTeam());
    }

    @Override
    public void deletePlayer(int id) {
        String query = "DELETE FROM player WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
