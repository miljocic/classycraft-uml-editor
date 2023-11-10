package raf.dsw.classycraft.app.gui.swing.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.awt.event.ActionEvent;


public class AboutUsAction extends AbstractClassyAction {

    //Konstruktor
    public AboutUsAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/aboutUs.png"));
        putValue(Action.NAME, "About Us");
        putValue(Action.SHORT_DESCRIPTION, "Informacije o timu");
    }

    @Override
    public Icon loadIcon(String fileName) {
        return super.loadIcon(fileName);
    }

    public void loadIcon() {
        // Za sada nije rečeno definisana ikona, time je i prazna
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] imena = {"Milica Jocic", "Jovan Spasojevic"};

        ImageIcon[] slike = {
                // ili ipak: ClassyCrafT/src/main/resources/images/student1.png ?
                new ImageIcon(getClass().getResource("/images/student1.png")),
                new ImageIcon(getClass().getResource("/images/student2.png"))
        };

        //Kreiranje panela za čuvanje informacija o studentima
        JPanel panel = new JPanel(new GridLayout(imena.length, 2, 10, 10));

        /*
        Dodavanje imena i slika studenata
        For prolazi kroz ime, time to ime i sliku dodaje
        posebnim JLabelima koje dodajemo na panel, prvo ime pa slika
         */
        for (int i = 0; i < imena.length; i++) {
            JLabel imenaLabel = new JLabel(imena[i]);
            JLabel slikeLabel = new JLabel(slike[i]);

            panel.add(imenaLabel);
            panel.add(slikeLabel);
        }

        //Kreiranje Frame-a za prikazivanje informacija o studentima
        JFrame frame = new JFrame("About Us");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();

        //Setovanje na sredinu monitora
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        frame.setVisible(true);





    }
}
