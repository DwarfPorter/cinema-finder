package com.ateam.zuml.cinemafinder.repository;

import com.ateam.zuml.cinemafinder.model.MovieModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;

import java.util.List;

import io.reactivex.Single;

public interface MoviesRepository {

    Single<List<MovieModel>> getMoviesBySearch(final String query, final String page, final Language language,
                                               final Region region, final LogoSize logoSize);

    Single<List<MovieModel>> getPopularMovies(final String page, final Language language,
                                              final Region region, final LogoSize logoSize);
}
