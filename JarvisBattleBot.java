// Importem totes les llibreries de Tetegram per a Java
import  java.util.ArrayList ;
import  java.util.Comparator ;
import  java.util.List ;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.generics.LongPollingBot;
import  org.telegram.telegrambots.api.methods.send.SendPhoto ;
import  org.telegram.telegrambots.api.objects.PhotoSize ;
import  org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup ;
import  org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove ;
import  org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow ;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class JarvisBattleBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // ALL
        //Comanda correcta?
        boolean comanda = false;

        // We check if the update has a message and the message has text --> Verifiquem si la update te un missatge y si el missatge te text
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText().trim();
        SendMessage message = new SendMessage();

        if (command.equals("/help")) {
            comanda = true;
            message.setText("Hello " + update.getMessage().getFrom().getFirstName() + " This are my functions:"
                    + " /help - Invoke all commands"
                    + " /myname - Return your name"
                    + " /myfullname - Return your fullname"
                    + " /battlefieldnews - Return link of the Battlefield news"
                    + " /battlefieldcalendar - Return link of the Battlefield calendar"
                    + " /battlefieldforums - Return link of the Battlefield forums"
                    + " /battlefieldvideos - Return link of the Battlefield Youtube channel");
        }

        if (command.equals("/myname")) {
            comanda = true;
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/mylastname")) {
            comanda = true;
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")) {
            comanda = true;
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/battlefieldnews")) {
            comanda = true;
            message.setText("Battlefield News: https://www.battlefield.com/en-us/news");
        }
        
        if (command.equals("/battlefieldcalendar")) {
            comanda = true;
            message.setText("Battlefield Calendar: https://www.battlefield.com/en-us/calendar");
        } 

        if (command.equals("/battlefieldforums")) {
             comanda = true;
            message.setText("Battlefield Forums: https://forums.battlefield.com/en-us/");
        } 

        if (command.equals("/battlefieldvideos")) {
             comanda = true;
            message.setText("Battlefield Youtube Channel: https://www.youtube.com/user/Battlefield/featured");
        } 
        
         if (!comanda) {
            message.setText("Sorry " + update.getMessage().getFrom().getFirstName() + " I do not know the command");
        }
         
         
         

        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        // Return bot username -->  Retorne el nom d'usuari del bot
        // If bot username is @Jarvis-Battlebot, it must return 'Jarvis-Battlebot' --> Si el nom del teu bot es @Jarvis-Battlebot,
        // tu necessites retornar 'Jarvis_Battlebot'
        return "JarvisBattleBot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BothFather --> Reotrna el token del bot desde BothFather
        return "594526118:AAHA5lDB9RQ6WfuFfyGDaRGMh_MPvGnz3ug";
    }
}
