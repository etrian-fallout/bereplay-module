package com.etrianfallout.minimapreplay.MinimapReplay.domain;

import lombok.Data;

@Data
public class PubgCharacter {
    int health;
    boolean isInBlueZone;
    boolean isInRedZone;
    PubgLocation location;
    private String name;
}
