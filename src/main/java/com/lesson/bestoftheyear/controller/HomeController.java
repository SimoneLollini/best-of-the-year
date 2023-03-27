package com.lesson.bestoftheyear.controller;

import com.lesson.bestoftheyear.model.Movie;
import com.lesson.bestoftheyear.model.Song;
import com.lesson.bestoftheyear.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

//BONUS
//Creare due metodi - “/movies/{id}” - “/songs/{id}” che dato il parametro id passato tramite il path, mostri in pagina il titolo relativo al film / canzone. Testare chiamando dal browser i diversi url.
@Controller
@RequestMapping("/")
public class HomeController {
@GetMapping
        public String home(Model model){
            User newUser = new User("Simone");
            model.addAttribute("username", newUser.getName());
            return "home";
    }

   public List<Movie> getBestMovies(){
       List<Movie> movies = new ArrayList<>();
       for (int i = 1; i < 11; i++) {
           Movie movie = new Movie(i, "Film " + i);
           movies.add(movie);
       }
       return movies;
   }

    public List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Song song = new Song(i, "Song " + i);
            songs.add(song);
        }
        return songs;
    }


    @RequestMapping("/movies")
    public String movies(Model model){
        List<Movie> movies = getBestMovies();
        StringBuilder movieList  = new StringBuilder();

        for (Movie movie: movies ) {
            movieList.append(movie.getTitle()).append(", ");
        }

        model.addAttribute( "bestMovies", movieList.toString());
        return "movies";
    }

    @RequestMapping("/songs")
    public String songs(Model model)
    {
        List<Song> songs = getBestSongs();
        StringBuilder songList  = new StringBuilder();

        for (Song movie: songs ) {
            songList.append(movie.getTitle()).append(", ");
        }

        model.addAttribute("bestSongs",songList.toString());
        return "songs";
    }
}
