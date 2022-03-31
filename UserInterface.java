import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface extends JFrame implements ActionListener {
    JButton buttonencode = new JButton("ENCODE");
    JButton buttondecode = new JButton("DECODE");
    JLabel result = new JLabel("RESULT WILL DISPLAY HERE",SwingConstants.CENTER);
    JLabel label = new JLabel( "INPUT A TEXT IN THE TEXT FIELD TO ENCODE OR DECODE");
    JTextField TextField = new JFormattedTextField();
    //creating huffthree
    HuffmanGenerator huffmanGenerator = new HuffmanGenerator(new File("data/LetterCountAscending.txt"));
    UserInterface(){
        buttondecode.addActionListener(this);
        buttonencode.addActionListener(this);
        setfont();
        add(creatPanel());
        setVisible(true);
        setSize(1000,1000);
    }

    public JPanel creatPanel (){
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#088F8F"));
        buttondecode.setBackground(Color.decode("#7393B3"));
        buttonencode.setBackground(Color.decode("#89CFF0"));
        panel.add(label);
        panel.add(result);
        panel.add(TextField);
        panel.add(buttondecode);
        panel.add(buttonencode);
        panel.setLayout(new GridLayout(5,1));
        return panel;
    }
    // setting all the style for the interface
    public void setfont(){
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Serif", Font.PLAIN, 25));
        result.setVerticalAlignment(SwingConstants.CENTER);
        TextField.setFont(new Font("Serif", Font.PLAIN, 50));
        buttondecode.setFont(new Font("Serif", Font.PLAIN, 50));
        buttondecode.setVerticalAlignment(SwingConstants.CENTER);
        buttondecode.setHorizontalAlignment(SwingConstants.CENTER);
        buttonencode.setFont(new Font("Serif", Font.PLAIN, 50));
        buttonencode.setVerticalAlignment(SwingConstants.CENTER);
        buttondecode.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttondecode){
			//calling decode methos with text input by user
            result.setText(huffmanGenerator.decode(huffmanGenerator.getHead(), TextField.getText()));
        }
        else if (e.getSource() == buttonencode){
			//calling encodeString methos with text input by user
            result.setText(huffmanGenerator.encodeString(TextField.getText().toUpperCase()));
        }
    }
    public static void main(String[] args) {
        new UserInterface();
    }
}
