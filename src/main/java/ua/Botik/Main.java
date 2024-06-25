package ua.Botik;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ua.Botik.botik.tgBot;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new tgBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}