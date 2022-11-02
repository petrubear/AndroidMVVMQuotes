package emg.example.quotes.domain

import emg.example.quotes.data.repository.QuoteRepository
import emg.example.quotes.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when database is empty returns null`() = runBlocking {
        //given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns emptyList()
        //when
        val result = getRandomQuoteUseCase()
        //then
        assert(result == null)
    }

    @Test
    fun `when database is not empty returns random quote`() = runBlocking {
        val quoteList = listOf(Quote("1", "1"))
        //given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns quoteList
        //when
        val result = getRandomQuoteUseCase()
        //then
        assert(result == quoteList.first())
    }
}