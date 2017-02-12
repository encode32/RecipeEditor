package net.encode.RecipeEditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.encode.Recipes.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ContainersDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField difficultyField;
	
	private java.awt.List containersList;
	private java.util.List<Container> containersListTemp = new ArrayList<Container>();
	/**
	 * Create the dialog.
	 */
	public ContainersDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getContainers() != null)
				{
					containersListTemp = RecipeEditor.instance.recipe.getContainers();
					
					containersList.removeAll();
					for(Container container : containersListTemp)
					{
						containersList.add(
								(container.getId() != null ? "I: " + container.getId() : "") +
								(container.getDifficulty() != null ? " D: " + container.getDifficulty().toString() : ""));
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
			JLabel lblDifficulty = new JLabel("Difficulty");
			GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
			gbc_lblDifficulty.anchor = GridBagConstraints.WEST;
			gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
			gbc_lblDifficulty.gridx = 0;
			gbc_lblDifficulty.gridy = 1;
			contentPanel.add(lblDifficulty, gbc_lblDifficulty);
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
			JButton containersAddButton = new JButton("Add");
			containersAddButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(idField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Id Field is required.", "Id Error");
					}else if(difficultyField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Difficulty Field is required.", "Difficulty Error");
					}else{
						Container containerTemp = new Container().withId(idField.getText()).withDifficulty(Float.valueOf(difficultyField.getText()));
						
						containersList.add(
								"I: " + idField.getText() +
								" D: " + difficultyField.getText());
						containersListTemp.add(containerTemp);
					}
				}
			});
			GridBagConstraints gbc_containersAddButton = new GridBagConstraints();
			gbc_containersAddButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_containersAddButton.insets = new Insets(0, 0, 5, 5);
			gbc_containersAddButton.gridx = 0;
			gbc_containersAddButton.gridy = 2;
			contentPanel.add(containersAddButton, gbc_containersAddButton);
		}
		{
			containersList = new List();
			GridBagConstraints gbc_containersList = new GridBagConstraints();
			gbc_containersList.insets = new Insets(0, 0, 5, 0);
			gbc_containersList.fill = GridBagConstraints.BOTH;
			gbc_containersList.gridwidth = 2;
			gbc_containersList.gridx = 0;
			gbc_containersList.gridy = 3;
			contentPanel.add(containersList, gbc_containersList);
		}
		{
			JButton containersDeleteButton = new JButton("Delete");
			containersDeleteButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = containersList.getSelectedIndex();
					if(index != -1)
					{
						containersListTemp.remove(containersList.getSelectedIndex());
						containersList.remove(containersList.getSelectedIndex());
					}
				}
			});
			GridBagConstraints gbc_containersDeleteButton = new GridBagConstraints();
			gbc_containersDeleteButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_containersDeleteButton.insets = new Insets(0, 0, 0, 5);
			gbc_containersDeleteButton.gridx = 0;
			gbc_containersDeleteButton.gridy = 4;
			contentPanel.add(containersDeleteButton, gbc_containersDeleteButton);
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
						RecipeEditor.instance.recipe.setContainers(containersListTemp);
						RecipeEditor.instance.updateContainersData();
						RecipeEditor.instance.containersDialog.setVisible(false);
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
						RecipeEditor.instance.containersDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
