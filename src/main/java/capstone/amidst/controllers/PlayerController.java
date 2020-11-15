package capstone.amidst.controllers;

import capstone.amidst.domain.PlayerService;
import capstone.amidst.domain.Result;
import capstone.amidst.domain.ResultType;
import capstone.amidst.models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    // Mappings
    @GetMapping("/players")
    public List<Player> displayAll() {
        return service.findAll();
    }

    @PostMapping("/players")
    public ResponseEntity<Object> addComputer(@RequestBody Player player) {
        Result<Player> result = service.addComputerPlayer(player);
        if (result.getType() == ResultType.INVALID) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
    }

    @GetMapping("/players/{playerId}")
    public Player findById(@PathVariable int playerId) {
        return service.findById(playerId);
    }
    // These are probably just for testing purposes
    @GetMapping("/players/{isImposter}")
    public List<Player> findByIsImposter(@PathVariable boolean isImposter) {
        return service.findByIsImposter(isImposter);
    }
    @GetMapping("/players/{isDead}")
    public List<Player> findByIsDead(@PathVariable boolean isDead) {
        return service.findByIsDead(isDead);
    }

    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int playerId) {
        if(service.deleteById(playerId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/players/{playerId}")
    public ResponseEntity<Player> update(@PathVariable int playerId, @RequestBody Player player) {
        if (playerId != player.getPlayerId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Player> result = service.update(player);
        if (result.getType() == ResultType.INVALID) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
    }

}
