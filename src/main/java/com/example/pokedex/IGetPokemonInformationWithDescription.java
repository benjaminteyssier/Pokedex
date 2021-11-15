package com.example.pokedex;

/**
 *
 * An interface to get the information from a pokemon which has a description
 *
 * @author Benjamin Teyssier
 */
public interface IGetPokemonInformationWithDescription {
    String getName(int number);

    Long getHeight(int number);

    Long getWeight(int number);

    String getDescription(int number);
}
