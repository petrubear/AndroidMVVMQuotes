package emg.example.quotes.domain

import emg.example.quotes.data.database.entity.toDataBase
import emg.example.quotes.data.repository.QuoteRepository
import emg.example.quotes.domain.model.Quote
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()) {
            repository.deleteAllQuotes()
            repository.insertQuotes(quotes.map { it.toDataBase() })
            quotes
        } else {
            repository.getAllQuotesFromDataBase()
        }
    }
}