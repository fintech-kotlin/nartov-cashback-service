package ru.tinkoff.fintech.service.cashback.modes

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BLACK

class Black : CashbackMode {
    override fun calculate(transactionInfo: TransactionInfo): Double {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        with(transactionInfo) {
            return if (loyaltyProgramName == LOYALTY_PROGRAM_BLACK) transactionSum * 0.01 else .0
        }
    }
}