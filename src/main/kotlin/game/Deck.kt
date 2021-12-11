package game

import java.util.*


class Deck(inputString: String? = null) {

    private val cards: Stack<Card>

    init {
        cards = inputString?.let {
            fromString(inputString)
        } ?: randomDeck()
    }

    private fun fromString(inputString: String): Stack<Card> {
        val newDeck = Stack<Card>()
        inputString.split(",").reversed().forEach { newDeck.add(Card(it.trim())) }
        return newDeck
    }

    fun draw(): Card = cards.pop()

    fun cardsLeft() = cards.size


    private fun randomDeck(): Stack<Card> {
        val allCards = mutableSetOf<Card>()
        val newDeck = Stack<Card>()
        for (suit in Suit.values()) {
            for (rank in Rank.values()) {
                allCards.add(Card(suit, rank))
            }
        }
        while (allCards.isNotEmpty()) {
            val randomCard = allCards.random()
            newDeck.add(randomCard)
            allCards.remove(randomCard)
        }
        return newDeck
    }

}