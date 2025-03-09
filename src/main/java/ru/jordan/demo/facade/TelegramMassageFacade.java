package ru.jordan.demo.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.jordan.demo.service.message.impl.MessageServiceImpl;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramMassageFacade {

    private final MessageServiceImpl messageService;
    public void processUpdate(Update update) {
        messageService.processUpdate(update);
    }

    public void setView(SendMessage sendMessage) {
        messageService.setView(sendMessage);
    }
}
