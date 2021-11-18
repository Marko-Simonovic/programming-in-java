package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static agh.ii.prinjava.proj2.utils.Utils.*;
import static java.util.stream.Collectors.groupingBy;

/**
 * <b>The numbers of comments you will see is huge. Of course, in a real code, we don't need to explain that much
 * what we are doing at every line, this is solely for presentation purpose.</b>
 */
interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static List<String> ex01(String director) {
        System.out.println("\nEX1\nSearching movies by "+director+"...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();    // Get all document in a Optional<List>
        List<String> directorMovies = optMovies.orElseThrow().stream()  // Since it's an Optional<> it can be "empty", which throws an error.
                .filter(movie -> movie.directors().contains(director))  // We filter for each element to get back a Stream with given director.
                .map(Movie::title)                                      // Return a new stream containing only "Title" because it's the given parameter
                .collect(Collectors.toList());      // Final operation, convert the Stream into a List

        System.out.println(directorMovies);         // List containing only "title" of movies by given "director"
        return directorMovies;
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static List<String> ex02(String actor) {
        System.out.println("\nEX2\nSearching movies with "+actor+"...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<String> actorMovies = optMovies.orElseThrow().stream()
                .filter(movie -> movie.actors().contains(actor))    // Return a Stream which elements pass the condition "does movie contain given actor"
                .map(Movie::title)
                .collect(Collectors.toList());      // Final operation that converts the Stream into a List

        System.out.println(actorMovies);
        return actorMovies;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        System.out.println("\nEX3\nCalculating the number of movies per director...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Map<String, Long> numberOfMovies = optMovies.orElseThrow().stream()
                .flatMap(m -> oneToManyByDirector(m).stream())      // We flat out the Stream, each element is separated
                .collect(groupingBy(Movie::directors))
                .entrySet()     // We end up with a Set of Entry = (key, value) with key as director and movies as values
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> (long) e.getValue().size()));    // getValue().size returns the number of movies in List<Movie>

        System.out.println(numberOfMovies);
        return numberOfMovies;
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static List<Map.Entry<String, Long>> ex04() {
        System.out.println("\nEX4\nLooking for the 10 directors with the most films");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<Map.Entry<String, Long>> topDirectors = optMovies.orElseThrow()
                .stream()
                .flatMap(m -> oneToManyByDirector(m).stream())      // One movie --> Many directors
                .collect(groupingBy(Movie::directors))
                .entrySet()     // Create a Set of (k: List<director>, v: List<movie>). The key contains only one director
                .stream()       // Recreate a Stream since we created a Set previously
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> (long) e.getValue().size()))     // Get numbers of movie for each single director
                .entrySet()     // Create a Set this time with only a single director as key and numbers of movie as value
                .stream()
                .sorted((l1, l2) -> Long.compare(l2.getValue(), l1.getValue()))     // Work like a double for--> for(l2){ for(l1) }
                .limit(10)
                .toList();
        System.out.println(topDirectors);
        return topDirectors;
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static List<Map.Entry<String, List<String>>> ex05() {
        System.out.println("\nEX5\nLooking for the movies of the 10 directors with the most movies...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        // Exercise4 returns a List<Map.Entry<String, Long>> --> List<String>
        // We work with the Stream to only get the key which are the name of directors
        List<String> topDirectors = ex04().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Map.Entry<String, List<String>>> topMovies = optMovies.orElseThrow()
                .stream()
                .flatMap(m -> oneToManyByDirector(m).stream())
                .collect(Collectors.groupingBy(Movie::directors))
                .entrySet()
                .stream()
                // create Map of Movie
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> e.getValue()
                        .stream()
                        .map(Movie::title)      // Only Map the title from the value
                        .collect(Collectors.toList())))     // Put those title in a List, which is only applied to value of the Map
                .entrySet()
                .stream()
                .filter(e -> topDirectors.stream().anyMatch(entry -> entry.equals(e.getKey())))     // See if any director's name correspond to a key
                .sorted((l1, l2) -> Integer.compare(l2.getValue().size(), l1.getValue().size()))    // Compare number of movies
                .collect(Collectors.toList());
        System.out.println(topMovies);
        return topMovies;
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        System.out.println("\nEX6\nCalculating the number of movies per actor...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Map<String, Long> numberOfMovies = optMovies.orElseThrow().stream()
                .flatMap(m -> oneToManyByActor(m).stream())     // One movie --> Many actor
                .collect(groupingBy(Movie::actors))     // Regroup the actor, but problem once again: key is a List of String and not a single String
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> (long) e.getValue().size()));    // Size = number of movies

        System.out.println(numberOfMovies);
        return numberOfMovies;
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static List<Map.Entry<String, Long>> ex07() {
        System.out.println("\nEX7\nLooking for the 9 actors with the most films");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<Map.Entry<String, Long>> topActors = optMovies.orElseThrow()
                .stream()
                .flatMap(m -> oneToManyByActor(m).stream())     // One movie--> Many actor
                .collect(groupingBy(Movie::actors))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> (long) e.getValue().size()))
                .entrySet()
                .stream()
                .sorted((l1, l2) -> Long.compare(l2.getValue(), l1.getValue()))
                .limit(9)
                .toList();
        System.out.println(topActors);
        return topActors;
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static List<Map.Entry<String, List<String>>> ex08() {
        System.out.println("\nEX8\nLooking for the movies of the 9 actors with the most movies...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<String> topActors = ex07().stream().map(Map.Entry::getKey).collect(Collectors.toList()); // convert to have a List<String>
        List<Map.Entry<String, List<String>>> topMovies = optMovies.orElseThrow()
            .stream()
            .flatMap(m -> oneToManyByActor(m).stream())
            .collect(Collectors.groupingBy(Movie::actors))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(e -> e.getKey().get(0), e -> e.getValue()
                .stream()
                .map(Movie::title)      // from Stream, in the List of Movie we only take titles
                .collect(Collectors.toList())))
            .entrySet()     // (k: Actor name, v: List of title)
            .stream()
            .filter(e -> topActors.stream().anyMatch(entry -> entry.equals(e.getKey())))    // Actors should match with their name (key)
            .sorted((l1, l2) -> Integer.compare(l2.getValue().size(), l1.getValue().size()))
            .collect(Collectors.toList());
        System.out.println(topMovies);
        return topMovies;
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static List<Map.Entry<String, Long>> ex09() {
        System.out.println("\nEX9\nLooking for 5 most frequent actor partnerships...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<Map.Entry<String, Long>> buddies = optMovies.orElseThrow()
                .stream()
                .flatMap(m -> oneToManyByActorDuo(m).stream())
                .collect(Collectors.groupingBy(Movie::actors))
                .entrySet()     // Key List ActorDuo, List Movie
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> (long) e.getValue().size()))
                .entrySet()
                .stream()
                .sorted((l1,l2) -> Long.compare((l2.getValue()), l1.getValue()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(buddies);
        return buddies;
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static List<Map.Entry<String, List<String>>> ex10() {
        System.out.println("\nEX10\nLooking for 5 most frequent actor partnerships films...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        List<Map.Entry<String, List<String>>> buddyMovie = optMovies.orElseThrow()
                .stream()
                .flatMap(m -> oneToManyByActorDuo(m).stream())
                .collect(Collectors.groupingBy(Movie::actors))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().get(0), e -> e.getValue()
                        .stream()
                        .map(Movie::title)
                        .collect(Collectors.toList())))
                .entrySet()     // ActorDuo, List title
                .stream()
                .sorted((l1,l2) -> Integer.compare((l2.getValue().size()), l1.getValue().size()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(buddyMovie);
        return buddyMovie;
    }
}

