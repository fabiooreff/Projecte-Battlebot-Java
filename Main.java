// Importem les llibreries de la API de Telegram per a Java
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.generics.LongPollingBot;

public class Main{
public static void main(String[] args) {
  // ALL Initialize API Context --> Initzialitzem el contexte de la API
  ApiContextInitializer.init();
  // ALL Instantiate Telegram Bots api --> Instanciem la API de Bots de Telegram
  TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
  // ALL Register your Bot --> Registra el teu Bot
  try{
    telegramBotsApi.registerBot(new JarvisBattleBot());
  }catch (TelegramApiException e){
    e.printStackTrace();
  }
    System.out.println("¡Jarvis Successfull started!");
}
}
