package ru.tinkoff.fintech.service.cashback.modes

import ru.tinkoff.fintech.model.TransactionInfo

interface CashbackMode {
    fun calculate(transactionInfo: TransactionInfo): Double
}