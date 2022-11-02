package emg.example.quotes.domain

import emg.example.quotes.data.repository.QuoteRepository
import emg.example.quotes.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetQuoteUseCaseTest {

    @RelaxedMockK
    //@MockK
    private lateinit var quoteRepository: QuoteRepository

    private lateinit var getQuoteUseCase: GetQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuoteUseCase = GetQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when API returns Null return from database`() = runBlocking {
        //given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()
        //when
        getQuoteUseCase()
        //then
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDataBase() }
    }

    @Test
    fun `when API returns something return from API`() = runBlocking {
        //given
        val returnList = listOf(Quote("1", "1"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns returnList
        //when
        val response = getQuoteUseCase()
        //then
        coVerify(exactly = 1) { quoteRepository.deleteAllQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDataBase() }
        assert(returnList == response)
    }

}