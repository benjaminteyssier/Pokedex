package com.example.pokedex;

public class Pokemon {
    private int number;
    private String name;
    private long height;
    private long weight;

    private IGetPokemonInformation pokemonInformation;

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

    public Pokemon(int number, IGetPokemonInformation getPokemonInformation) {
        this.number = number;
        pokemonInformation = getPokemonInformation;
    }

    public void setPokemonInformation() {
        setName(pokemonInformation.getName(this.number));
        setHeight(pokemonInformation.getHeight(this.number));
        setWeight(pokemonInformation.getWeight(this.number));
    }

    public void showPokemonInformation() {
        System.out.println("=============================");
        System.out.println("Pokémon #" + this.getNumber());
        System.out.println("Nom : " + this.getName());
        System.out.println("Taille : " + this.getHeight());
        System.out.println("Poids : " + this.getWeight());
        System.out.println("=============================\n");
    }

}
