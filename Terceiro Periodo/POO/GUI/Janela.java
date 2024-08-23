import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class Janela extends JFrame{
    
    
    
    public static void main(String[] args) {


        //#region Janela
        JFrame janela = new JFrame();
        janela.setSize(350,200);
        janela.setTitle("Tela de login");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setResizable(false);
        //#endregion
        
        //#region botão
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(110,87,160,25);
        janela.add(btnEntrar);
        //#endregion

        //#region label
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(30,30,50,10);
        janela.add(userLabel);
        
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(30,63,50,10);
        janela.add(passwordLabel);
        //#endregion

        //#region TextField / PasswordField
        JTextField userText = new JTextField();
        userText.setBounds(110, 27, 160, 25);
        janela.add(userText);
        
        JPasswordField userPassword = new JPasswordField();
        userPassword.setBounds(110, 57, 160, 25);
        janela.add(userPassword);
        //#endregion
        
        janela.setVisible(true); //Evitar bugs visuais
    }
    
}