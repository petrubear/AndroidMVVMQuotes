package emg.example.quotes.data.network

import emg.example.quotes.data.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<Quote>>

}