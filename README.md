After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.

# Build the project

```
./gradlew build
```

# Run the application

To run the application with a database:

```
./gradlew run --args="<pokemonSearchedNumber> <databaseDirectory>"
```

To run the application via the API:

```
./gradlew run --args="<pokemonSearchedNumber>"
```

# Run the tests

```
./gradlew test
```
