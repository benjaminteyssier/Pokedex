package com.example.pokedex;

/**
 * Main class of this application
 * It represents a pokedex, with a given pokemon number it returns the information it has on the pokemon
 *
 * @author Benjamin Teyssier
 */
public class Pokedex {

    public static void main(String[] args) {

        /**
         * If the database given does not contain the pokemon's information we look in the API
         */
        if (args.length == 1 || Integer.parseInt(args[0]) > 5) {
            System.out.println("Vous cherchez les informations sur le Pokémon n° : " + args[0]);
            HTTPRequest httpRequest = new HTTPRequest(Integer.parseInt(args[0]));
            PokemonWithDescription pokemon = new PokemonWithDescription(Integer.parseInt(args[0]), httpRequest);
            pokemon.setPokemonInformation();
            pokemon.showPokemonInformation();

            /** If the database given contains the pokemon's information we display it
             *
             */
        } else if (args.length == 2) {
            System.out.println("Vous cherchez les informations sur le Pokémon n° : " + args[0] + " dans la base de données : " + args[1]);
            SQLITERequest sqliteRequest = new SQLITERequest(Integer.parseInt(args[0]), args[1]);
            PokemonWithDescription pokemon = new PokemonWithDescription(Integer.parseInt(args[0]), sqliteRequest);
            pokemon.setPokemonInformation();
            pokemon.showPokemonInformation();
        } else {
            System.out.println("Vous n'avez pas fourni le bon nombre d'arguments !");
        }
    }
}
