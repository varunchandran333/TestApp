import app.cash.turbine.test
import com.training.testapp.data.model.User
import com.training.testapp.data.wrapper.NetworkResult
import com.training.testapp.repository.RepositoryInterface
import com.training.testapp.viewmodel.MainViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private val repository: RepositoryInterface = mockk()

    @Before
    fun setUp() {
        // Set up the test to use a TestCoroutineDispatcher
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `test userData flow emits loading and then success`() = runTest {
        // Arrange: Mock the repository to return a specific flow
        val mockData = listOf(User(id = 1, title = "John Doe"))
        val expectedResult = NetworkResult.Success(mockData)
        coEvery { repository.getApiData() } returns flow {
            emit(NetworkResult.Loading)
            emit(expectedResult)
        }

        // Act: Create the viewModel after mocking
        viewModel = MainViewModel(repository)

        // Assert: Use Turbine to test the flow emissions
        viewModel.userData.test {
            // First emission should be Loading
            assertEquals(NetworkResult.Loading, awaitItem())

            // Second emission should be Success
            assertEquals(expectedResult, awaitItem())

            // Ensure no more emissions
            awaitComplete()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the main dispatcher to the original Main dispatcher
    }
}