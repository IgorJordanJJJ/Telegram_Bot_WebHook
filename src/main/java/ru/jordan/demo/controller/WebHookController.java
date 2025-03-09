package ru.jordan.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.jordan.demo.facade.TelegramMassageFacade;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebHookController {

    private final TelegramMassageFacade telegramMassageFacade;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        log.info(update.toString());
        if (update.hasCallbackQuery()){
            String call_data = update.getCallbackQuery().getData();
            log.info(call_data);
            return null;
        }
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setText("Чтобы увидеть картины, нажми на фамилию художника или перейди в полную коллекцию на сайте музея");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Аврезе");
        inlineKeyboardButton1.setCallbackData("АВРЕЗЕ");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Аликс Ив");
        inlineKeyboardButton2.setCallbackData("АЛИКС");
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Амелин");
        inlineKeyboardButton3.setCallbackData("АМЕЛИН");
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText("Арстер");
        inlineKeyboardButton4.setCallbackData("АРСТЕР");
        rowInline2.add(inlineKeyboardButton3);
        rowInline2.add(inlineKeyboardButton4);



        List<InlineKeyboardButton> rowInline11 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText("Переход на внешний сайт");
        inlineKeyboardButton21.setUrl("https://collections.hermitagemuseum.org");
        inlineKeyboardButton21.setCallbackData("ПЕРЕХОД НА ВНЕШНИЙ САЙТ");
        rowInline11.add(inlineKeyboardButton21);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline11);

        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;
        //telegramMassagePipelineFacade.processUpdate(update);
        //return null;
    }

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok().build();
    }
}
