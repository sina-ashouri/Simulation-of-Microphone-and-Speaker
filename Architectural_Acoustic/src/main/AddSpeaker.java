package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import shapes.*;
public class AddSpeaker extends JFrame {

	private JPanel contentPane;
	private static SpinnerNumberModel Fmodel ;
    private static JSpinner.NumberEditor Feditor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSpeaker frame = new AddSpeaker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void closeframe(){
		super.dispose();
	}
	
	public AddSpeaker() {
		setTitle("Add Speaker");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 225, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblX = new JLabel("X :");
		
		JLabel lblY = new JLabel("Y :");
		
		JSpinner Xspinner = new JSpinner();
		
		JSpinner Yspinner = new JSpinner();
		
		JLabel lblNewLabel = new JLabel("Frequency :");
		
		JSpinner freq_spinner = new JSpinner();
		
		Fmodel = new SpinnerNumberModel(0.0,0.0 ,10000000000.0,0.001);
        Feditor = new JSpinner.NumberEditor(freq_spinner);
		
		JButton btnAddSpeaker = new JButton("Add speaker");
		btnAddSpeaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Speaker spkr = new Speaker();
			spkr.setCenter(new Point((Integer)Xspinner.getValue(),(Integer)Yspinner.getValue()));
			spkr.setFrequency((Integer)freq_spinner.getValue());
			Mainwindow.mainPanel.repaint();
			closeframe();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeframe();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCancel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddSpeaker, Alignment.LEADING))
							.addGap(44))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblY)
								.addComponent(lblX)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(freq_spinner, Alignment.LEADING)
								.addComponent(Xspinner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
								.addComponent(Yspinner, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGap(30))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(Xspinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(Yspinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(freq_spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnAddSpeaker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
