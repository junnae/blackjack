package game

class Player(
    val name: String
) {
    private val hand: MutableSet<Card> = mutableSetOf()

    infix fun drawFrom(deck: Deck) = hand.add(deck.draw())
    fun score() = hand.sumOf(Card::value)
    fun hasBlackJack() = hand.sumOf(Card::value) == 21
    fun isBust() = score() > 21
    fun showHand() = "$name: ${hand.joinToString(", ")}"
}