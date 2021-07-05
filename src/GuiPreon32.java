import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

public class GuiPreon32 {

	private JFrame frame;
	private JPanel panel;
	private JButton connectButton;
	private JTextArea log;
	private JComboBox<String> portListed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPreon32 window = new GuiPreon32();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiPreon32() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// inisialisasi awal untuk frame
		frame = new JFrame();
		frame.setTitle("Preon32 GUI");
		frame.setBounds(100, 100, 837, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// inisialisasi untuk Tab pannel
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(13, 11, 565, 336);
		frame.getContentPane().add(tabbedPane);

		// inisialisasi untuk pannel yang ada didalam tab pannel
		panel = new JPanel();
		tabbedPane.addTab("Information", null, panel, null);
		panel.setLayout(null);

		// inisialisasi untuk bagian UI sebelah kiri

		// inisialisasi button connect/disconnect
		connectButton = new JButton("Connect");
		connectButton.setBounds(39, 58, 89, 23);
		panel.add(connectButton);

		// inisialisasi combo box (untuk list sensor yang terbaca)
		portListed = new JComboBox<String>();
		portListed.setBounds(39, 28, 89, 22);
		panel.add(portListed);
		
		// inisialisasi untuk UI bagian tengah (informasi)
		
		// inisialisasi label Serial Port
		JLabel serialPortLabel = new JLabel("Serial Port:");
		serialPortLabel.setBounds(170, 29, 82, 20);
		panel.add(serialPortLabel);
		
		// inisialisasi label Baud Rate
		JLabel baudRateLabel = new JLabel("Baud Rate:");
		baudRateLabel.setBounds(170, 61, 82, 20);
		panel.add(baudRateLabel);
		
		// inisialisasi label Data Bits
		JLabel dataBitLabel = new JLabel("Data Bits:");
		dataBitLabel.setBounds(170, 92, 82, 20);
		panel.add(dataBitLabel);
		
		// inisialisasi label Parity
		JLabel parityLabel = new JLabel("Parity:");
		parityLabel.setBounds(170, 123, 82, 20);
		panel.add(parityLabel);
		
		// inisialisasi label Stop bits
		JLabel stopBitLabel = new JLabel("Stop Bits:");
		stopBitLabel.setBounds(170, 154, 82, 20);
		panel.add(stopBitLabel);
		
		// inisialisasi label Flow Control
		JLabel flowControldLabel = new JLabel("Flow Control:");
		flowControldLabel.setBounds(170, 185, 82, 20);
		panel.add(flowControldLabel);
		
		//inisialisasi text pane untuk menampilkan informasi
		JTextPane serialPort = new JTextPane();
		JTextPane baudRate = new JTextPane();
		JTextPane dataBit = new JTextPane();
		JTextPane parity = new JTextPane();
		JTextPane stopBit = new JTextPane();
		JTextPane flowControl = new JTextPane();
		
		
		// memanggil fungsi untuk mengisi nilai
		setValue(serialPort, baudRate, dataBit, parity, stopBit, flowControl, "",0 , 0, 0, 0, 0);

		// inisialisasi untuk UI bagian bawah

		// inisialisasi untuk Scoll Pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 371, 791, 129);
		frame.getContentPane().add(scrollPane);

		// inisialisasi untuk Text Are (log)
		log = new JTextArea();
		DefaultCaret caret = (DefaultCaret) log.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane.setViewportView(log);
	}
	
	private void setValue(JTextPane serialPort, JTextPane baudRate,JTextPane dataBit, JTextPane parity, JTextPane stopBit, JTextPane flowControl,
			String com, int isibaudrate, int isidatabit, int isiparity, int isistopbits, int isiflowcontrol) {
		
		// menampilkan serial port
		serialPort.setBounds(258, 29, 139, 20);
		panel.add(serialPort);
		serialPort.setText(com);
		
		// menampilkan baudRate
		baudRate.setBounds(258, 61, 139, 20);
		panel.add(baudRate);
		baudRate.setText(Integer.toString(isibaudrate));
		
		// menampilkan data bit
		dataBit.setBounds(258, 92, 139, 20);
		panel.add(dataBit);
		dataBit.setText(Integer.toString(isidatabit));
		
		// menampilkan parity
		parity.setBounds(258, 123, 139, 20);
		panel.add(parity);
		parity.setText(Integer.toString(isiparity));
		
		// menampilkan stop bit
		stopBit.setBounds(258, 154, 139, 20);
		panel.add(stopBit);
		stopBit.setText(Integer.toString(isistopbits));
		
		// menampilkan flow control
		flowControl.setBounds(258, 185, 139, 20);
		panel.add(flowControl);
		flowControl.setText(Integer.toString(isiflowcontrol));
		
	}

}
