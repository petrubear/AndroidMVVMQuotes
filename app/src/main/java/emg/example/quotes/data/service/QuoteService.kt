package emg.example.quotes.data.service

import emg.example.quotes.data.model.Quote

interface QuoteService {
    fun quotes(): List<Quote>
}