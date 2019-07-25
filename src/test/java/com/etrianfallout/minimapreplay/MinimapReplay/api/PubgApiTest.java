package com.etrianfallout.minimapreplay.MinimapReplay.api;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PubgApiTest {
    @Autowired
    private PubgApi pubgApi;

    @Test
    public void getMatchByName() {
        List<PubgMatch.Match> var = pubgApi.getMatchByName("HeavyRain", "steam");

        assert var != null && var.size() != 0;
    }
}