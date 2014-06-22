package com.changhong.bd.tool.gui.mian;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PostTool extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lbURL = new JLabel("URL:");
	private JTextField tfURL = new JTextField();
	private JButton btnSubmit = new JButton("Submit");

	private JTextArea taKV = new JTextArea();
	private JTextArea taBody = new JTextArea();
	private JTextArea taResult = new JTextArea();

	private JTabbedPane tbAreaPane = new JTabbedPane();

	public PostTool() {
		initComponent();
		initListener();
	}

	private void initComponent() {
		JPanel pKV = new JPanel(new BorderLayout(5, 5));
		pKV.add(taKV, BorderLayout.CENTER);
		JPanel pBody = new JPanel(new BorderLayout(5, 5));
		pBody.add(taBody, BorderLayout.CENTER);

		setLayout(new GridBagLayout());
		JPanel pnlURL = new JPanel(new GridBagLayout());
		pnlURL.add(lbURL, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		pnlURL.add(tfURL, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		pnlURL.add(btnSubmit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
						5, 5, 5), 0, 0));
		add(pnlURL, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));

		taKV.setLineWrap(true);
		taKV.setWrapStyleWord(true);
		JScrollPane sp0 = new JScrollPane(taKV);
		tbAreaPane.addTab("Key-Value", sp0);
		taBody.setLineWrap(true);
		taBody.setWrapStyleWord(true);
		JScrollPane sp1 = new JScrollPane(taBody);
		tbAreaPane.addTab("Body", sp1);
		JPanel pnlTextArea = new JPanel(new GridBagLayout());
		pnlTextArea.add(tbAreaPane, new GridBagConstraints(0, 0, 1, 1, 1.0,
				1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		taResult.setLineWrap(true);
		taResult.setWrapStyleWord(true);
		taResult.setEditable(false);
		JScrollPane sp2 = new JScrollPane(taResult);
		sp2.setBorder(new TitledBorder("result"));
		pnlTextArea.add(sp2, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						5, 5, 5, 5), 0, 0));
		add(pnlTextArea, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 0, 0));
	}

	private void initListener() {
		btnSubmit.addActionListener(new InnerActionListener());
	}

	private class InnerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				String url = tfURL.getText().trim();
				String param = "";
				if (url.isEmpty()) {
					JOptionPane
							.showMessageDialog(PostTool.this, "URL is empty!",
									"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
					String str = taKV.getText();
					String[] s = str.split("\n");
					StringBuilder sb = new StringBuilder();
					String[] kv = null;
					for (String line : s) {
						kv = line.split("=");
						if (kv.length != 2) {
							JOptionPane.showMessageDialog(PostTool.this,
									"Error format", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						sb.append(kv[0].trim());// key=
						sb.append("=");
						try {
							sb.append(URLEncoder.encode(kv[1].trim(), "UTF-8"));// encode-value
						} catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(PostTool.this,
									e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						sb.append("&");
					}
					url = url + "?" + sb.toString();
					param = taBody.getText().trim();
				String result = HttpRequest.httpPost(url, null, param);
				if (result == null) {
					JOptionPane.showMessageDialog(PostTool.this,
							"Send post failed!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					taResult.setText(result);
				}
			}
		}

	}
}
