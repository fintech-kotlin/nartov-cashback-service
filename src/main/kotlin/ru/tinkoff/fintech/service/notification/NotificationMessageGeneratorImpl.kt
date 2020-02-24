package ru.tinkoff.fintech.service.notification

import ru.tinkoff.fintech.model.NotificationMessageInfo

class NotificationMessageGeneratorImpl(
    private val cardNumberMasker: CardNumberMasker
) : NotificationMessageGenerator
{

    override fun generateMessage(notificationMessageInfo: NotificationMessageInfo): String
    {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return "Уважаемый, "+notificationMessageInfo.name+"!\n" +
               "Спешим Вам сообщить, что на карту " +
               cardNumberMasker.mask(notificationMessageInfo.cardNumber,'#',0,12) + "\n"+
               "начислен cashback в размере " +
               notificationMessageInfo.cashback+"\n"+
               "за категорию "+
               notificationMessageInfo.category +"." + "\n" +
               "Спасибо за покупку " +
               notificationMessageInfo.transactionDate
    }
}