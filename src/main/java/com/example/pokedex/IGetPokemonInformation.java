package com.example.pokedex;

/**
 *
 * An interface to get the information from a pokemon
 *
 * @author Benjamin Teyssier
*/
public interface IGetPokemonInformation {

    String getName(int number);

    Long getHeight(int number);

    Long getWeight(int number);

}
