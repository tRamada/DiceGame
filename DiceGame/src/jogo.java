import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class jogo extends Frame implements ActionListener {

    // Global Information
    private static final long serialVersionUID = 1L;
    MenuBar mn_bar;
    Menu menu_file, menu_about;
    Menu subCreators;
    MenuItem itSair, itRamada, itNeto, itSamu;
    //ImageIcon Image1;
    Panel sulPanel, centroPanel;
    Button jogar_Button, score_Button, sair_Button;
    Boolean quadrado = false;

    // Constructor
    public jogo() {

        //Title
        setTitle("Jogo dos dados");

        // MenuBar
        mn_bar = new MenuBar();
        menu_file = new Menu("File");
        menu_about = new Menu("About");


        // MenuItem - Leave
        itSair = new MenuItem("Sair");
        itSair.addActionListener(this);

        // subMenuItem - Creators
        subCreators = new Menu("Criadores");
        subCreators.addActionListener(this);

        // MenuItem - Neto
        itNeto = new MenuItem("Adérito Neto");
        itNeto.addActionListener(this);

        // MenuItem - Ramada
        itRamada = new MenuItem("Tiago Ramada");
        itRamada.addActionListener(this);

        // MenuItem - Samu
        itSamu =  new MenuItem("Samuel Silva");
        itSamu.addActionListener(this);

        // Add Menus to Frame
        menu_file.add(itSair);
        menu_about.add(subCreators);
        subCreators.add(itNeto);
        subCreators.add(itRamada);
        subCreators.add(itSamu);
        mn_bar.add(menu_file);
        mn_bar.add(menu_about);
        setMenuBar(mn_bar);

        // Panels


        sulPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 110, 50));
        sulPanel.setBackground(Color.BLUE);

        //BUTTONS
        // Button - Play
        jogar_Button = new Button("JOGAR");
        jogar_Button.addActionListener(this);
        sulPanel.add(jogar_Button);

        // Button - Score
        score_Button =  new Button("SCORE");
        score_Button.addActionListener(this);
        sulPanel.add(score_Button);

        // Button - Leave
        sair_Button = new Button("SAIR");
        sair_Button.addActionListener(this);
        sulPanel.add(sair_Button);

        // Frame
        setSize(640, 480);
        setResizable(false);
        setVisible(true);

        add(sulPanel, BorderLayout.SOUTH); // Add south panel to frame
    } // End Constructor

    // Methods
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jogar_Button) {
            quadrado = true;
        }
        // MenuItem Sair
        if (e.getSource() == itSair || e.getSource() == sair_Button) {
            System.gc();
            System.exit(0);
        }
    } //End ActionPerformed
    public void paint(final Graphics g) {
        if (quadrado) {
            g.setColor(Color.black);
            g.fillRoundRect(120, 120, 100, 100, 20, 29);
        }
    }// End Graphics

    // Main Function
    public static void main(String[] args) {
        jogo app = new jogo();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.gc();
                System.exit(0);
            }
        });
    }// End Main
} // End Class