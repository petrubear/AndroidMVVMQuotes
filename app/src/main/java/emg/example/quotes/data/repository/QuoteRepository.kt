package emg.example.quotes.data.repository

import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.model.provider.QuoteProvider
import emg.example.quotes.data.network.QuoteNetworkService

class QuoteRepository {
    private val api = QuoteNetworkService()

    suspend fun getAllQuotes(): List<Quote> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}