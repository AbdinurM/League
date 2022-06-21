package com.BBall.League.Controller;

import com.BBall.League.Repository.TeamException;
import com.BBall.League.Service.PlayerService;

import com.BBall.League.models.Player;
import com.BBall.League.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/Player")//player
    public String playerpage(Model model) throws TeamException {
        model.addAttribute("ListPlayer", playerService.getAllPlayer());
        return "Player";
    }
    @GetMapping("/Stats")//player stats and etc
    public String playerstats(Model model) throws TeamException {
        model.addAttribute("ListPlayer", playerService.getAllPlayer());
        return "playerstats";
    }
    @GetMapping("/showNewPlayerForm")//add player form
    public String showNewPlayerForm(Model model) {
        // create model attribute to bind form data
        Player player = new Player();
        model.addAttribute("player", player);
        return "addPlayer";
    }
    @PostMapping("/addPlayer")//adds player to form
    public String AddPlayer(@ModelAttribute("player") Player newPlayer) throws TeamException {
         //save player to database
        playerService.addPlayer(newPlayer);
        return "redirect:/Player";
    }
    @GetMapping("/showFormForPlayerUpdate/{playerId}")//update player
    public String showFormForPlayerUpdate(@PathVariable(value = "playerid") int playerId, Model model) throws TeamException {

        Player player = playerService.getPlayer(playerId);

        model.addAttribute("player", player);
        return "updatePlayer";
    }
    @GetMapping("/deletePlayer/{playerId}")//delete player
    public String deletePlayerByplayerId(@PathVariable(value = "playerId") int playerId) throws TeamException {

        // call delete employee method
        this.playerService.deletePlayerByplayerId(playerId);
        return "redirect:/Player";
    }
}
