package emg.example.quotes.service.impl

import emg.example.quotes.model.Quote
import emg.example.quotes.service.QuoteService

class SimpleQuoteService : QuoteService {
    override fun quotes(): List<Quote> {
        return listOf(
            Quote("The way to get started is to quit talking and begin doing.", "Walt Disney"),
            Quote(
                "The pessimist sees difficulty in every opportunity. The optimist sees the opportunity in every difficulty.",
                "Winston Churchill"
            ),
            Quote("Don’t let yesterday take up too much of today.", "Will Rogers"),
            Quote(
                "You learn more from failure than from success. Don’t let it stop you. Failure builds character.",
                "Unknown"
            ),
            Quote(
                "It’s not whether you get knocked down, it’s whether you get up.",
                "Vince Lombardi"
            ),
        )
    }
}