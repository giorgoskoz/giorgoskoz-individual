/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.view;

/**
 *
 * @author giorgoskoz
 */
public class ItaUI implements UI {
    
    private static final String ANSI_RED = "\u001B[31m";
    
    private String splashScreen = ANSI_RED + "Something went wrong, try again later\n"
                                + ANSI_RED + "BUILD FAILED";
    private String welcome = ".           ..         .           .       .           .           .\n" +
"      .         .            .          .       .\n" +
"            .         ..xxxxxxxxxx....               .       .             .\n" +
"    .             MWMWMWWMWMWMWMWMWMWMWMWMW                       .\n" +
"              IIIIMWMWMWMWMWMWMWMWMWMWMWMWMWMttii:        .           .\n" +
" .      IIYVVXMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWxx...         .           .\n" +
"     IWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMWMx..\n" +
"   IIWMWMWMWMWMWMWMWMWBY%ZACH%AND%OWENMWMWMWMWMWMWMWMWMWMWMWMWMx..        .\n" +
"    \"\"MWMWMWMWMWM\"\"\"\"\"\"\"\".  .:..   .\"\"\"\"\"MWMWMWMWMWMWMWMWMWMWMWMWMWti.\n" +
" .     \"\"   . `  .: . :. : .  . :.  .  . . .  \"\"\"\"MWMWMWMWMWMWMWMWMWMWMWMWMti=\n" +
"        . .   :` . :   .  .'.' '....xxxxx...,'. '   ' .\"\"\"YWMWMWMWMWMWMWMWMWMW+\n" +
"     ; . ` .  . : . .' :  . ..XXXXXXXXXXXXXXXXXXXXx.    `     . \"YWMWMWMWMWMWMW\n" +
".    .  .  .    . .   .  ..XXXXXXXXWWWWWWWWWWWWWWWWXXXX.  .     .     \"\"\"\"\"\"\"\n" +
"        ' :  : . : .  ...XXXXXWWW\"   W88N88@888888WWWWWXX.   .   .       . .\n" +
"   . ' .    . :   ...XXXXXXWWW\"    M88N88GGGGGG888^8M \"WMBX.          .   ..  :\n" +
"         :     ..XXXXXXXXWWW\"     M88888WWRWWWMW8oo88M   WWMX.     .    :    .\n" +
"           \"XXXXXXXXXXXXWW\"       WN8888WWWWW  W8@@@8M    BMBRX.         .  : :\n" +
"  .       XXXXXXXX=MMWW\":  .      W8N888WWWWWWWW88888W      XRBRXX.  .       .\n" +
"     ....  \"\"XXXXXMM::::. .        W8@889WWWWWM8@8N8W      . . :RRXx.    .\n" +
"         ``...'''  MMM::.:.  .      W888N89999888@8W      . . ::::\"RXV    .  :\n" +
" .       ..'''''      MMMm::.  .      WW888N88888WW     .  . mmMMMMMRXx\n" +
"      ..' .            \"\"MMmm .  .       WWWWWWW   . :. :,miMM\"\"\"  : \"\"`    .\n" +
"   .                .       \"\"MMMMmm . .  .  .   ._,mMMMM\"\"\"  :  ' .  :\n" +
"               .                  \"\"MMMMMMMMMMMMM\"\"\" .  : . '   .        .\n" +
"          .              .     .    .                      .         .\n" +
".                                         .          .         .";
    private String promptUsername = "Nome utente: ";
    private String promptPassword = "Parola d'ordine: ";
    private String promptWrongUsername = "Nessun nome utente";
    private String promptWrongPassword = "Parola d'ordine errata";
    private String promptId = "id: ";
    private String promptDate = "Data: ";
    private String promptSender = "Mittente: ";
    private String promptReceiver = "Ricevitore: ";
    private String separator = "  |  ";
    private String ownMessagesIntro = "I tuoi messaggi: (Più nuovo in basso)";
    private String youAreBanned = "**Sei bannato. Prega per i poteri che questo è stato ripristinato**";
    private String restrictedUserMainMenu = "Scegliere un'opzione:\n"
                                          + "1 " + separator + "Smettere\n" 
                                          + "2 " + separator + "Mostra messaggi";
    private String regularUserMainMenu = restrictedUserMainMenu + "\n" 
                                          + "3 " + separator + "Invia messaggio\n" 
                                          + "4 " + separator + "Cancella il messaggio\n" 
                                          + "5 " + separator + "Mostra tutti gli utenti";
    private String viewerMainMenu = regularUserMainMenu + "\n" 
                                          + "6 " + separator + "Read other user messages\n" 
                                          + "7 " + separator + "Read all messages";
    private String editorMainMenu = viewerMainMenu + "\n" 
                                          + "8 " + separator + "Modifica altro messaggio utente";
    private String deleterMainMenu = editorMainMenu + "\n" 
                                          + "9 " + separator + "Elimina altro messaggio utente";
    private String superAdminMenu = deleterMainMenu + "\n" 
                                          + "10" + separator + "Crea un nuovo utente\n" 
                                          + "11" + separator + "Modifica nome utente di utente\n" 
                                          + "12" + separator + "Modifica la password dell'utente\n"
                                          + "13" + separator + "Cambia il ruolo dell'utente\n"
                                          + "14" + separator + "Elimina utente\n"
                                          + "15" + separator + "Leggi i messaggi archiviati";
    private String goodbye = "Ci vediamo nell'ombra, fratello";
    private String invalidOption = "Opzione non valida, riprova";
    private String promptBanned = "Vietato: ";
    private String allUsersIntro = "Elenco di tutti gli utenti: ";
    private String messageDeletionPromt = "Scegli l'id del messaggio da eliminare: ";
    private String messageDeletionConfirmation = "Messaggio cancellato con successo";
    private String chooseUserToMessagePrompt = "Scegli l'id dell'utente per messaggio: ";
    private String inputMessagePrompt = "Scrivi il tuo messaggio: ";
    private String messageSentSuccess = "Messaggio inviato con successo";
    private String readOtherUserMessagesIntro = "Scegli l'ID dell'utente per vedere i messaggi: ";
    private String readAllMessagesIntro = "Elenco di tutti i messaggi: ";
    private String editOtherUserMessageIntro = "Scegli l'id del messaggio da modificare: ";
    private String editMessagePrompt = "Type the new content of the message: ";
    private String editMessageSuccess = "Digita il nuovo contenuto del messaggio";
    private String editMessageFailure = "Impossibile modificare il messaggio";
    private String messageDeletionFailure = "Impossibile eliminare il messaggio";
    private String promptRoleId = "Ruolo id: ";
    private String promptSuccess = "Successo";
    private String promptFailed = "Mancato";
    private String archivedMessagesIntro = "Elenco di messaggi archiviati: ";
    private String deleteUserWarning = "Scegli l'ID dell'utente da ELIMINARE\n"
                                     + "***ATTENZIONE QUESTA E 'FINALE***";
    
    @Override
    public String getDeleteUserWarning(){
        return deleteUserWarning;
    }
    
    @Override
    public String getArchivedMessagesIntro(){
        return archivedMessagesIntro;
    }
    
    @Override
    public String getPromptSuccess(){
        return promptSuccess;
    }
    
    @Override
    public String getPromptFailed(){
        return promptFailed;
    }
    
    @Override
    public String getPromptRoleId(){
        return promptRoleId;
    }
    
    @Override
    public String getSuperAdminMenu(){
        return superAdminMenu;
    }
    
    @Override
    public String getMessageDeletionFailure(){
        return messageDeletionFailure;
    }
    
    @Override
    public String getDeleterMainMenu(){
        return deleterMainMenu;
    }
    
    @Override
    public String getEditMessageFailure(){
        return editMessageFailure;
    }
    
    @Override
    public String getEditMessageSuccess(){
        return editMessageSuccess;
    }
    
    public String getEditMessagePrompt() {
        return editMessagePrompt;
    }
    
    public String getEditOtherUserMessageIntro(){
        return editOtherUserMessageIntro;
    }
    
    public String getReadAllMessagesIntro(){
        return readAllMessagesIntro;
    }
    
    public String getReadOtherUserMessagesIntro(){
        return readOtherUserMessagesIntro;
    }
    
    @Override
    public String getMessageSentSuccess(){
        return messageSentSuccess;
    }
    
    @Override
    public String getInputMessagePrompt(){
        return inputMessagePrompt;
    }
    
    @Override
    public String getChooseUserToMessagePrompt(){
        return chooseUserToMessagePrompt;
    }
    
    public String getMessageDeletionConfirmation(){
        return messageDeletionConfirmation;
    }
    
    @Override
    public String getMessageDeletionPromt(){
        return messageDeletionPromt;
    }
    
    @Override
    public String getAllUsersIntro(){
        return allUsersIntro;
    }
    
    @Override
    public String getPromptBanned(){
        return promptBanned;
    }
    
    @Override
    public String getPromptSender() {
        return promptSender;
    }

    @Override
    public String getPromptReceiver() {
        return promptReceiver;
    }

    @Override
    public String getPromptDate() {
        return promptDate;
    }

    @Override
    public String getSplashScreen() {
        return splashScreen;
    }

    @Override
    public String getWelcome() {
        return welcome;
    }

    @Override
    public String getPromptUsername() {
        return promptUsername;
    }

    @Override
    public String getPromptPassword() {
        return promptPassword;
    }

    @Override
    public String getPromptWrongUsername() {
        return promptWrongUsername;
    }

    @Override
    public String getPromptWrongPassword() {
        return promptWrongPassword;
    }

    @Override
    public String getPromptId() {
        return promptId;
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public String getOwnMessagesIntro() {
        return ownMessagesIntro;
    }

    @Override
    public String getYouAreBanned() {
        return youAreBanned;
    }

    @Override
    public String getRestrictedUserMainMenu() {
        return restrictedUserMainMenu;
    }

    @Override
    public String getRegularUserMainMenu() {
        return regularUserMainMenu;
    }
    
    @Override
    public String getViewerMainMenu() {
        return viewerMainMenu;
    }
    
    @Override
    public String getEditorMainMenu(){
        return editorMainMenu;
    }
    
    @Override
    public String getGoodbye() {
        return goodbye;
    }

    @Override
    public String getInvalidOption() {
        return invalidOption;
    }
    
}
