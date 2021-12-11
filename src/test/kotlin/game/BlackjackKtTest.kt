package game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BlackjackKtTest{

    @Test
    fun `Player should win when both players start with blackjack`(){
        assertEquals(playBlackJack(Player("p"), Player("d"), Deck("CA,HA,CJ,HJ")).name, "p")
    }

    @Test
    fun `Player should win when both players start bust`(){
        assertEquals(playBlackJack(Player("p"), Player("d"), Deck("CA,HA,DA,SA")).name, "p")
    }

    @Test
    fun `Should pass supplied test`(){
        assertEquals(playBlackJack(Player("p"), Player("d"), Deck("CA, D5, H9, HQ, S8")).name, "p")
    }
}