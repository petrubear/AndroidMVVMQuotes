package emg.example.quotes.data.network

import emg.example.quotes.data.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteNetworkService @Inject constructor(
    private val api: QuoteApiClient
) {
    suspend fun getQuotes(): List<Quote> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}