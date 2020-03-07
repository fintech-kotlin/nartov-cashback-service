package ru.tinkoff.fintech.service.notification

class CardNumberMaskerImpl : CardNumberMasker {

    override fun mask(cardNumber: String, maskChar: Char, start: Int, end: Int): String {

        return when {
            cardNumber == ""        -> ""
            end > cardNumber.length -> "################"
            end < start             -> throw  IllegalArgumentException()
            else                    -> cardNumber.replaceRange(start, end, maskChar.toString().repeat(end - start))
        }
    }
}