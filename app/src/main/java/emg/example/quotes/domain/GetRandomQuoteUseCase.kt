package emg.example.quotes.domain

import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.model.provider.QuoteProvider
import emg.example.quotes.data.repository.QuoteRepository

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke(): Quote? {
        val quotes = QuoteProvider.quotes
        if (quotes.isNotEmpty()) {
            return quotes.random()
        }
        return null
    }
}