package game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DeckTest {

    @Test
    fun `Should populate an empty deck`(){
        assertEquals(Deck().cardsLeft(), 52)
    }

    @Test
    fun `Should populate a deck from string`(){
        val deck = Deck("CA, D4, H7")
        assertEquals(deck.draw().toString(), "CA")
        assertEquals(deck.draw().toString(), "D4")
        assertEquals(deck.draw().toString(), "H7")
        assertEquals(deck.cardsLeft(), 0)
    }

}