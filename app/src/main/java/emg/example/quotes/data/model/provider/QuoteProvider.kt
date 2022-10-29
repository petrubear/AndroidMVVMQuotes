package emg.example.quotes.data.model.provider

import emg.example.quotes.data.model.Quote

class QuoteProvider {
    companion object {
        var quotes: List<Quote> = emptyList()
    }

    fun random(): Quote {
        return quotes.random()
    }
}