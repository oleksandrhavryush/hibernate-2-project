package com.havriush.service;

import com.havriush.MySessionFactory;
import com.havriush.dao.*;
import com.havriush.model.*;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.Year;
import java.util.*;

public class FilmService {

    FilmDAO filmDAO;
    LanguageDAO languageDAO;
    CategoryDAO categoryDAO;
    ActorDAO actorDAO;
    FilmTextDAO filmTextDAO;

    public FilmService() {
        this.filmDAO = new FilmDAO(MySessionFactory.getSessionFactory());
        this.languageDAO = new LanguageDAO(MySessionFactory.getSessionFactory());
        this.categoryDAO = new CategoryDAO(MySessionFactory.getSessionFactory());
        this.actorDAO = new ActorDAO(MySessionFactory.getSessionFactory());
        this.filmTextDAO = new FilmTextDAO(MySessionFactory.getSessionFactory());
    }

    public void productionNewFilm() {
        try (Session session = MySessionFactory.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Film film = new Film();

            Language language = languageDAO.getItems(0, 10).get(6);
            Set<Category> categoryList = new HashSet<>(categoryDAO.getItems(0, 10));
            Set<Actor> actorList = new HashSet<>(actorDAO.getItems(0, 20));

            film.setTitle("Zhakhar Berkut");
            film.setDescription("Historical movie in Carpathion Region");
            film.setYear(Year.now());
            film.setLanguage(language);
            film.setOriginalLanguage(language);
            film.setRentalDuration((byte) 1);
            film.setRentalRate(BigDecimal.ZERO);
            film.setLength((short) 130);
            film.setReplacementCost(BigDecimal.TEN);
            film.setRating(Rating.R);
            film.setSpecialFeatures(Set.of(Feature.TRAILERS, Feature.COMMENTARIES));
            film.setActors(actorList);
            film.setCategories(categoryList);
            filmDAO.save(film);


            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmText.setDescription("Historical movie in Carpathion Region");
            filmText.setTitle("Zhakhar Berkut");
            filmTextDAO.save(filmText);

            session.getTransaction().commit();
        }
    }
}
