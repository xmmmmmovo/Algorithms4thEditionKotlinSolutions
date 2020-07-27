import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/*
 * @author xmmmmmovo
 * @date 2020/7/27 13:40
 * @description 测试类
 * @since version-1.0
 */
class MessageServiceTest {
    var m = ""

    @BeforeEach
    fun configureSystemUnderTest() {
        m = "Hello World!"
    }

    @Test
    @DisplayName("Should return the correct message")
    fun shouldReturnCorrectMessage() {
        assertThat(m).isEqualTo("Hello World!")
    }
}