package com.example.pokedex;

public class PokemonWithDescription extends Pokemon {
    private int number;
    private String name;
    private long height;
    private long weight;
    private String description = "";

    private IGetPokemonInformationWithDescription pokemonInformation;

    public int getNumber() { return number; }

    public String getName() {
        return name;
    }

    public long getHeight() {
        return height;
    }

    public long getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public PokemonWithDescription(int number, IGetPokemonInformationWithDescription getPokemonInformation) {
        this.number = number;
        pokemonInformation = getPokemonInformation;
    }

    public void setPokemonInformation() {
        setName(pokemonInformation.getName(this.number));
        setHeight(pokemonInformation.getHeight(this.number));
        setWeight(pokemonInformation.getWeight(this.number));
        setDescription(pokemonInformation.getDescription(this.number));
    }

    public void showPokemonInformation() {
        System.out.println("=============================");
        System.out.println("Pokémon #" + this.getNumber());
        System.out.println("Nom : " + this.getName());
        System.out.println("Taille : " + this.getHeight());
        System.out.println("Poids : " + this.getWeight());
        if (this.getDescription() != "") {
            System.out.println("Description : " + this.getDescription());
        }
        System.out.println("=============================\n");
    }
}
