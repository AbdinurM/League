package com.abdinurmuse.league.Controller;

import com.abdinurmuse.league.Repository.LeagueException;
import com.abdinurmuse.league.Repository.UserRepository;
import com.abdinurmuse.league.Service.PlayerService;

import com.abdinurmuse.league.Models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Player")//gets all players and if you are log in you are brought to the admin page of players
    public String playerpage(Model model) throws LeagueException {
        model.addAttribute("ListPlayer", playerService.getAllPlayer());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        return "Player";
        }
        return "playerid";
    }
    @GetMapping("/Stats")//player stats and etc
    public String playerstats(Model model) throws LeagueException {
        model.addAttribute("ListPlayer", playerService.getAllPlayer());

        return "playerstats";
    }
//    @GetMapping("/playerid")//player management page where you can update player or remove
//    public String playermanage(Model model) throws LeagueException {
//        model.addAttribute("ListPlayer", playerService.getAllPlayer());
//        return "playerid";
//    }
    @GetMapping("/showNewPlayerForm")//add player form
    public String showNewPlayerForm(Model model) {
        // create model attribute to bind form data
        Player player = new Player();
        model.addAttribute("player", player);
        return "addPlayer";
    }
    @PostMapping("/addPlayer")//adds player to DB
    public String AddPlayer(@ModelAttribute("player") Player newPlayer) throws LeagueException {
         //save player to database
        playerService.addPlayer(newPlayer);
        return "redirect:/playerid";
    }
    @GetMapping("/showFormForPlayerUpdate/{playerId}")//update player page
    public String showFormForPlayerUpdate(@PathVariable(value = "playerId") int playerId, Model model) throws LeagueException {

        Player player = playerService.getPlayer(playerId);

        model.addAttribute("player", player);
        return "updatePlayer";
    }
    @GetMapping("/deletePlayer/{playerId}")//delete player
    public String deletePlayerByplayerId(@PathVariable(value = "playerId") int playerId) throws LeagueException {

        // call delete employee method
        this.playerService.deletePlayerByplayerId(playerId);
        return "redirect:/playerid";
    }
    @GetMapping("/getplayerteam/{teamId}")//get one team and its players
    public String getplayerteam(@PathVariable(value = "teamId") int teamId, Model model) throws LeagueException {
        List<Player> player = playerService.findbyteamid(teamId);
        model.addAttribute("player", player);
        return "teamplayer";
    }
}
