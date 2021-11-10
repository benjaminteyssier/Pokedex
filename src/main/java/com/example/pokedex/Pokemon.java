package com.example.pokedex;

import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pokemon {
    private int number;
    private String name;
    private long height;
    private long weight;
    private String description;





    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public long getHeight() {
        return height;
    }

    public long getWeight() {
        return weight;
    }

    public String getDescription() { return description; }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public Pokemon() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pokemon(int number) {
        this.number = number;
    }

    public void setPokemonInformationViaAPI(){
        JSONObject pokemonInformation = HTTPRequest.getPokemonInformation(this.number);
        setName((String) pokemonInformation.get("name"));
        setHeight((long) pokemonInformation.get("height"));
        setWeight((long) pokemonInformation.get("weight"));
    }
    public void setPokemonInformationViaSQL(String database){
        ResultSet rs = SQLITERequest.getPokemonInformation(this.number,database);

        try {
            setName(rs.getString("name"));
            setHeight(rs.getLong("height"));
            setWeight(rs.getLong("weight"));
            setDescription(rs.getString("description"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void showPokemonInformationViaApi(){
        System.out.println("=============================");
        System.out.println("Pokémon #"+this.getNumber());
        System.out.println("Nom : "+this.getName());
        System.out.println("Taille : "+this.getHeight());
        System.out.println("Poids : "+this.getWeight());
        System.out.println("=============================\n");
    }

    public void showPokemonInformationViaSQL(){
        System.out.println("=============================");
        System.out.println("Pokémon #"+this.getNumber());
        System.out.println("Nom : "+this.getName());
        System.out.println("Taille : "+this.getHeight());
        System.out.println("Poids : "+this.getWeight());
        System.out.println("Description : "+this.getDescription());
        System.out.println("=============================\n");
    }
}
