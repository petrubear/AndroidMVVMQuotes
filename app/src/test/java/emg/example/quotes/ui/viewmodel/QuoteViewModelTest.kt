package emg.example.quotes.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import emg.example.quotes.domain.GetQuoteUseCase
import emg.example.quotes.domain.GetRandomQuoteUseCase
import emg.example.quotes.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {
    private lateinit var quoteViewModel: QuoteViewModel

    @RelaxedMockK
    private lateinit var getQuoteUseCase: GetQuoteUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuoteUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created, get all quotes and set the first value`() = runTest {
        // Given
        val quoteList = listOf(Quote("2", "2"))
        coEvery { getQuoteUseCase() } returns quoteList
        // When
        quoteViewModel.onCreate()
        // Then
        assert(quoteViewModel.quoteModel.value == quoteList.random())
    }

    @Test
    fun `when viewmodel gets a quote, set live data`() = runTest {
        // Given
        val quote = Quote("1", "1")
        coEvery { getRandomQuoteUseCase() } returns quote
        // When
        quoteViewModel.randomQuote()
        // Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    @Test
    fun `ir randomQuote returns null keep last value in live data`() = runTest {
        // Given
        val quote = Quote("1", "1")
        quoteViewModel.quoteModel.value = quote
        coEvery { getRandomQuoteUseCase() } returns null
        // When
        quoteViewModel.randomQuote()
        // Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

}