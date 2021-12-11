package game

class Card {

    private val suit: Suit
    private val rank: Rank

    companion object {
        private fun String.charAt(index: Int): String {
            val charArray = this.toCharArray()
            if (index >= charArray.size) return ""
            return charArray[index].toString()
        }
    }

    constructor(inputString: String) {
        suit = Suit.values().first { inputString.charAt(0) == it.shortName }
        rank = Rank.values().first { (inputString.charAt(1) + inputString.charAt(2)).trim() == it.shortName }
    }

    internal constructor(suit: Suit, rank: Rank) {
        this.suit = suit
        this.rank = rank
    }

    override fun toString(): String = suit.shortName + rank.shortName

    fun value() = rank.value
}

internal enum class Suit(val shortName: String) {
    Clubs("C"), Diamonds("D"), Hearts("H"), Spades("S")
}

internal enum class Rank(val shortName: String, val value: Int) {
    Ace("A", 11),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("J", 10),
    Queen("Q", 10),
    King("K", 10),
}

