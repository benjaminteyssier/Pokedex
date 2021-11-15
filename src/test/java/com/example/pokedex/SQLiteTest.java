package com.example.pokedex;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteTest {

    @Test
    public void getName() throws SQLException {
        SQLITERequest sqliteRequest = new SQLITERequest();
        ResultSet resultSet = sqliteRequest.getPokemonInformation(3, "/home/benjamin/Documents/Cours/2A/I2SI/Bonnes_pratiques/emse_solid_lesson/pokedex/pokemondatabase.sqlite");
        Assert.assertEquals("Florizarre", resultSet.getString("name"));
    }
}
