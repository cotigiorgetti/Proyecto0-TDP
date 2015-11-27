package Grafica;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel() {
		this.setBackground(new Color(0, 128, 0));
		this.setBounds(10, 36, 703, 476);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		for(int i=0;i<=31;i++)
			for(int j=0;j<=13;j++)
		{JLabel lb = new JLabel();
		GridBagConstraints gbc_lb = new GridBagConstraints();
		gbc_lb.gridx = i;
		gbc_lb.gridy = j;
		add(lb, gbc_lb);
		
		
		
	
		}
		}
	
}
