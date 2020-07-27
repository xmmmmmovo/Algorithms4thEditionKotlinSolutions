import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

class FilereadTest {
    var f:File? = null

    @BeforeEach
    fun configureSystemUnderTest() {
        f = File("./data/a.txt")
    }

    @Test
    @DisplayName("Should return the correct message")
    fun shouldReturnCorrectMessage() {
        Assertions.assertThat(f?.readText()).isEqualTo("aaaaa")
    }
}