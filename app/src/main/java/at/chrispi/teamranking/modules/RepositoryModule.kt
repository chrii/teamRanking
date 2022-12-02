package at.chrispi.teamranking.modules

import at.chrispi.teamranking.network.services.TeamService
import at.chrispi.teamranking.repositories.ITeamRepository
import at.chrispi.teamranking.repositories.implementations.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideTeamRepository(
        teamRepository: TeamService
    ): ITeamRepository = TeamRepository(teamRepository)
}