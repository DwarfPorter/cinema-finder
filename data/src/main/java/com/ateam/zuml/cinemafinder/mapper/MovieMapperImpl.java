package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.MovieModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class MovieMapperImpl implements MovieMapper {

    private final CharacteristicsMapper characteristicsMapper;

    @Inject
    MovieMapperImpl(final CharacteristicsMapper characteristicsMapper) {
        this.characteristicsMapper = characteristicsMapper;
    }

    @Override
    public List<MovieModel> mapMovieResults(final List<MovieResult> movieResults, final Language language,
                                            final LogoSize logoSize) {
        final List<MovieModel> movieModels = new ArrayList<>(movieResults.size());
        for (final MovieResult result : movieResults) {
            movieModels.add(mapMovieResult(result, language, logoSize));
        }
        return movieModels;
    }

    @Override
    public MovieModel mapMovieResult(final MovieResult movieResult, final Language language,
                                     final LogoSize logoSize) {
        final String id = String.valueOf(movieResult.getId());
        final String title = movieResult.getTitle();
        final String originalTitle = movieResult.getOriginalTitle();
        final String releaseDate = movieResult.getReleaseDate();
        final String[] genres = characteristicsMapper.mapGenres(movieResult.getGenreIds(), language);
        final String voteAverage = String.valueOf(movieResult.getVoteAverage());
        final String posterPath = characteristicsMapper.mapLogoSizeToPath(logoSize, movieResult.getPosterPath());

        return new MovieModel(id, title, originalTitle, releaseDate, genres, voteAverage, posterPath);
    }
}
