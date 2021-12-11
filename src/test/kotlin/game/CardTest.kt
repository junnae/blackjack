package game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CardTest {

    @Test
    fun `should be able to create card from string and get the right value`() {
        assertEquals(Card("C4").value(), 4)
        assertEquals(Card("DA ").value(), 11)
        assertEquals(Card("SJ ").value(), 10)
        assertEquals(Card("H10 ").value(), 10)
    }

    @Test
    fun `should represent cards correctly`() {
        assertEquals(Card("DA").toString(), "DA")
        assertEquals(Card("C10").toString(), "C10")
        assertEquals(Card("H2").toString(), "H2")
    }
}