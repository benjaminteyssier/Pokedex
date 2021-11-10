package com.example.pokedex;

import java.sql.*;

public class SQLITERequest {

    public static ResultSet getPokemonInformation(int pokemonNumber, String database) {
        /* Connect to the database */
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+database;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, pokemonNumber);
            ResultSet rs    = stmt.executeQuery();
            rs.next();
            return rs;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
