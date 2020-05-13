package com.example.rickandmortyapp.remote

import androidx.paging.PagedList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {

    private const val PAGE_SIZE = 20

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val pagedListConfig = PagedList.Config.Builder()
        .setPageSize(NetworkUtils.PAGE_SIZE)
        .setInitialLoadSizeHint(NetworkUtils.PAGE_SIZE * 2)
        .setEnablePlaceholders(false)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getNetworkService(): ApiService = retrofit.create(ApiService::class.java)

    fun getPagedConfig(): PagedList.Config = pagedListConfig
}
