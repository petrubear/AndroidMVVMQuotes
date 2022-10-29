package emg.example.quotes.service

import emg.example.quotes.model.Quote

interface QuoteService {
    fun quotes(): List<Quote>
}