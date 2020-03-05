package ru.tinkoff.fintech.service.cashback.modes

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_ALL
import ru.tinkoff.fintech.service.cashback.MCC_SOFTWARE
import kotlin.math.ceil

class All : CashbackMode {
    override fun calculate(transactionInfo: TransactionInfo): Double {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        with(transactionInfo)
        {
            if (loyaltyProgramName == LOYALTY_PROGRAM_ALL && mccCode == MCC_SOFTWARE) {
                var kop = ceil(transactionSum * 100).toInt()
                if (isPalindrome(kop.toString(), 1))
                    return lcm(firstName.length, lastName.length)*transactionSum/100_000.0
            }
            else return .0
        }
        return .0
    }

    fun isPalindrome(s: String, treshold: Int): Boolean {
        var tres = treshold
        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - i - 1]) {
                if (tres-- == 0) return false
            }
        }
        return true
    }

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return a / gcd(a, b) * b
    }
}