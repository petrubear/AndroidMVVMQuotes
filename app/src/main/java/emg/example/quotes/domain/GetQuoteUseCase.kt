package emg.example.quotes.domain

import emg.example.quotes.data.model.Quote
import emg.example.quotes.data.repository.QuoteRepository
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        return repository.getAllQuotes()
    }
}