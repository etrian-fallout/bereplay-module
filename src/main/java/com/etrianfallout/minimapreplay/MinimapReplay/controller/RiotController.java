package com.etrianfallout.minimapreplay.MinimapReplay.controller;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotMatch;
import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotMatchlist;
import com.etrianfallout.minimapreplay.MinimapReplay.service.RiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController {
    @Autowired
    private RiotService riotService;

    @GetMapping("/lol/summoner/by-name/{summonerName}")
    public String getEncryptedAccountIdByName(@PathVariable String summonerName) {
        return riotService.getEncryptedAccountIdByName(summonerName);
    }

    @GetMapping("/lol/match/matchlists/by-account/{encryptedAccountId}")
    public RiotMatchlist getMatchlistByAccountId(@PathVariable String encryptedAccountId) {
        return riotService.getMatchlistsByAccountId(encryptedAccountId);
    }

    @GetMapping("/lol/match/matches/{matchId}")
    public RiotMatch getMatchByMatchId(@PathVariable String matchId) {
        return riotService.getMatchByMatchId(matchId);
    }
}
