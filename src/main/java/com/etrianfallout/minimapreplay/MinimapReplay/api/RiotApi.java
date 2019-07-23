package com.etrianfallout.minimapreplay.MinimapReplay.api;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.RiotSummoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotApi {
    @Autowired
    private RestTemplate restTemplate;
    private final String apiKey = ""; //Api Key Required
    private final String requestUrl = "https://kr.api.riotgames.com";

    public RiotSummoner  getSummonerByName(String summonerName) {
        return restTemplate.exchange(requestUrl + "/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}", HttpMethod.GET, null, RiotSummoner.class, summonerName, apiKey ).getBody();
    }

}
