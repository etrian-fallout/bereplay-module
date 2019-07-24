package com.etrianfallout.minimapreplay.MinimapReplay.api;

import com.etrianfallout.minimapreplay.MinimapReplay.domain.PubgMatch;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class PubgApi {
    private final String apiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkMTZiOWQ2MC04Z" +
            "TkzLTAxMzctYmNhNi0zOTE0OTdlOTY2MmYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTYzNzg4OTI0LC" +
            "JwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InpleHl6LW5hdmVyLWNvIn0.BCsS4TQdc0WkX" +
            "LVZ5Oh8TtpXvucy33AFnnAgg7gCHMs";

    private final String requestUrl = "api.pubg.com";
    private final String PLAYER_URL = "players";

    public List<PubgMatch.Match> getMatchByName(String playerName, String platform) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https").host(requestUrl)
                .addPathSegment("shards").addPathSegment(platform).addPathSegment(PLAYER_URL)
                .addQueryParameter("filter[playerNames]", playerName)
                .build();

        System.out.println(httpUrl.url());

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("Accept", "application/vnd.api+json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            PubgMatch match = gson.fromJson(response.body().string(), PubgMatch.class);
            List<PubgMatch.Match> data = match.getData().get(0)
                    .getRelationships().getMatches().getData();

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
