package ru.jordan.demo.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBotConfig {
    @Value("${telegram.bot.webhook-path}")
    String webhookPath;
    @Value("${telegram.bot.username}")
    String botName;
    @Value("${telegram.bot.token}")
    String botToken;
}
