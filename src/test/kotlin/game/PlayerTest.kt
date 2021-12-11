package game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PlayerTest {

    @Test
    fun `Should be able to draw cards and get the right score`(){
        val deck = Deck("C4, CA")
        val player = Player("")
        player drawFrom deck
        player drawFrom deck
        assertEquals(player.score(), 15)
    }

}