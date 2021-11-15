package com.example.pokedex;

public interface IGetPokemonInformationWithDescription {
    String getName(int number);

    Long getHeight(int number);

    Long getWeight(int number);

    String getDescription(int number);
}
