import com.it.ChatEntryFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ChatEntryFrame login = new ChatEntryFrame();
            login.setVisible(true);
        });
    }
}
