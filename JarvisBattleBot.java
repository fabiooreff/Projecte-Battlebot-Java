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

// Declarem la clase on fiquem tots els nostres metodes i funcions del bot extenentla amb la de Telegram
public class JarvisBattleBot extends TelegramLongPollingBot {

    // onUpdateReceived s'encarrega de comprovar les actualitzacions del canal per si enviem missatges o solicitem les funcions
    @Override
    public void onUpdateReceived(Update update) {
        // ALL
        // Comanda correcta?
        boolean CommandCorrect = false;

        // Verifiquem si la update te un missatge
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        // Declarem la variable command i la inicialitzem, de la mateixa manera tenim que instanciar la funcio d'enviament de missatges
        String command = update.getMessage().getText().trim();
        SendMessage message = new SendMessage();

        // Aqui tractem el comando /help de manera que desplege un missatge amb la informacio de les funcions principals, el missatge nombre
        // el nom d'usuari de la persona que l'execute
        if (command.equals("/help")) {
            CommandCorrect = true;
            message.setText("Hello " + update.getMessage().getFrom().getFirstName() + " This are my functions:"
                    + " /help - Invoke all commands"
                    + " /myname - Return your name"
                    + " /myfullname - Return your fullname"
                    + " /battlefieldnews - Return link of the Battlefield news"
                    + " /battlefieldcalendar - Return link of the Battlefield calendar"
                    + " /battlefieldforums - Return link of the Battlefield forums"
                    + " /battlefieldvideos - Return link of the Battlefield Youtube channel"
                    + " /battletime - Call members group for play Battlefield"
                    + " /markup - Show keyboard with functions in screen");
        }

        // En totes les linies if() marquem l'execucio de una funcio y la sortida que donara
        if (command.equals("/myname")) {
            CommandCorrect = true;
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/mylastname")) {
            CommandCorrect = true;
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")) {
            CommandCorrect = true;
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/battlefieldnews")) {
            CommandCorrect = true;
            message.setText("Battlefield News: https://www.battlefield.com/en-us/news");
        }
        
        if (command.equals("/battlefieldcalendar")) {
            CommandCorrect = true;
            message.setText("Battlefield Calendar: https://www.battlefield.com/en-us/calendar");
        } 

        if (command.equals("/battlefieldforums")) {
            CommandCorrect = true;
            message.setText("Battlefield Forums: https://forums.battlefield.com/en-us/");
        } 

        if (command.equals("/battlefieldvideos")) {
            CommandCorrect = true;
            message.setText("Battlefield Youtube Channel: https://www.youtube.com/user/Battlefield/featured");
        } 
        
        if (command.equals("/battletime")){
            CommandCorrect = true;
            message.setText("Join the Battle! @UserAlias @UserAlias @UserAlias @UserAlias @UserAlias @UserAlias ");
        }
        
         // Amb KeybiardMarkup creem un keboard screen per al bot, on dintre de cada fila marquem una funcio, d'esta manera no hi ha que escriure les funcions a ma
         if(command.equals("/markup")){
             CommandCorrect = true;
             message.setText("Here is your keyboard "+ update.getMessage().getFrom().getFirstName());
             
             ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
             List<KeyboardRow> keyboard = new ArrayList<>();
             KeyboardRow row = new KeyboardRow();
             
             row.add("/myname");
             row.add("/myfullname");
             row.add("/battlefieldnews");
             keyboard.add(row);
             
             row = new KeyboardRow();
             
             row.add("/battlefieldcalendar");
             row.add("/battlefieldforums");
             row.add("/battlefieldvideos");
             keyboard.add(row);
             
             row = new KeyboardRow();
             
             row.add("/battletime");
             keyboard.add(row);
             
             keyboardMarkup.setKeyboard(keyboard);
             message.setReplyMarkup(keyboardMarkup);  
         }
         
         // Este ultim if() tracte els Strings mal escrits o que no equivalen a alguna funcio i retorne una frase informativa nombran a l'usuari
         if (!CommandCorrect) {
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
        // Retorne el nom d'usuari del bot
        // Si el nom del teu bot es @JarvisBattleBot,
        // tu necessites retornar 'JarvisBattleBot'
        return "JarvisBattleBot";
    }

    @Override
    public String getBotToken() {
        // Reotrna el token del bot desde BothFather, el token es la API Key que fa servir Telegram per a comunicar els bots amb el codi.
        return "You Telegram token Here";
    }
}
