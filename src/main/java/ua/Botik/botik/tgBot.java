package ua.Botik.botik;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class tgBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            sendMultipleMessages(chatId, update.getMessage().getText(), 100);
        }
    }
    private void sendMultipleMessages(String chatId, String text, int count) {
        for (int i = 0; i < count; i++) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text + " (message " + (i + 1) + ")");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    //Bots Name
    public String getBotUsername() {
        return "";
    }
    //Your BotsToken
    public String getBotToken(){
        return "";
    }
}
