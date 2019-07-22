package com.etrianfallout.minimapreplay.MinimapReplay.controller;

import com.etrianfallout.minimapreplay.MinimapReplay.api.RiotApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController {
    @Autowired
    RiotApi riotApi;

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    public String getEncryptedAccountIdByName(String summonerName) {
        return riotApi.getEncryptedAccountIdByName(summonerName);
    }
}
