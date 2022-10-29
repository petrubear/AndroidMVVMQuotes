package emg.example.quotes.domain

import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.model.provider.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val provider: QuoteProvider
) {
    operator fun invoke(): Quote? {
        val quotes = provider.quotes
        if (quotes.isNotEmpty()) {
            return quotes.random()
        }
        return null
    }
}