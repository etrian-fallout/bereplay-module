package com.etrianfallout.minimapreplay.MinimapReplay.controller;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatchReference;
import com.etrianfallout.minimapreplay.MinimapReplay.service.PubgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PubgController {
    @Autowired
    private PubgService pubgService;

    @GetMapping("/pubg/players/{playerName}")
    public List<PubgMatch.Match> getMatchByName(@PathVariable String playerName, @RequestParam("platform") String platform) {
        return pubgService.getMatchByName(playerName, platform);
    }

    @GetMapping("/pubg/matches/{matchId}")
    public PubgMatchReference getMatchInfo(@PathVariable String matchId, @RequestParam("platform") String platform) {
        return pubgService.getMatchInfo(matchId, platform);
    }
}
