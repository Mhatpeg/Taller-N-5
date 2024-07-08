package ui.VentanaUsuario;

import model.Cliente;

import javax.swing.*;
import java.awt.event.*;

public class VentanaUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton verTransferenciasButton;
    private JTextArea nameArea;
    private JTextArea RutArea;
    private JTextArea saldo;
    private JTextField transArea;
    private final Cliente cliente;

    public VentanaUsuario(Cliente cliente) {
        this.cliente = cliente;
        this.setTitle("Mi perfil");
        this.setContentPane(contentPane);
        this.setModal(true);
        this.getRootPane().setDefaultButton(buttonCancel);

        this.buttonOK.addActionListener(e -> this.onOK());

        this.buttonCancel.addActionListener(e ->  this.onCancel());


        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        // Mostrar datos del cliente en la interfaz
        nameArea.setText(cliente.getNombre());
        RutArea.setText(cliente.getRut());
        saldo.setText(Integer.toString(cliente.getMonto())); //Se tuvo que buscar en internet


    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }


}