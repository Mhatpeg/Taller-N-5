package ui.Ventana1;

import com.formdev.flatlaf.FlatLightLaf;
import model.Cliente;
import service.Banco;
import service.BancoImpl;
import ui.BancoModel;

import ui.VentanaUsuario.VentanaUsuario;

import javax.swing.*;


public final class Ventana1 extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField password;
    private JButton iniciarSesiónButton;
    private final BancoModel bancoModel;
    private final BancoImpl banco;

    public Ventana1(){
        super("Banco Calama");

        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.banco = BancoImpl.getInstance();

        this.bancoModel = new BancoModel();
        // Ajustar el tamaño de la ventana
        int width = 600;  // Ancho deseado
        int height = 400; // Alto deseado
        this.setSize(width, height);



        this.iniciarSesiónButton.addActionListener(e -> {
            String rut = textField1.getText().trim();
            String clave = new String(password.getPassword()); // Obtener clave como String

            // Verificar si el cliente existe y las credenciales son correctas
            Cliente cliente = banco.validarCredenciales(rut, clave);
            if (cliente != null) {
                // Limpiar campos
                textField1.setText("");
                password.setText("");

                // Mostrar ventana de usuario
                VentanaUsuario vu = new VentanaUsuario(cliente);
                vu.pack();
                vu.setLocationRelativeTo(null);
                vu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
    public static void main(String[] args) {
        Banco banco = BancoImpl.getInstance();

        FlatLightLaf.setup();

        Ventana1 v1 = new Ventana1();
        v1.setVisible(true);
    }
}
