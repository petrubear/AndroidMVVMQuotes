package emg.example.quotes.data.repository

import emg.example.quotes.data.database.dao.QuoteDao
import emg.example.quotes.data.database.entity.QuoteEntity
import emg.example.quotes.data.network.QuoteNetworkService
import emg.example.quotes.domain.model.Quote
import emg.example.quotes.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteNetworkService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDataBase(): List<Quote> {
        val quotes = quoteDao.getAllQuotes()
        return quotes.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun deleteAllQuotes() {
        quoteDao.deleteAllQuotes()
    }
}