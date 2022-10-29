package emg.example.quotes.data.model.provider

import emg.example.quotes.data.model.Quote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<Quote> = emptyList()
}