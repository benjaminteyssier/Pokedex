package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTest {

    private final Pokemon pokemonTest2;
    private final Pokemon pokemonTest1;

    SQLITERequest sqliteRequest = new SQLITERequest(3, "/home/benjamin/Documents/Cours/2A/I2SI/Bonnes_pratiques/emse_solid_lesson/pokedex/pokemondatabase.sqlite");
    HTTPRequest httpRequest = new HTTPRequest(3);

    public PokemonTest() {
        pokemonTest1 = new Pokemon(3, sqliteRequest);
        pokemonTest2 = new Pokemon(3, httpRequest);
    }

    @Test
    public void getNameViaSQL() {
        pokemonTest1.setPokemonInformation();
        pokemonTest1.showPokemonInformation();
        Assert.assertEquals("Florizarre", this.pokemonTest1.getName());
    }

    @Test
    public void getNameViaAPI() {
        pokemonTest2.setPokemonInformation();
        pokemonTest2.showPokemonInformation();
        Assert.assertEquals("venusaur", this.pokemonTest2.getName());
    }

}
