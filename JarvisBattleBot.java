// Importem totes les llibreries de Tetegram per a Java
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.generics.LongPollingBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
// Importem tambe totes les llibreries necessaries per a poder fer conexions a webs externes i
// importar informacio desde les mateixes.
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.Override;
//import java.net.Authenticator;
//import java.net.MalformedURLException;
//import java.net.PasswordAuthentication;
//import java.net.URL;
//import java.net.URLConnection;

public class JarvisBattleBot extends TelegramLongPollingBot {
  @Override
  public void  onUpdateReceived(Update update){
    // ALL
    // We check if the update has a message and the message has text --> Verifiquem si la update te un missatge y si el missatge te text
    System.out.println(update.getMessage().getText());
    System.out.println(update.getMessage().getFrom().getFirstName());

    String command=update.getMessage().getText();
    SendMessage message=new SendMessage();

    if(command.equals("/myname")){
      System.out.println(update.getMessage().getFrom().getFirstName());
      message.setText(update.getMessage().getFrom().getFirstName());
    }

    if(command.equals("/mylastname")){
      System.out.println(update.getMessage().getFrom().getLastName());
      message.setText(update.getMessage().getFrom().getLastName());
    }

    if(command.equals("/myfullname")){
      System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
      message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
    }
    
    if(command.equals("/battlefieldnews")){
      message.setText("Ultimes Novetats de Battlefield en --> https://www.battlefield.com/es-es/news");
    }
  
    message.setChatId(update.getMessage().getChatId());
    try{
      execute(message);
    }catch (TelegramApiException e){
      e.printStackTrace();
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
}
