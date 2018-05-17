import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;        // Aqui importem totes les llibreries necessaries tant per
import java.net.MalformedURLException;   // a fer cURL ( Una demanda d'informacio a una web d'Internet )
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import org.telegram.telegrambots.api.methods.send.SendMessage;      // Importem totes les llibreries de Telegram de manera
import org.telegram.telegrambots.api.objects.Update;                // que pugem fer servir totes les seues funcions.
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class JarvisBattleBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateRecived(Update update){
    // ALL
    // We check if the update has a message and the message has text --> Verifiquem si la update te un missatge y si el missatge te text
    if(update.hasMessage() && update.getMessage().hasText()){
      // Set variables --> Establim les variables
      String message_text = update.getMessage().getText();
      long chat_id = update.getMessage().getChatId();

      SendMessage message = new SendMessage() // Create a message object --> Creem un objecte de missatge
      .setChatId(chat_id)
      .setText(message_text);

      try{
        execute(message); // Sending your message object to user --> Enviem el missatge objecte cap a l'usuari
      }catch (TelegramApiException e){
        e.printStackTrace();
      }
    }
  }

  @Override
  public String getBotUsername(){
    // Return bot username -->  Retorne el nom d'usuari del bot
    // If bot username is @Jarvis-Battlebot, it must return 'Jarvis-Battlebot' --> Si el nom del teu bot es @Jarvis-Battlebot,
    // tu necessites retornar 'Jarvis_Battlebot'
    return "JarvisBattleBot";
  }

  @Override
  public String getBotToken(){
    // Return bot token from BothFather --> Reotrna el token del bot desde BothFather
    return "594526118:AAHA5lDB9RQ6WfuFfyGDaRGMh_MPvGnz3ug";
  }


public static void main(String[] args) {
  // ALL Initialize API Context --> Initzialitzem el contexte de la API
  ApiContextInitializer.init();
  // ALL Instantiate Telegram Bots api --> Instanciem la API de Bots de Telegram
  TelegramBotsApi botsApi = new TelegramBotsApi();
  // ALL Register your Bot --> Registra el teu Bot
  try{
    botsApi.registerBot(new JarvisBattleBot());
  }catch (TelegramApiException e){
    e.printStackTrace();
  }
}
}
