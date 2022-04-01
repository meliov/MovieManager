package util;

import dao.exception.ConstraintViolation;
import dao.exception.ConstraintViolationException;
import model.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static util.Regex.*;

public class MovieValidator extends EntityValidator<Integer, Movie>{
    @Override
    public void validate(Movie movie) throws ConstraintViolationException {
        List<ConstraintViolation> violations = new ArrayList<>();
        if(Regex.regexValidation(movie.getMovieName(), MOVIE_NAMES_REGEX)){
            violations.add(new ConstraintViolation(movie.getClass().getName(),
                    "movie name", movie.getMovieName(), "Movie name must have at least 1 symbol." ));
        }
        if(movie.getReleaseDate().isAfter(LocalDate.now())){
            violations.add(new ConstraintViolation(movie.getClass().getName(),
                    "release date", movie.getMovieName(), "Movie release date must be valid" ));
        }
        if(Regex.regexValidation(movie.getDirectorName(), MOVIE_DIRECTOR_STUDIO_NAME_REGEX)){
            violations.add(new ConstraintViolation(movie.getClass().getName(),
                    " director", movie.getMovieName(), "Director names must have at least 2 symbols" ));
        }
        if(Regex.regexValidation(movie.getMovieName(), MOVIE_DIRECTOR_STUDIO_NAME_REGEX)){
            violations.add(new ConstraintViolation(movie.getClass().getName(),
                    "studio", movie.getMovieName(), "Movie studio must have at least 2 symbols." ));
        }
        if(violations.size() > 0){
            setUniqueStringIdentifier(movie.getMovieName());
            throw new ConstraintViolationException("Invalid movie field", violations);
        }
    }
}
