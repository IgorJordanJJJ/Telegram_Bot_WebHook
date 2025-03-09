package ru.jordan.demo.service.rabbitmq;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateProducer {

    void produce(String rabbitQueue, Update update);
}
