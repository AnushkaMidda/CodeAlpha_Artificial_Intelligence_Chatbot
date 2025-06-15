// ChatBotApp.java

package chatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotApp extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private BotLogic botLogic;

    public ChatBotApp() {
        setTitle("CodeAlpha AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        botLogic = new BotLogic();

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.addActionListener(this); // Allow Enter key to send
        inputPanel.add(inputField, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
        chatArea.append("Bot: Hello! I am your Java Chatbot. Ask me anything.\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userText = inputField.getText();
        if (!userText.isEmpty()) {
            chatArea.append("You: " + userText + "\n");
            String botReply = botLogic.getBotResponse(userText);
            chatArea.append("Bot: " + botReply + "\n");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatBotApp());
    }
}

