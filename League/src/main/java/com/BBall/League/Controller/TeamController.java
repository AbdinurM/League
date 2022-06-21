package com.BBall.League.Controller;

import com.BBall.League.Repository.TeamException;
import com.BBall.League.Service.TeamService;
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
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/Team")//list team info likename/color/etc
    public String viewHomePage(Model model) throws TeamException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "Team";
    }
    @GetMapping("TeamId")//list team id and name only!
    public String teamid(Model model) throws TeamException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "teamid";
    }
    @GetMapping("/Standings")//list team standings
    public String teamrecord(Model model) throws TeamException {
        model.addAttribute("ListTeam", teamService.getAllTeams());
        return "teamrecord";
    }
    @GetMapping("/getTeamPlayer/{teamId}")//get one team and its players
    public String getTeamPlayer(@PathVariable(value = "teamId") int teamId, Model model) throws TeamException {
        Team team = teamService.getTeam(teamId);
        model.addAttribute("team", team);
        return "Team";
    }
        @GetMapping("/showNewTeamForm")//sign up team
    public String showNewTeamForm(Model model) {
        Team team = new Team();
        model.addAttribute("team", team);
        return "addTeam";
    }
    @PostMapping("/addTeam")//adds team to db
    public String addTeam(@ModelAttribute("Team") Team newTeam) throws TeamException {
        //save player to database
        teamService.addTeam(newTeam);
        return "redirect:/Team";
    }



    @GetMapping("/showFormForUpdate/{teamId}")//update team
    public String showFormForUpdate(@PathVariable(value = "teamId") int teamId, Model model) throws TeamException {

        Team team = teamService.getTeam(teamId);

        model.addAttribute("team", team);
        return "updateTeam";
    }
    @GetMapping("/deleteTeam/{teamId}")//delete team
    public String deleteTeamByTeamId(@PathVariable(value = "teamId") int teamId) throws TeamException {

        // call delete employee method
        this.teamService.deleteTeamByTeamId(teamId);
        return "redirect:/TeamId";
    }
}
