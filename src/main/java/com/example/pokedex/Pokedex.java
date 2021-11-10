package com.example.pokedex;


public class Pokedex {

    public static void main(String[] args) {

        if (args.length == 1 || Integer.parseInt(args[0])>5) {
            System.out.println("Vous cherchez les informations sur le Pokémon n° : " + args[0]);
            Pokemon pokemonTest = new Pokemon(Integer.parseInt(args[0]));
            pokemonTest.setPokemonInformationViaAPI();
            pokemonTest.showPokemonInformationViaApi();
        }
        else if (args.length == 2) {
            System.out.println("Vous cherchez les informations sur le Pokémon n° : " + args[0] + " dans la base de données : " + args[1]);
            Pokemon pokemonTest = new Pokemon(Integer.parseInt(args[0]));
            pokemonTest.setPokemonInformationViaSQL(args[1]);
            pokemonTest.showPokemonInformationViaSQL();
        }
        else {
            System.out.println("Vous n'avez pas fourni le bon nombre d'arguments !");
        }
    }
}
