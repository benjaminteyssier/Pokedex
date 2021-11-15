package com.example.pokedex;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;

public class HTTPRequestTest {

    @Test
    public void getName()  {
        HTTPRequest httpRequest = new HTTPRequest();
        String pokemonName = (String) httpRequest.getPokemonInformation(3).get("name");
        Assert.assertEquals("venusaur", pokemonName);

    }
}
