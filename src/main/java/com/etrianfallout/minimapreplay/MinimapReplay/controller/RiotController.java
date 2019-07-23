package com.etrianfallout.minimapreplay.MinimapReplay.controller;

import com.etrianfallout.minimapreplay.MinimapReplay.service.RiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController {
    @Autowired
    private RiotService riotService;

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    public String getEncryptedAccountIdByName(@PathVariable String summonerName) {
        return riotService.getEncryptedAccountIdByName(summonerName);
    }
}
