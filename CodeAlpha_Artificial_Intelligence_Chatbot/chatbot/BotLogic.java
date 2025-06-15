// BotLogic.java

package chatbot;

public class BotLogic {
    private FAQData faqData;

    public BotLogic() {
        faqData = new FAQData();
    }

    public String getBotResponse(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return "Please type something!";
        }

        return faqData.getResponse(userInput);
    }
}
