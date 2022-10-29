package emg.example.quotes.domain.model

import emg.example.quotes.data.database.entity.QuoteEntity
import emg.example.quotes.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain(): Quote {
    return Quote(quote, author)
}

fun QuoteEntity.toDomain(): Quote {
    return Quote(quote, author)
}