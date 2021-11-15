package com.example.pokedex;

import java.sql.*;

public class SQLITERequest implements IGetPokemonInformationWithDescription {

    private ResultSet rs;

    public SQLITERequest(int pokemonNumber, String database) {
        Connection conn = null;
        rs = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + database;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt = conn.prepareStatement("SELECT name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, pokemonNumber);
            rs = stmt.executeQuery();
            rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getName(int number) {
        try {
            return this.rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getHeight(int number) {
        try {
            return this.rs.getLong("height");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long getWeight(int number) {
        try {
            return this.rs.getLong("weight");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getDescription(int number) {
        try {
            return rs.getString("description");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
