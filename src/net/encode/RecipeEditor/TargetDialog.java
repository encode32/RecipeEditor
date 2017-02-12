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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.encode.Recipes.Target;

public class TargetDialog extends JDialog {

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
	private JTextField lossField;
	private JTextField ratioField;
	private JTextField creatureField;
	
	private Target targetTemp;
	/**
	 * Create the dialog.
	 */
	public TargetDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getTarget() != null)
				{
					targetTemp = RecipeEditor.instance.recipe.getTarget();
					
					idField.setText(targetTemp.getId() != null ? targetTemp.getId() : "");
					cstateField.setText(targetTemp.getCstate() != null ? targetTemp.getCstate() : "");
					pstateField.setText(targetTemp.getPstate() != null ? targetTemp.getPstate() : "");
					materialField.setText(targetTemp.getMaterial() != null ? targetTemp.getMaterial() : "");
					realTemplateField.setText(targetTemp.getRealtemplate() != null ? targetTemp.getRealtemplate() : "");
					difficultyField.setText(targetTemp.getDifficulty() != null ? targetTemp.getDifficulty().toString() : "");
					lossField.setText(targetTemp.getLoss() != null ? targetTemp.getLoss().toString() : "");
					ratioField.setText(targetTemp.getRatio() != null ? targetTemp.getRatio().toString() : "");
					creatureField.setText(targetTemp.getCreature() != null ? targetTemp.getCreature() : "");
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
		gbl_contentPanel.columnWidths = new int[]{90, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblCstate = new JLabel("Cstate");
			GridBagConstraints gbc_lblCstate = new GridBagConstraints();
			gbc_lblCstate.anchor = GridBagConstraints.WEST;
			gbc_lblCstate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCstate.gridx = 0;
			gbc_lblCstate.gridy = 1;
			contentPanel.add(lblCstate, gbc_lblCstate);
		}
		{
			cstateField = new JTextField();
			GridBagConstraints gbc_cstateField = new GridBagConstraints();
			gbc_cstateField.insets = new Insets(0, 0, 5, 0);
			gbc_cstateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cstateField.gridx = 1;
			gbc_cstateField.gridy = 1;
			contentPanel.add(cstateField, gbc_cstateField);
			cstateField.setColumns(10);
		}
		{
			JLabel lblPstate = new JLabel("Pstate");
			GridBagConstraints gbc_lblPstate = new GridBagConstraints();
			gbc_lblPstate.anchor = GridBagConstraints.WEST;
			gbc_lblPstate.insets = new Insets(0, 0, 5, 5);
			gbc_lblPstate.gridx = 0;
			gbc_lblPstate.gridy = 2;
			contentPanel.add(lblPstate, gbc_lblPstate);
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
			JLabel lblMaterial = new JLabel("Material");
			GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
			gbc_lblMaterial.anchor = GridBagConstraints.WEST;
			gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
			gbc_lblMaterial.gridx = 0;
			gbc_lblMaterial.gridy = 3;
			contentPanel.add(lblMaterial, gbc_lblMaterial);
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
			JLabel lblRealTemplate = new JLabel("Real Template");
			GridBagConstraints gbc_lblRealTemplate = new GridBagConstraints();
			gbc_lblRealTemplate.anchor = GridBagConstraints.WEST;
			gbc_lblRealTemplate.insets = new Insets(0, 0, 5, 5);
			gbc_lblRealTemplate.gridx = 0;
			gbc_lblRealTemplate.gridy = 4;
			contentPanel.add(lblRealTemplate, gbc_lblRealTemplate);
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
			JLabel lblDifficulty = new JLabel("Difficulty");
			GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
			gbc_lblDifficulty.anchor = GridBagConstraints.WEST;
			gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
			gbc_lblDifficulty.gridx = 0;
			gbc_lblDifficulty.gridy = 5;
			contentPanel.add(lblDifficulty, gbc_lblDifficulty);
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
			JLabel lblLoss = new JLabel("Loss");
			GridBagConstraints gbc_lblLoss = new GridBagConstraints();
			gbc_lblLoss.anchor = GridBagConstraints.WEST;
			gbc_lblLoss.insets = new Insets(0, 0, 5, 5);
			gbc_lblLoss.gridx = 0;
			gbc_lblLoss.gridy = 6;
			contentPanel.add(lblLoss, gbc_lblLoss);
		}
		{
			lossField = new JTextField();
			GridBagConstraints gbc_lossField = new GridBagConstraints();
			gbc_lossField.insets = new Insets(0, 0, 5, 0);
			gbc_lossField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lossField.gridx = 1;
			gbc_lossField.gridy = 6;
			contentPanel.add(lossField, gbc_lossField);
			lossField.setColumns(10);
		}
		{
			JLabel lblRatio = new JLabel("Ratio");
			GridBagConstraints gbc_lblRatio = new GridBagConstraints();
			gbc_lblRatio.anchor = GridBagConstraints.WEST;
			gbc_lblRatio.insets = new Insets(0, 0, 5, 5);
			gbc_lblRatio.gridx = 0;
			gbc_lblRatio.gridy = 7;
			contentPanel.add(lblRatio, gbc_lblRatio);
		}
		{
			ratioField = new JTextField();
			GridBagConstraints gbc_ratioField = new GridBagConstraints();
			gbc_ratioField.insets = new Insets(0, 0, 5, 0);
			gbc_ratioField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ratioField.gridx = 1;
			gbc_ratioField.gridy = 7;
			contentPanel.add(ratioField, gbc_ratioField);
			ratioField.setColumns(10);
		}
		{
			JLabel lblCreature = new JLabel("Creature");
			GridBagConstraints gbc_lblCreature = new GridBagConstraints();
			gbc_lblCreature.anchor = GridBagConstraints.WEST;
			gbc_lblCreature.insets = new Insets(0, 0, 0, 5);
			gbc_lblCreature.gridx = 0;
			gbc_lblCreature.gridy = 8;
			contentPanel.add(lblCreature, gbc_lblCreature);
		}
		{
			creatureField = new JTextField();
			GridBagConstraints gbc_creatureField = new GridBagConstraints();
			gbc_creatureField.fill = GridBagConstraints.HORIZONTAL;
			gbc_creatureField.gridx = 1;
			gbc_creatureField.gridy = 8;
			contentPanel.add(creatureField, gbc_creatureField);
			creatureField.setColumns(10);
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
							targetTemp = new Target().withId(idField.getText());
							if(!cstateField.getText().isEmpty()){targetTemp = targetTemp.withCstate(cstateField.getText());}
							if(!pstateField.getText().isEmpty()){targetTemp = targetTemp.withPstate(pstateField.getText());}
							if(!materialField.getText().isEmpty()){targetTemp = targetTemp.withMaterial(materialField.getText());}
							if(!realTemplateField.getText().isEmpty()){targetTemp = targetTemp.withRealtemplate(realTemplateField.getText());}
							if(!difficultyField.getText().isEmpty()){targetTemp = targetTemp.withDifficulty(Float.valueOf(difficultyField.getText()));}
							if(!ratioField.getText().isEmpty()){targetTemp = targetTemp.withRatio(Float.valueOf(ratioField.getText()));}
							if(!lossField.getText().isEmpty()){targetTemp = targetTemp.withLoss(Float.valueOf(lossField.getText()));}
							if(!creatureField.getText().isEmpty()){targetTemp = targetTemp.withCstate(creatureField.getText());}
							
							RecipeEditor.instance.recipe.setTarget(targetTemp);
							RecipeEditor.instance.updateTargetData();
							RecipeEditor.instance.targetDialog.setVisible(false);
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
						RecipeEditor.instance.targetDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
