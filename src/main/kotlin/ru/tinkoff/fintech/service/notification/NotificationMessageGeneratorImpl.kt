package ru.tinkoff.fintech.service.notification

import ru.tinkoff.fintech.model.NotificationMessageInfo

class NotificationMessageGeneratorImpl(
    private val cardNumberMasker: CardNumberMasker
) : NotificationMessageGenerator {

    override fun generateMessage(notificationMessageInfo: NotificationMessageInfo): String {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return """Уважаемый, ${notificationMessageInfo.name}!
Спешим Вам сообщить, что на карту ${cardNumberMasker.mask(cardNumber = notificationMessageInfo.cardNumber, end = 12)}
начислен cashback в размере ${notificationMessageInfo.cashback}
за категорию ${notificationMessageInfo.category}.
Спасибо за покупку ${notificationMessageInfo.transactionDate}"""
    }
}