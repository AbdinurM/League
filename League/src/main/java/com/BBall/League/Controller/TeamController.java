package com.AbdinurMuse.League.Controller;

import com.AbdinurMuse.League.Repository.LeagueException;
import com.AbdinurMuse.League.Service.TeamService;
import com.AbdinurMuse.League.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/Team")//list all team name and color
    public String viewHomePage(Model model) throws LeagueException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "Team";
    }
    @GetMapping("TeamId")//management page where you can update team or remove
    public String teamid(Model model) throws LeagueException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "TeamId";
    }
    @GetMapping("/Standings")//list team record
    public String teamrecord(Model model) throws LeagueException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "teamrecord";
    }

    @GetMapping("/getTeamPlayer/{teamId}")//get one team and its players
    public String getTeamPlayer(@PathVariable(value = "teamId") int teamId, Model model) throws LeagueException {
        Team team = teamService.getTeam(teamId);
        model.addAttribute("team", team);
        return "teamplayer";
    }
        @GetMapping("/showNewTeamForm")//sign up team
    public String showNewTeamForm(Model model) {
        Team team = new Team();
        model.addAttribute("team", team);
        return "addTeam";
    }
    @PostMapping("/addTeam")//adds team to db
    public String addTeam(@ModelAttribute("Team") Team newTeam) throws LeagueException {
        //save player to database
        teamService.addTeam(newTeam);
        return "redirect:/TeamId";
    }


    @GetMapping("/showFormForUpdate/{teamId}")//update team
    public String showFormForUpdate(@PathVariable(value = "teamId") int teamId, Model model) throws LeagueException {

        Team team = teamService.getTeam(teamId);

        model.addAttribute("team", team);
        return "updateTeam";
    }
    @GetMapping("/deleteTeam/{teamId}")//delete team
    public String deleteTeamByTeamId(@PathVariable(value = "teamId") int teamId) throws LeagueException {

        // call delete employee method
        this.teamService.deleteTeamByTeamId(teamId);
        return "redirect:/TeamId";
    }
}
