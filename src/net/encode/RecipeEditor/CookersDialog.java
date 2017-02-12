package net.encode.RecipeEditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.encode.Recipes.Cooker;

public class CookersDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField difficultyField;
	
	private java.awt.List cookersList;
	private java.util.List<Cooker> cookersListTemp = new ArrayList<Cooker>();
	/**
	 * Create the dialog.
	 */
	public CookersDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getContainers() != null)
				{
					cookersListTemp = RecipeEditor.instance.recipe.getCookers();
					
					cookersList.removeAll();
					for(Cooker cooker : cookersListTemp)
					{
						cookersList.add(
								(cooker.getId() != null ? "I: " + cooker.getId() : "") +
								(cooker.getDifficulty() != null ? " D: " + cooker.getDifficulty().toString() : ""));
					}
				}
			}
		});
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 130, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblId = new JLabel("Id");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.WEST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 0;
			gbc_lblId.gridy = 0;
			contentPanel.add(lblId, gbc_lblId);
		}
		{
			idField = new JTextField();
			GridBagConstraints gbc_idField = new GridBagConstraints();
			gbc_idField.insets = new Insets(0, 0, 5, 0);
			gbc_idField.fill = GridBagConstraints.HORIZONTAL;
			gbc_idField.gridx = 1;
			gbc_idField.gridy = 0;
			contentPanel.add(idField, gbc_idField);
			idField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Difficulty");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			difficultyField = new JTextField();
			GridBagConstraints gbc_difficultyField = new GridBagConstraints();
			gbc_difficultyField.insets = new Insets(0, 0, 5, 0);
			gbc_difficultyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_difficultyField.gridx = 1;
			gbc_difficultyField.gridy = 1;
			contentPanel.add(difficultyField, gbc_difficultyField);
			difficultyField.setColumns(10);
		}
		{
			JButton cookersAddButton = new JButton("Add");
			cookersAddButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(idField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Id Field is required.", "Id Error");
					}else if(difficultyField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Difficulty Field is required.", "Difficulty Error");
					}else{
						Cooker cookerTemp = new Cooker().withId(idField.getText()).withDifficulty(Float.valueOf(difficultyField.getText()));
						
						cookersList.add(
								"I: " + idField.getText() +
								" D: " + difficultyField.getText());
						cookersListTemp.add(cookerTemp);
					}
				}
			});
			GridBagConstraints gbc_cookersAddButton = new GridBagConstraints();
			gbc_cookersAddButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_cookersAddButton.insets = new Insets(0, 0, 5, 5);
			gbc_cookersAddButton.gridx = 0;
			gbc_cookersAddButton.gridy = 2;
			contentPanel.add(cookersAddButton, gbc_cookersAddButton);
		}
		{
			cookersList = new List();
			GridBagConstraints gbc_cookersList = new GridBagConstraints();
			gbc_cookersList.fill = GridBagConstraints.BOTH;
			gbc_cookersList.insets = new Insets(0, 0, 5, 0);
			gbc_cookersList.gridwidth = 2;
			gbc_cookersList.gridx = 0;
			gbc_cookersList.gridy = 3;
			contentPanel.add(cookersList, gbc_cookersList);
		}
		{
			JButton cookersDeleteButton = new JButton("Delete");
			cookersDeleteButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = cookersList.getSelectedIndex();
					if(index != -1)
					{
						cookersListTemp.remove(cookersList.getSelectedIndex());
						cookersList.remove(cookersList.getSelectedIndex());
					}
				}
			});
			GridBagConstraints gbc_cookersDeleteButton = new GridBagConstraints();
			gbc_cookersDeleteButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_cookersDeleteButton.insets = new Insets(0, 0, 0, 5);
			gbc_cookersDeleteButton.gridx = 0;
			gbc_cookersDeleteButton.gridy = 4;
			contentPanel.add(cookersDeleteButton, gbc_cookersDeleteButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						RecipeEditor.instance.recipe.setCookers(cookersListTemp);
						RecipeEditor.instance.updateCookersData();
						RecipeEditor.instance.cookersDialog.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						RecipeEditor.instance.cookersDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
