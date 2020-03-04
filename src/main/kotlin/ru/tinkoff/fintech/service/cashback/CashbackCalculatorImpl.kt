package ru.tinkoff.fintech.service.cashback

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.modes.All
import ru.tinkoff.fintech.service.cashback.modes.Black
import ru.tinkoff.fintech.service.cashback.modes.TripleSix
import kotlin.math.round

internal const val LOYALTY_PROGRAM_BLACK = "BLACK"
internal const val LOYALTY_PROGRAM_ALL = "ALL"
internal const val LOYALTY_PROGRAM_BEER = "BEER"
internal const val MAX_CASH_BACK = 3000.0
internal const val MCC_SOFTWARE = 5734
internal const val MCC_BEER = 5921

class CashbackCalculatorImpl : CashbackCalculator {

    override fun calculateCashback(transactionInfo: TransactionInfo): Double {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val modes = listOf(Black(), TripleSix(), All())
        var result: Double = .0
        //var result2 = modes.reduce {result, mode ->  result + mode.calculate(transactionInfo)}

        for (f in modes) {
            result += f.calculate(transactionInfo)
        }

        return minOf(3000.0 - transactionInfo.cashbackTotalValue, result)
    }

}

