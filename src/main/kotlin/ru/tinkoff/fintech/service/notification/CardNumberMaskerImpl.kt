package ru.tinkoff.fintech.service.notification

class CardNumberMaskerImpl : CardNumberMasker
{

    override fun mask(cardNumber: String, maskChar: Char, start: Int, end: Int): String
    {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when
        {
            cardNumber == ""      -> return ""
            end>cardNumber.length -> return "################"
            else                  -> return cardNumber.replaceRange(start,end, maskChar.toString().repeat(end-start))
        }
    }
}