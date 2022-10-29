package emg.example.quotes.data.network

import emg.example.quotes.core.RetrofitHelper
import emg.example.quotes.data.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteNetworkService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<Quote> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}