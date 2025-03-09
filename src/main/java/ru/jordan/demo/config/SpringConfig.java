package ru.jordan.demo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.jordan.demo.telegram.bot.TelegramBot;

@Configuration
@AllArgsConstructor
public class SpringConfig {
    private final TelegramBotConfig telegramBotConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramBotConfig.getWebhookPath()).build();
    }

    @Bean
    public TelegramBot springWebhookBot(SetWebhook setWebhook) {
        TelegramBot bot = new TelegramBot(setWebhook);
        bot.setBotToken(telegramBotConfig.getBotToken());
        bot.setBotUsername(telegramBotConfig.getBotName());
        bot.setBotPath(telegramBotConfig.getWebhookPath());
        return bot;
    }

    @Bean
    public DefaultBotOptions options() {
        return new DefaultBotOptions();
    }

    @Bean(name = "botToken")
    public String botToken() {
        return telegramBotConfig.getBotToken();
    }

}
