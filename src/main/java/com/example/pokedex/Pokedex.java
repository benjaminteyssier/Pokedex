package com.example.pokedex;


public class Pokedex {

    public static void main(String[] args) {

        if (args.length == 1 || Integer.parseInt(args[0]) > 5) {
            System.out.println("Vous cherchez les informations sur le Pokémon n° : " + args[0]);
            HTTPRequest httpRequest = new HTTPRequest(Integer.parseInt(args[0]));
            PokemonWithDescription pokemon = new PokemonWithDescription(Integer.parseInt(args[0]), httpRequest);
            pokemon.setPokemonInformation();
            pokemon.showPokemonInformation();
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
