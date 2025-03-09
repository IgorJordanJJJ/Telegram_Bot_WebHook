package ru.jordan.demo.telegram.bot;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;


@Slf4j
@Getter
@Setter
public class TelegramBot extends SpringWebhookBot {
    private String botPath;
    private String botUsername;
    private String botToken;

    public TelegramBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        return null;
    }

    public Message sendAnswerMessage(SendMessage sendMessage){
        Message message = null;
        if (sendMessage != null){
            try{
                message = execute(sendMessage);
                return message;
            }catch (TelegramApiException e){
                log.error(e.toString());
            }
        }
        return null;
    }

}
