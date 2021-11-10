package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokedexTest {

    @Test
    public void getName() {
        Pokemon pokemon = new Pokemon(3);
        Assert.assertEquals("Reptincel", pokemon.getName());
    }
}