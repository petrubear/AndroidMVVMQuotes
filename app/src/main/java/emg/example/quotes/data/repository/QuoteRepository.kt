package emg.example.quotes.data.repository

import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.model.provider.QuoteProvider
import emg.example.quotes.data.network.QuoteNetworkService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteNetworkService,
    private val provider: QuoteProvider
) {
    suspend fun getAllQuotes(): List<Quote> {
        val response = api.getQuotes()
        provider.quotes = response
        return response
    }
}