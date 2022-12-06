package at.chrispi.teamranking.modules

import at.chrispi.teamranking.Api
import at.chrispi.teamranking.network.services.TeamService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideTeamData(): TeamService = Retrofit.Builder()
        .baseUrl(Api.TEAMS_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TeamService::class.java)
}