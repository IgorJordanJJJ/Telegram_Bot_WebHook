package ru.jordan.demo.service.rabbitmq.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.jordan.demo.facade.TelegramMassageFacade;
import ru.jordan.demo.service.rabbitmq.AnswerConsumer;

@RequiredArgsConstructor
@Service
public class AnswerConsumerImpl implements AnswerConsumer {

    private final TelegramMassageFacade telegramMassageFacade;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.answer-message}")
    public void consume(SendMessage sendMessage) {
        telegramMassageFacade.setView(sendMessage);
    }
}
