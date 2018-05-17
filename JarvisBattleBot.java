// Importem totes les llibreries de Tetegram per a Java
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
// Importem tambe totes les llibreries necessaries per a poder fer conexions a webs externes i
// importar informacio desde les mateixes.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Override;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

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
