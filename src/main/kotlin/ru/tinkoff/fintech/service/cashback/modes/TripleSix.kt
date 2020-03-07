package ru.tinkoff.fintech.service.cashback.modes

import ru.tinkoff.fintech.model.TransactionInfo

class TripleSix : CashbackMode {
    override fun calculate(transactionInfo: TransactionInfo): Double {
        with(transactionInfo) {
            return if (transactionSum%666==0.0) 6.66 else .0
        }
    }
}