package emg.example.quotes.domain

import emg.example.quotes.data.repository.QuoteRepository
import emg.example.quotes.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes = quoteRepository.getAllQuotesFromDataBase()
        if (quotes.isNotEmpty()) {
            return quotes.random()
        }
        return null
    }
}