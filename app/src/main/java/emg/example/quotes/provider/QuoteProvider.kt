package emg.example.quotes.provider

import emg.example.quotes.model.Quote
import emg.example.quotes.service.QuoteService
import emg.example.quotes.service.impl.SimpleQuoteService

class QuoteProvider {
    private val quoteService: QuoteService = SimpleQuoteService()
    private val quotes: List<Quote> = quoteService.quotes()

    fun random(): Quote {
        return quotes.random()
    }
}