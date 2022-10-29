package emg.example.quotes.data.service.impl

import emg.example.quotes.data.model.QuoteModel
import emg.example.quotes.data.service.QuoteService

class SimpleQuoteService : QuoteService {
    override fun quotes(): List<QuoteModel> {
        return listOf(
            QuoteModel("The way to get started is to quit talking and begin doing.", "Walt Disney"),
            QuoteModel(
                "The pessimist sees difficulty in every opportunity. The optimist sees the opportunity in every difficulty.",
                "Winston Churchill"
            ),
            QuoteModel("Don’t let yesterday take up too much of today.", "Will Rogers"),
            QuoteModel(
                "You learn more from failure than from success. Don’t let it stop you. Failure builds character.",
                "Unknown"
            ),
            QuoteModel(
                "It’s not whether you get knocked down, it’s whether you get up.",
                "Vince Lombardi"
            ),
        )
    }
}