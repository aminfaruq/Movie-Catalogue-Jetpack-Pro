package com.example.moviecataloguejetpackprosub2.data.repository

import com.example.moviecataloguejetpackprosub2.data.mapper.DetailMovieMapper
import com.example.moviecataloguejetpackprosub2.data.mapper.DetailTvShowMapper
import com.example.moviecataloguejetpackprosub2.data.service.GlobalService
import com.example.moviecataloguejetpackprosub2.domain.DetailMovieDomain
import com.example.moviecataloguejetpackprosub2.domain.DetailTvShowDomain
import io.reactivex.Single

class DetailRepositoryImpl(
    private val service: GlobalService,
    private val detailMovieMapper: DetailMovieMapper,
    private val detailTvShowMapper: DetailTvShowMapper
) : DetailRepository {
    override fun getDetailMovies(
        apiKey: String,
        language: String,
        shortBy: String
    ): Single<DetailMovieDomain> {
        return service.getDetailMovies(apiKey, language, shortBy).map {
            detailMovieMapper.mapToDomain(it)
        }
    }

    override fun getDetailTvShows(
        apiKey: String,
        language: String,
        shortBy: String
    ): Single<DetailTvShowDomain> {
        return service.getDetailTvShows(apiKey, language, shortBy).map {
            detailTvShowMapper.mapToDomain(it)
        }
    }
}