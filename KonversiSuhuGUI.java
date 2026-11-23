import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// 1. Top-level Container Class: JFrame
public class KonversiSuhuGUI extends JFrame implements ActionListener {

    // 3. Atomic Component Class: JLabel, JTextField, JComboBox, JButton
    private JLabel lblJudul, lblInput, lblJenis, lblHasil;
    private JTextField txtSuhu;
    private JComboBox<String> cmbKonversi;
    private JButton btnKonversi, btnReset;

    public KonversiSuhuGUI() {
        // Pengaturan dasar Top-level Container (JFrame)
        setTitle("Aplikasi Konversi Suhu - Tugas GUI Java");
        setSize(430, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Posisi jendela di tengah layar

        // 4. Layout Class ke-1: BorderLayout untuk JFrame utama
        setLayout(new BorderLayout(10, 10));

        // 2. Intermediate Container Class: JPanel (Header)
        // 4. Layout Class ke-2: FlowLayout
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelHeader.setBorder(new EmptyBorder(10, 10, 0, 10));
        lblJudul = new JLabel("PROGRAM KONVERSI SUHU");
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelHeader.add(lblJudul);

        // 2. Intermediate Container Class: JPanel (Form Input & Output)
        // 4. Layout Class ke-3: GridLayout (3 baris, 2 kolom)
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 12));
        panelForm.setBorder(new EmptyBorder(10, 20, 10, 20));

        lblInput = new JLabel("Masukkan Nilai Suhu:");
        txtSuhu = new JTextField();

        lblJenis = new JLabel("Pilih Jenis Konversi:");
        String[] pilihan = {
            "Celcius ke Fahrenheit",
            "Celcius ke Kelvin",
            "Fahrenheit ke Celcius",
            "Kelvin ke Celcius"
        };
        cmbKonversi = new JComboBox<>(pilihan);

        lblHasil = new JLabel("Hasil Konversi:");
        JLabel lblOutputNilai = new JLabel("-");
        lblOutputNilai.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblOutputNilai.setForeground(new Color(0, 102, 204));

        // Simpan referensi lblOutputNilai ke lblHasil agar mudah diperbarui
        lblHasil = lblOutputNilai;

        panelForm.add(lblInput);
        panelForm.add(txtSuhu);
        panelForm.add(lblJenis);
        panelForm.add(cmbKonversi);
        panelForm.add(new JLabel("Hasil Konversi:"));
        panelForm.add(lblHasil);

        // 2. Intermediate Container Class: JPanel (Tombol Aksi)
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnKonversi = new JButton("Hitung Konversi");
        btnReset = new JButton("Reset");

        // 5. Event Listener (Interface ActionListener)
        btnKonversi.addActionListener(this);
        btnReset.addActionListener(this);

        // 5. Event Adapter Class (MouseAdapter untuk efek hover pada tombol)
        btnKonversi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnKonversi.setBackground(new Color(200, 230, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnKonversi.setBackground(UIManager.getColor("Button.background"));
            }
        });

        panelTombol.add(btnKonversi);
        panelTombol.add(btnReset);

        // Menambahkan seluruh Intermediate Container ke Top-level Container (JFrame)
        add(panelHeader, BorderLayout.NORTH);
        add(panelForm, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
    }

    // 5. Event Method Override dari interface ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKonversi) {
            try {
                double input = Double.parseDouble(txtSuhu.getText());
                String jenis = (String) cmbKonversi.getSelectedItem();
                double hasil = 0;
                String satuan = "";

                if (jenis.equals("Celcius ke Fahrenheit")) {
                    hasil = (input * 9.0 / 5.0) + 32;
                    satuan = " °F";
                } else if (jenis.equals("Celcius ke Kelvin")) {
                    hasil = input + 273.15;
                    satuan = " K";
                } else if (jenis.equals("Fahrenheit ke Celcius")) {
                    hasil = (input - 32) * 5.0 / 9.0;
                    satuan = " °C";
                } else if (jenis.equals("Kelvin ke Celcius")) {
                    hasil = input - 273.15;
                    satuan = " °C";
                }

                lblHasil.setText(String.format("%.2f%s", hasil, satuan));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Harap masukkan angka yang valid!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } else if (e.getSource() == btnReset) {
            txtSuhu.setText("");
            cmbKonversi.setSelectedIndex(0);
            lblHasil.setText("-");
            txtSuhu.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KonversiSuhuGUI().setVisible(true);
        });
    }
}