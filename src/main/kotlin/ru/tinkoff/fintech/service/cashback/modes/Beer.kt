package ru.tinkoff.fintech.service.cashback.modes

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BEER
import ru.tinkoff.fintech.service.cashback.MCC_BEER
import java.text.SimpleDateFormat
import java.util.*

class Beer : CashbackMode {
    override fun calculate(transactionInfo: TransactionInfo): Double {
        with(transactionInfo) {
            if (loyaltyProgramName == LOYALTY_PROGRAM_BEER && mccCode == MCC_BEER)
            {
                return when
                {
                    firstName.equals("олег", true) -> when {
                        lastName.equals("олегов", true) -> 0.1 * transactionSum
                        else                            -> 0.07 * transactionSum
                    }
                    else                           -> {
                        var calendar = GregorianCalendar()
                        when {
                            SimpleDateFormat("MMM", Locale("ru")).format(calendar.time)[0].equals(firstName[0],true) -> 0.05*transactionSum
                            else                                                                                     -> {
                                calendar.add(Calendar.MONTH, 1)
                                SimpleDateFormat("MMM", Locale("ru")).format(calendar.time)[0].toString()
                                when {
                                    SimpleDateFormat("MMM", Locale("ru")).format(calendar.time)[0].equals(firstName[0],true) -> 0.03*transactionSum
                                    else                                                                                     -> {
                                        calendar.add(Calendar.MONTH, -2)
                                        SimpleDateFormat("MMM", Locale("ru")).format(calendar.time)[0].toString()
                                        when {
                                            SimpleDateFormat("MMM", Locale("ru")).format(calendar.time)[0].equals(firstName[0],true) -> 0.03*transactionSum
                                            else                                                                                     -> 0.02 * transactionSum
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else return .0
        }
    }
}