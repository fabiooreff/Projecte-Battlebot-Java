// Importem les llibreries de la API de Telegram per a Java
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.generics.LongPollingBot;

public class Main{
public static void main(String[] args) {
  // Initzialitzem el contexte de la API
  ApiContextInitializer.init();
  // Instanciem la API de Bots de Telegram
  TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
  // Registremel nostre Bot
  try{
    telegramBotsApi.registerBot(new JarvisBattleBot());
  }catch (TelegramApiException e){
    e.printStackTrace();
  }
    // Este println llançe un missatge per pantalla per notificar la correcta inicialitzacio del bot
    System.out.println("¡Jarvis Successfull started!");
}
}
