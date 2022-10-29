package emg.example.quotes.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import emg.example.quotes.data.database.QuoteDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    private const val DATABASE_NAME = "quote_database"

    @Provides
    @Singleton
    fun providesQuoteDatabase(@ApplicationContext context: Context): QuoteDatabase {
        return Room.databaseBuilder(
            context,
            QuoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun providesQuoteDao(quoteDatabase: QuoteDatabase) = quoteDatabase.quoteDao()
}