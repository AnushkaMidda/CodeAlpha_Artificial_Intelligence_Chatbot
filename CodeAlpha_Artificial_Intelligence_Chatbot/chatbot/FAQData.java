// FAQData.java

package chatbot;

import java.util.HashMap;

public class FAQData {
    private HashMap<String, String> faqMap;

    public FAQData() {
        faqMap = new HashMap<>();

        // Add common question-answer pairs here
        faqMap.put("hi", "Hello! How can I help you today?");
        faqMap.put("hello", "Hi there! Ask me anything.");
        faqMap.put("how are you", "I'm just a bot, but I'm doing great! Thanks for asking.");
        faqMap.put("what is your name", "I'm your virtual assistant developed in Java.");
        

        faqMap.put("who created you", "I was created by Anushka Midda as a part of a Java internship project at CodeAlpha.");
        
        faqMap.put("bye", "Goodbye! Have a great day.");
    }

    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase().trim();

        if (faqMap.containsKey(userInput)) {
            return faqMap.get(userInput);
        } else {
            return "Sorry, I don't understand that yet. Can you ask something else?";
        }
    }
}
