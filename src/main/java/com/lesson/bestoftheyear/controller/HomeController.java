package com.lesson.bestoftheyear.controller;

import com.lesson.bestoftheyear.model.Movie;
import com.lesson.bestoftheyear.model.Song;
import com.lesson.bestoftheyear.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//Continuiamo a lavorare sul nostro progetto Best of the year (anche stessa repo).
//Step 1
//Modificare i metodi dei controller che rispondono agli url
//- “/movies”
//- “/songs”
//in modo che i Model restituiscano una lista di oggetti (Movie o Song) invece di una stringa. Modificare anche le rispettive view per gestire la lista come unordered list.
//Ogni elemento mostrato nella lista (film o canzone) deve essere un link che punta alla rispettiva pagina di dettaglio, in cui mostrare tutti i dati dell’oggetto e non solo il titolo.
//Step 2
//Includere Bootstrap e fare il refactoring del layout come da allegato, cercando di creare componenti riutilizzabili con i fragments.
//In tutte le pagine deve essere mostrata una navbar con i link alla home, a movies e a songs.
//BONUS
//Evidenziare con la classe active il link della navbar corrispondente all’area che si sta navigando in quel momento
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        User newUser = new User("Simone");
        model.addAttribute("username", newUser.getName());
        return "home";
    }

    public List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Movie movie = new Movie(i, "Film " + i);
            movies.add(movie);
        }
        return movies;
    }

    public List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Song song = new Song(i, "Song " + i);
            songs.add(song);
        }
        return songs;
    }


    @RequestMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
//        StringBuilder movieList  = new StringBuilder();
//
//        for (Movie movie: movies ) {
//            movieList.append(movie.getTitle()).append(", ");
//        }

        model.addAttribute("movieList", movies);
        return "movies";
    }


    @RequestMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();
//        StringBuilder songList  = new StringBuilder();
//
//        for (Song movie: songs ) {
//            songList.append(movie.getTitle()).append(", ");
//        }

        model.addAttribute("songList", songs);
        return "songs";
    }
}
