import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tbPane = new JTabbedPane();
	private JButton btnClose = new JButton("Clost");

	public MainFrame() {
		initComponents();
		initListener();
	}

	private void initComponents() {
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		tbPane.addTab("Post Tool", new PostTool());
		c.add(tbPane, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						5, 5, 5, 5), 0, 0));
		c.add(btnClose, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java UI POST");
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	private void initListener() {
		InnerActionListener l = new InnerActionListener();
		btnClose.addActionListener(l);
	}

	private class InnerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == btnClose) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				new MainFrame().setVisible(true);
			}
		});
		// if (args.length != 2) {
		// System.out.println("Usage: Poster.jar <url> <param>");
		// } else {
		// System.out.println(HttpRequest.sendPost(args[0], args[1]));
		// }
	}
}
