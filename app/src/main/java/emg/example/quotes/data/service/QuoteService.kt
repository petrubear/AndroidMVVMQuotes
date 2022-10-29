package emg.example.quotes.data.service

import emg.example.quotes.data.model.QuoteModel

interface QuoteService {
    fun quotes(): List<QuoteModel>
}