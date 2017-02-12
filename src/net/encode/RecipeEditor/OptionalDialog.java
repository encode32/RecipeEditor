package net.encode.RecipeEditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.encode.Recipes.Ingredients;
import net.encode.Recipes.Optional;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OptionalDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField cstateField;
	private JTextField pstateField;
	private JTextField materialField;
	private JTextField realTemplateField;
	private JTextField difficultyField;
	private JTextField ratioField;
	private JTextField lossField;
	private JTextField amountField;
	
	private java.awt.List optionalList;
	private java.util.List<Optional> optionalListTemp = new ArrayList<Optional>();
	/**
	 * Create the dialog.
	 */
	public OptionalDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getIngredients() != null && RecipeEditor.instance.recipe.getIngredients().getOptional() != null)
				{
					optionalListTemp = RecipeEditor.instance.recipe.getIngredients().getOptional();
					
					optionalList.removeAll();
					for(Optional optional : optionalListTemp)
					{
						optionalList.add(
								(optional.getId() != null ? "I: " + optional.getId() : "") +
								(optional.getCstate() != null ? " C: " + optional.getCstate() : "") +
								(optional.getPstate() != null ? " P: " + optional.getPstate() : "") +
								(optional.getMaterial() != null ? " M: " + optional.getMaterial() : "") +
								(optional.getRealtemplate() != null ? " RT: " + optional.getRealtemplate() : "") +
								(optional.getDifficulty() != null ? " D: " + optional.getDifficulty().toString() : "") +
								(optional.getRatio() != null ? " R: " + optional.getRatio().toString() : "") +
								(optional.getLoss() != null ? " L: " + optional.getLoss().toString() : "") +
								(optional.getAmount() != null ? " R: " + optional.getAmount().toString() : ""));
					}
				}
			}
		});
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 300, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{90, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 16, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Id");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
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
			JLabel lblNewLabel_1 = new JLabel("Cstate");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			cstateField = new JTextField();
			GridBagConstraints gbc_cstateField = new GridBagConstraints();
			gbc_cstateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cstateField.anchor = GridBagConstraints.NORTH;
			gbc_cstateField.insets = new Insets(0, 0, 5, 0);
			gbc_cstateField.gridx = 1;
			gbc_cstateField.gridy = 1;
			contentPanel.add(cstateField, gbc_cstateField);
			cstateField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Pstate");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			pstateField = new JTextField();
			GridBagConstraints gbc_pstateField = new GridBagConstraints();
			gbc_pstateField.insets = new Insets(0, 0, 5, 0);
			gbc_pstateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_pstateField.gridx = 1;
			gbc_pstateField.gridy = 2;
			contentPanel.add(pstateField, gbc_pstateField);
			pstateField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Material");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			materialField = new JTextField();
			GridBagConstraints gbc_materialField = new GridBagConstraints();
			gbc_materialField.insets = new Insets(0, 0, 5, 0);
			gbc_materialField.fill = GridBagConstraints.HORIZONTAL;
			gbc_materialField.gridx = 1;
			gbc_materialField.gridy = 3;
			contentPanel.add(materialField, gbc_materialField);
			materialField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Real Template");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			realTemplateField = new JTextField();
			GridBagConstraints gbc_realTemplateField = new GridBagConstraints();
			gbc_realTemplateField.insets = new Insets(0, 0, 5, 0);
			gbc_realTemplateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_realTemplateField.gridx = 1;
			gbc_realTemplateField.gridy = 4;
			contentPanel.add(realTemplateField, gbc_realTemplateField);
			realTemplateField.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Difficulty");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 5;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			difficultyField = new JTextField();
			GridBagConstraints gbc_difficultyField = new GridBagConstraints();
			gbc_difficultyField.insets = new Insets(0, 0, 5, 0);
			gbc_difficultyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_difficultyField.gridx = 1;
			gbc_difficultyField.gridy = 5;
			contentPanel.add(difficultyField, gbc_difficultyField);
			difficultyField.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Ratio");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 6;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			ratioField = new JTextField();
			GridBagConstraints gbc_ratioField = new GridBagConstraints();
			gbc_ratioField.insets = new Insets(0, 0, 5, 0);
			gbc_ratioField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ratioField.gridx = 1;
			gbc_ratioField.gridy = 6;
			contentPanel.add(ratioField, gbc_ratioField);
			ratioField.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Loss");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 0;
			gbc_lblNewLabel_7.gridy = 7;
			contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			lossField = new JTextField();
			GridBagConstraints gbc_lossField = new GridBagConstraints();
			gbc_lossField.insets = new Insets(0, 0, 5, 0);
			gbc_lossField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lossField.gridx = 1;
			gbc_lossField.gridy = 7;
			contentPanel.add(lossField, gbc_lossField);
			lossField.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Amount");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 0;
			gbc_lblNewLabel_8.gridy = 8;
			contentPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			amountField = new JTextField();
			GridBagConstraints gbc_amountField = new GridBagConstraints();
			gbc_amountField.insets = new Insets(0, 0, 5, 0);
			gbc_amountField.fill = GridBagConstraints.HORIZONTAL;
			gbc_amountField.gridx = 1;
			gbc_amountField.gridy = 8;
			contentPanel.add(amountField, gbc_amountField);
			amountField.setColumns(10);
		}
		{
			JButton addButton = new JButton("Add");
			addButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(idField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Id Field is required.", "Id Error");
					}else
					{
						Optional optionalTemp = new Optional().withId(idField.getText());
						
						if(!cstateField.getText().isEmpty()){optionalTemp = optionalTemp.withCstate(cstateField.getText());}
						if(!pstateField.getText().isEmpty()){optionalTemp = optionalTemp.withPstate(pstateField.getText());}
						if(!materialField.getText().isEmpty()){optionalTemp = optionalTemp.withMaterial(materialField.getText());}
						if(!realTemplateField.getText().isEmpty()){optionalTemp = optionalTemp.withRealtemplate(realTemplateField.getText());}
						if(!difficultyField.getText().isEmpty()){optionalTemp = optionalTemp.withDifficulty(Float.valueOf(difficultyField.getText()));}
						if(!ratioField.getText().isEmpty()){optionalTemp = optionalTemp.withRatio(Float.valueOf(ratioField.getText()));}
						if(!lossField.getText().isEmpty()){optionalTemp = optionalTemp.withLoss(Float.valueOf(lossField.getText()));}
						if(!amountField.getText().isEmpty()){optionalTemp = optionalTemp.withAmount(Float.valueOf(amountField.getText()));}
						
						optionalList.add(
								"I: " + idField.getText() +
								(cstateField.getText().isEmpty() ? "" : " C: " + cstateField.getText()) +
								(pstateField.getText().isEmpty() ? "" : " P: " + pstateField.getText()) +
								(materialField.getText().isEmpty() ? "" : " M: " + materialField.getText()) +
								(realTemplateField.getText().isEmpty() ? "" : " RT: " + realTemplateField.getText()) +
								(difficultyField.getText().isEmpty() ? "" : " D: " + difficultyField.getText()) +
								(ratioField.getText().isEmpty() ? "" : " R: " + ratioField.getText()) +
								(lossField.getText().isEmpty() ? "" : " L: " + lossField.getText()) +
								(amountField.getText().isEmpty() ? "" : " A: " + amountField.getText()));
						optionalListTemp.add(optionalTemp);
					}
				}
			});
			GridBagConstraints gbc_addButton = new GridBagConstraints();
			gbc_addButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_addButton.insets = new Insets(0, 0, 5, 5);
			gbc_addButton.gridx = 0;
			gbc_addButton.gridy = 9;
			contentPanel.add(addButton, gbc_addButton);
		}
		{
			optionalList = new java.awt.List();
			GridBagConstraints gbc_anyList = new GridBagConstraints();
			gbc_anyList.insets = new Insets(0, 0, 5, 0);
			gbc_anyList.fill = GridBagConstraints.BOTH;
			gbc_anyList.gridwidth = 2;
			gbc_anyList.gridx = 0;
			gbc_anyList.gridy = 10;
			contentPanel.add(optionalList, gbc_anyList);
		}
		{
			JButton deleteButton = new JButton("Delete");
			deleteButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = optionalList.getSelectedIndex();
					if(index != -1)
					{
						optionalListTemp.remove(optionalList.getSelectedIndex());
						optionalList.remove(optionalList.getSelectedIndex());
					}
				}
			});
			GridBagConstraints gbc_deleteButton = new GridBagConstraints();
			gbc_deleteButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
			gbc_deleteButton.gridx = 0;
			gbc_deleteButton.gridy = 11;
			contentPanel.add(deleteButton, gbc_deleteButton);
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
						if(RecipeEditor.instance.recipe.getIngredients() == null)
						{
							RecipeEditor.instance.recipe.setIngredients(new Ingredients().withOptional(optionalListTemp));
						}else
						{
							RecipeEditor.instance.recipe.getIngredients().setOptional(optionalListTemp);
						}
						RecipeEditor.instance.updateOptionalData();
						RecipeEditor.instance.optionalDialog.setVisible(false);
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
						RecipeEditor.instance.optionalDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
