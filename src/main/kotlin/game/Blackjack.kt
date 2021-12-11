package game

import java.io.File


fun main(args: Array<String>) {
    val sam = Player("sam")
    val dealer = Player("dealer")
    val winner = playBlackJack(sam, dealer, Deck(if (args.isNotEmpty()) readFile(args[0]) else null))
    print("""
    ${winner.name}
    ${sam.showHand()} 
    ${dealer.showHand()}
            """)
}

private fun readFile(filePath: String) = File(filePath).readText()

fun playBlackJack(player: Player, dealer: Player, deck: Deck): Player {
    initialDraw(player, deck, dealer)

    if (player.hasBlackJack()) return player
    if (dealer.hasBlackJack()) return dealer
    if (dealer.isBust()) return player
    if(player.isBust()) return dealer //This isn't exactly like the rules, but..

    while(player.score() < 17){
        player drawFrom deck
        if(player.isBust()) return dealer
    }

    while(dealer.score() <= player.score()){
        dealer drawFrom deck
        if(dealer.isBust()) return player
    }

    return if(dealer.score() > player.score())  dealer else player
}

private fun initialDraw(player: Player, deck: Deck, dealer: Player) {
    player drawFrom deck
    dealer drawFrom deck
    player drawFrom deck
    dealer drawFrom deck
}