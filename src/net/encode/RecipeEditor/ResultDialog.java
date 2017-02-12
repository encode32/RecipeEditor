package net.encode.RecipeEditor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.encode.Recipes.Result;

public class ResultDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField nameField;
	private JTextField cstateField;
	private JTextField pstateField;
	private JTextField materialField;
	private JTextField realTemplateField;
	private JTextField refMaterialField;
	private JTextField refRealTemplateField;
	private JTextField difficultyField;
	private JTextField descriptionField;
	private JTextField achievementField;
	private JTextField iconField;
	private JCheckBox useTemplateWeightCheckBox;
	
	private Result resultTemp;
	/**
	 * Create the dialog.
	 */
	public ResultDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getResult() != null)
				{
					resultTemp = RecipeEditor.instance.recipe.getResult();
					
					idField.setText(resultTemp.getId() != null ? resultTemp.getId() : "");
					nameField.setText(resultTemp.getName() != null ? nameField.getName() : "");
					cstateField.setText(resultTemp.getCstate() != null ? resultTemp.getCstate() : "");
					pstateField.setText(resultTemp.getPstate() != null ? resultTemp.getPstate() : "");
					materialField.setText(resultTemp.getMaterial() != null ? resultTemp.getMaterial() : "");
					realTemplateField.setText(resultTemp.getRealtemplate() != null ? resultTemp.getRealtemplate() : "");
					refMaterialField.setText(resultTemp.getRefmaterial() != null ? resultTemp.getRefmaterial() : "");
					refRealTemplateField.setText(resultTemp.getRefrealtemplate() != null ? resultTemp.getRefrealtemplate() : "");
					difficultyField.setText(resultTemp.getDifficulty() != null ? resultTemp.getDifficulty().toString() : "");
					descriptionField.setText(resultTemp.getDescription() != null ? resultTemp.getDescription() : "");
					achievementField.setText(resultTemp.getAchievement() != null ? resultTemp.getAchievement() : "");
					useTemplateWeightCheckBox.setSelected(resultTemp.getUsetemplateweight() != null ? true : false);
					iconField.setText(resultTemp.getIcon() != null ? resultTemp.getIcon() : "");
				}
			}
		});
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 300, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 1;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			nameField = new JTextField();
			GridBagConstraints gbc_nameField = new GridBagConstraints();
			gbc_nameField.insets = new Insets(0, 0, 5, 0);
			gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nameField.gridx = 1;
			gbc_nameField.gridy = 1;
			contentPanel.add(nameField, gbc_nameField);
			nameField.setColumns(10);
		}
		{
			JLabel lblCstate = new JLabel("Cstate");
			GridBagConstraints gbc_lblCstate = new GridBagConstraints();
			gbc_lblCstate.anchor = GridBagConstraints.WEST;
			gbc_lblCstate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCstate.gridx = 0;
			gbc_lblCstate.gridy = 2;
			contentPanel.add(lblCstate, gbc_lblCstate);
		}
		{
			cstateField = new JTextField();
			GridBagConstraints gbc_cstateField = new GridBagConstraints();
			gbc_cstateField.insets = new Insets(0, 0, 5, 0);
			gbc_cstateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cstateField.gridx = 1;
			gbc_cstateField.gridy = 2;
			contentPanel.add(cstateField, gbc_cstateField);
			cstateField.setColumns(10);
		}
		{
			JLabel lblPstate = new JLabel("Pstate");
			GridBagConstraints gbc_lblPstate = new GridBagConstraints();
			gbc_lblPstate.anchor = GridBagConstraints.WEST;
			gbc_lblPstate.insets = new Insets(0, 0, 5, 5);
			gbc_lblPstate.gridx = 0;
			gbc_lblPstate.gridy = 3;
			contentPanel.add(lblPstate, gbc_lblPstate);
		}
		{
			pstateField = new JTextField();
			GridBagConstraints gbc_pstateField = new GridBagConstraints();
			gbc_pstateField.insets = new Insets(0, 0, 5, 0);
			gbc_pstateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_pstateField.gridx = 1;
			gbc_pstateField.gridy = 3;
			contentPanel.add(pstateField, gbc_pstateField);
			pstateField.setColumns(10);
		}
		{
			JLabel lblMaterial = new JLabel("Material");
			GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
			gbc_lblMaterial.anchor = GridBagConstraints.WEST;
			gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
			gbc_lblMaterial.gridx = 0;
			gbc_lblMaterial.gridy = 4;
			contentPanel.add(lblMaterial, gbc_lblMaterial);
		}
		{
			materialField = new JTextField();
			GridBagConstraints gbc_materialField = new GridBagConstraints();
			gbc_materialField.insets = new Insets(0, 0, 5, 0);
			gbc_materialField.fill = GridBagConstraints.HORIZONTAL;
			gbc_materialField.gridx = 1;
			gbc_materialField.gridy = 4;
			contentPanel.add(materialField, gbc_materialField);
			materialField.setColumns(10);
		}
		{
			JLabel lblRealTemplate = new JLabel("Real Template");
			GridBagConstraints gbc_lblRealTemplate = new GridBagConstraints();
			gbc_lblRealTemplate.anchor = GridBagConstraints.WEST;
			gbc_lblRealTemplate.insets = new Insets(0, 0, 5, 5);
			gbc_lblRealTemplate.gridx = 0;
			gbc_lblRealTemplate.gridy = 5;
			contentPanel.add(lblRealTemplate, gbc_lblRealTemplate);
		}
		{
			realTemplateField = new JTextField();
			GridBagConstraints gbc_realTemplateField = new GridBagConstraints();
			gbc_realTemplateField.insets = new Insets(0, 0, 5, 0);
			gbc_realTemplateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_realTemplateField.gridx = 1;
			gbc_realTemplateField.gridy = 5;
			contentPanel.add(realTemplateField, gbc_realTemplateField);
			realTemplateField.setColumns(10);
		}
		{
			JLabel lblRefMaterial = new JLabel("Ref Material");
			GridBagConstraints gbc_lblRefMaterial = new GridBagConstraints();
			gbc_lblRefMaterial.anchor = GridBagConstraints.WEST;
			gbc_lblRefMaterial.insets = new Insets(0, 0, 5, 5);
			gbc_lblRefMaterial.gridx = 0;
			gbc_lblRefMaterial.gridy = 6;
			contentPanel.add(lblRefMaterial, gbc_lblRefMaterial);
		}
		{
			refMaterialField = new JTextField();
			GridBagConstraints gbc_refMaterialField = new GridBagConstraints();
			gbc_refMaterialField.insets = new Insets(0, 0, 5, 0);
			gbc_refMaterialField.fill = GridBagConstraints.HORIZONTAL;
			gbc_refMaterialField.gridx = 1;
			gbc_refMaterialField.gridy = 6;
			contentPanel.add(refMaterialField, gbc_refMaterialField);
			refMaterialField.setColumns(10);
		}
		{
			JLabel lblRefRealTemplate = new JLabel("Ref Real Template");
			GridBagConstraints gbc_lblRefRealTemplate = new GridBagConstraints();
			gbc_lblRefRealTemplate.insets = new Insets(0, 0, 5, 5);
			gbc_lblRefRealTemplate.anchor = GridBagConstraints.WEST;
			gbc_lblRefRealTemplate.gridx = 0;
			gbc_lblRefRealTemplate.gridy = 7;
			contentPanel.add(lblRefRealTemplate, gbc_lblRefRealTemplate);
		}
		{
			refRealTemplateField = new JTextField();
			GridBagConstraints gbc_refRealTemplateField = new GridBagConstraints();
			gbc_refRealTemplateField.insets = new Insets(0, 0, 5, 0);
			gbc_refRealTemplateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_refRealTemplateField.gridx = 1;
			gbc_refRealTemplateField.gridy = 7;
			contentPanel.add(refRealTemplateField, gbc_refRealTemplateField);
			refRealTemplateField.setColumns(10);
		}
		{
			JLabel lblDifficulty = new JLabel("Difficulty");
			GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
			gbc_lblDifficulty.anchor = GridBagConstraints.WEST;
			gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
			gbc_lblDifficulty.gridx = 0;
			gbc_lblDifficulty.gridy = 8;
			contentPanel.add(lblDifficulty, gbc_lblDifficulty);
		}
		{
			difficultyField = new JTextField();
			GridBagConstraints gbc_difficultyField = new GridBagConstraints();
			gbc_difficultyField.insets = new Insets(0, 0, 5, 0);
			gbc_difficultyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_difficultyField.gridx = 1;
			gbc_difficultyField.gridy = 8;
			contentPanel.add(difficultyField, gbc_difficultyField);
			difficultyField.setColumns(10);
		}
		{
			JLabel lblDescription = new JLabel("Description");
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.anchor = GridBagConstraints.WEST;
			gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescription.gridx = 0;
			gbc_lblDescription.gridy = 9;
			contentPanel.add(lblDescription, gbc_lblDescription);
		}
		{
			descriptionField = new JTextField();
			GridBagConstraints gbc_descriptionField = new GridBagConstraints();
			gbc_descriptionField.insets = new Insets(0, 0, 5, 0);
			gbc_descriptionField.fill = GridBagConstraints.HORIZONTAL;
			gbc_descriptionField.gridx = 1;
			gbc_descriptionField.gridy = 9;
			contentPanel.add(descriptionField, gbc_descriptionField);
			descriptionField.setColumns(10);
		}
		{
			JLabel lblAchievement = new JLabel("Achievement");
			GridBagConstraints gbc_lblAchievement = new GridBagConstraints();
			gbc_lblAchievement.anchor = GridBagConstraints.WEST;
			gbc_lblAchievement.insets = new Insets(0, 0, 5, 5);
			gbc_lblAchievement.gridx = 0;
			gbc_lblAchievement.gridy = 10;
			contentPanel.add(lblAchievement, gbc_lblAchievement);
		}
		{
			achievementField = new JTextField();
			GridBagConstraints gbc_achievementField = new GridBagConstraints();
			gbc_achievementField.insets = new Insets(0, 0, 5, 0);
			gbc_achievementField.fill = GridBagConstraints.HORIZONTAL;
			gbc_achievementField.gridx = 1;
			gbc_achievementField.gridy = 10;
			contentPanel.add(achievementField, gbc_achievementField);
			achievementField.setColumns(10);
		}
		{
			JLabel lblIcon = new JLabel("Icon");
			GridBagConstraints gbc_lblIcon = new GridBagConstraints();
			gbc_lblIcon.anchor = GridBagConstraints.WEST;
			gbc_lblIcon.insets = new Insets(0, 0, 5, 5);
			gbc_lblIcon.gridx = 0;
			gbc_lblIcon.gridy = 11;
			contentPanel.add(lblIcon, gbc_lblIcon);
		}
		{
			iconField = new JTextField();
			GridBagConstraints gbc_iconField = new GridBagConstraints();
			gbc_iconField.insets = new Insets(0, 0, 5, 0);
			gbc_iconField.fill = GridBagConstraints.HORIZONTAL;
			gbc_iconField.gridx = 1;
			gbc_iconField.gridy = 11;
			contentPanel.add(iconField, gbc_iconField);
			iconField.setColumns(10);
		}
		{
			useTemplateWeightCheckBox = new JCheckBox("Use Template Weight");
			GridBagConstraints gbc_useTemplateWeightCheckBox = new GridBagConstraints();
			gbc_useTemplateWeightCheckBox.anchor = GridBagConstraints.WEST;
			gbc_useTemplateWeightCheckBox.gridx = 1;
			gbc_useTemplateWeightCheckBox.gridy = 12;
			contentPanel.add(useTemplateWeightCheckBox, gbc_useTemplateWeightCheckBox);
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
						if(idField.getText().isEmpty())
						{
							RecipeEditor.instance.showErrorMessage("Error, Id Field is required.", "Id Error");
						}else
						{
							resultTemp = new Result().withId(idField.getText());
							if(!nameField.getText().isEmpty()){resultTemp = resultTemp.withName(nameField.getText());}
							if(!cstateField.getText().isEmpty()){resultTemp = resultTemp.withCstate(cstateField.getText());}
							if(!pstateField.getText().isEmpty()){resultTemp = resultTemp.withPstate(pstateField.getText());}
							if(!materialField.getText().isEmpty()){resultTemp = resultTemp.withMaterial(materialField.getText());}
							if(!realTemplateField.getText().isEmpty()){resultTemp = resultTemp.withRealtemplate(realTemplateField.getText());}
							if(!refMaterialField.getText().isEmpty()){resultTemp = resultTemp.withRefmaterial(refMaterialField.getText());}
							if(!refRealTemplateField.getText().isEmpty()){resultTemp = resultTemp.withRefrealtemplate(refRealTemplateField.getText());}
							if(!difficultyField.getText().isEmpty()){resultTemp = resultTemp.withDifficulty(Float.valueOf(difficultyField.getText()));}
							if(!descriptionField.getText().isEmpty()){resultTemp = resultTemp.withDescription(descriptionField.getText());}
							if(!achievementField.getText().isEmpty()){resultTemp = resultTemp.withAchievement(achievementField.getText());}
							if(useTemplateWeightCheckBox.isSelected()){resultTemp = resultTemp.withUsetemplateweight(true);}
							if(!iconField.getText().isEmpty()){resultTemp = resultTemp.withIcon(iconField.getText());}
							
							
							RecipeEditor.instance.recipe.setResult(resultTemp);
							RecipeEditor.instance.updateResultData();
							RecipeEditor.instance.resultDialog.setVisible(false);
						}
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
						RecipeEditor.instance.resultDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
