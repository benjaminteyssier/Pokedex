package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;



/** Represents an HTTP request to the PokemonApi to get pokemon's information
 * @author Benjamin Teyssier
 */
public class HTTPRequest implements IGetPokemonInformationWithDescription {

    String jsonResponse = "";
    private JSONObject pokemonInformation;

    /**
     * Create the request and store the result inside the JSON Object pokemonInformation
     * @param pokemonNumber is the number of the pokemon we are looking for in the database
     */
    public HTTPRequest(int pokemonNumber) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + pokemonNumber);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            this.jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(this.jsonResponse);
            if (resultObject instanceof JSONObject) {
                this.pokemonInformation = (JSONObject) resultObject;
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }
    }

    /**
     * Gives the name of the pokemon number : pokemonNumber
     * @param pokemonNumber
     * @return the name of the pokemon chosen
     */
    @Override
    public String getName(int pokemonNumber) {
        return (String) this.pokemonInformation.get("name");
    }

    /**
     * Gives the height of the pokemon number : pokemonNumber
     * @param pokemonNumber
     * @return the height of the pokemon chosen
     */
    @Override
    public Long getHeight(int pokemonNumber) {
        return (Long) this.pokemonInformation.get("height");
    }

    /**
     * Gives the weight of the pokemon number : pokemonNumber
     * @param pokemonNumber
     * @return the weight of the pokemon chosen
     */
    @Override
    public Long getWeight(int pokemonNumber) {
        return (Long) this.pokemonInformation.get("weight");
    }

    /**
     *
     * @param pokemonNumber
     * @return an empty description because there is no description in the API currently
     */
    @Override
    public String getDescription(int pokemonNumber) {
        return "";
    }
}
