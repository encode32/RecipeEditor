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

import net.encode.Recipes.Ingredient;
import net.encode.Recipes.Ingredients;
import net.encode.Recipes.Zeroorone;

public class ZeroOrOneDialog extends JDialog {

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
	
	private List ingredientList;
	private List zeroOrOneList;
	private java.util.List<Ingredient> ingredientListTemp = new ArrayList<Ingredient>();
	private java.util.List<Zeroorone> zeroOrOneListTemp = new ArrayList<Zeroorone>();
	/**
	 * Create the dialog.
	 */
	public ZeroOrOneDialog(JFrame parent, String title) {
		super(parent, title);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(RecipeEditor.instance.recipe.getIngredients() != null && RecipeEditor.instance.recipe.getIngredients().getZeroorone() != null)
				{
					zeroOrOneListTemp = RecipeEditor.instance.recipe.getIngredients().getZeroorone();
					
					ingredientList.removeAll();
					zeroOrOneList.removeAll();
					for(Zeroorone zeroOrOne : zeroOrOneListTemp)
					{
						String ingredientList = "";
						for(Ingredient ingredient : zeroOrOne.getList())
						{
							ingredientList +=
									"[" +
									(ingredient.getId() != null ? "I: " + ingredient.getId() : "") +
									(ingredient.getCstate() != null ? " C: " + ingredient.getCstate() : "") +
									(ingredient.getPstate() != null ? " P: " + ingredient.getPstate() : "") +
									(ingredient.getMaterial() != null ? " M: " + ingredient.getMaterial() : "") +
									(ingredient.getRealtemplate() != null ? " RT: " + ingredient.getRealtemplate() : "") +
									(ingredient.getDifficulty() != null ? " D: " + ingredient.getDifficulty().toString() : "") +
									(ingredient.getRatio() != null ? " R: " + ingredient.getRatio().toString() : "") +
									(ingredient.getLoss() != null ? " L: " + ingredient.getLoss().toString() : "") +
									(ingredient.getAmount() != null ? " R: " + ingredient.getAmount().toString() : "") +
									"]";
						}
						zeroOrOneList.add(ingredientList);
					}
				}
			}
		});
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 350, 617);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 110, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblRealtemplate = new JLabel("RealTemplate");
			GridBagConstraints gbc_lblRealtemplate = new GridBagConstraints();
			gbc_lblRealtemplate.anchor = GridBagConstraints.WEST;
			gbc_lblRealtemplate.insets = new Insets(0, 0, 5, 5);
			gbc_lblRealtemplate.gridx = 0;
			gbc_lblRealtemplate.gridy = 4;
			contentPanel.add(lblRealtemplate, gbc_lblRealtemplate);
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
			JLabel lblRatio = new JLabel("Ratio");
			GridBagConstraints gbc_lblRatio = new GridBagConstraints();
			gbc_lblRatio.anchor = GridBagConstraints.WEST;
			gbc_lblRatio.insets = new Insets(0, 0, 5, 5);
			gbc_lblRatio.gridx = 0;
			gbc_lblRatio.gridy = 6;
			contentPanel.add(lblRatio, gbc_lblRatio);
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
			JLabel lblLoss = new JLabel("Loss");
			GridBagConstraints gbc_lblLoss = new GridBagConstraints();
			gbc_lblLoss.anchor = GridBagConstraints.WEST;
			gbc_lblLoss.insets = new Insets(0, 0, 5, 5);
			gbc_lblLoss.gridx = 0;
			gbc_lblLoss.gridy = 7;
			contentPanel.add(lblLoss, gbc_lblLoss);
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
			JLabel lblAmount = new JLabel("Amount");
			GridBagConstraints gbc_lblAmount = new GridBagConstraints();
			gbc_lblAmount.anchor = GridBagConstraints.WEST;
			gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
			gbc_lblAmount.gridx = 0;
			gbc_lblAmount.gridy = 8;
			contentPanel.add(lblAmount, gbc_lblAmount);
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
			JButton addIngredientButton = new JButton("Add Ingredient");
			addIngredientButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(idField.getText().isEmpty())
					{
						RecipeEditor.instance.showErrorMessage("Error, Id Field is required.", "Id Error");
					}else
					{
						Ingredient ingredientTemp = new Ingredient().withId(idField.getText());
						
						if(!cstateField.getText().isEmpty()){ingredientTemp = ingredientTemp.withCstate(cstateField.getText());}
						if(!pstateField.getText().isEmpty()){ingredientTemp = ingredientTemp.withPstate(pstateField.getText());}
						if(!materialField.getText().isEmpty()){ingredientTemp = ingredientTemp.withMaterial(materialField.getText());}
						if(!realTemplateField.getText().isEmpty()){ingredientTemp = ingredientTemp.withRealtemplate(realTemplateField.getText());}
						if(!difficultyField.getText().isEmpty()){ingredientTemp = ingredientTemp.withDifficulty(Float.valueOf(difficultyField.getText()));}
						if(!ratioField.getText().isEmpty()){ingredientTemp = ingredientTemp.withRatio(Float.valueOf(ratioField.getText()));}
						if(!lossField.getText().isEmpty()){ingredientTemp = ingredientTemp.withLoss(Float.valueOf(lossField.getText()));}
						if(!amountField.getText().isEmpty()){ingredientTemp = ingredientTemp.withAmount(Float.valueOf(amountField.getText()));}
						
						ingredientList.add(
								(idField.getText().isEmpty() ? "" : " I: " + idField.getText()) +
								(cstateField.getText().isEmpty() ? "" : " C: " + cstateField.getText()) +
								(pstateField.getText().isEmpty() ? "" : " P: " + pstateField.getText()) +
								(materialField.getText().isEmpty() ? "" : " M: " + materialField.getText()) +
								(realTemplateField.getText().isEmpty() ? "" : " RT: " + realTemplateField.getText()) +
								(difficultyField.getText().isEmpty() ? "" : " D: " + difficultyField.getText()) +
								(ratioField.getText().isEmpty() ? "" : " R: " + ratioField.getText()) +
								(lossField.getText().isEmpty() ? "" : " L: " + lossField.getText()) +
								(amountField.getText().isEmpty() ? "" : " A: " + amountField.getText()));
						ingredientListTemp.add(ingredientTemp);
					}
				}
			});
			GridBagConstraints gbc_addIngredientButton = new GridBagConstraints();
			gbc_addIngredientButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_addIngredientButton.insets = new Insets(0, 0, 5, 5);
			gbc_addIngredientButton.gridx = 0;
			gbc_addIngredientButton.gridy = 9;
			contentPanel.add(addIngredientButton, gbc_addIngredientButton);
		}
		{
			ingredientList = new List();
			GridBagConstraints gbc_ingredientList = new GridBagConstraints();
			gbc_ingredientList.fill = GridBagConstraints.BOTH;
			gbc_ingredientList.gridwidth = 2;
			gbc_ingredientList.insets = new Insets(0, 0, 5, 5);
			gbc_ingredientList.gridx = 0;
			gbc_ingredientList.gridy = 10;
			contentPanel.add(ingredientList, gbc_ingredientList);
		}
		{
			JButton deleteIngredientButton = new JButton("Delete Ingredient");
			deleteIngredientButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = ingredientList.getSelectedIndex();
					if(index != -1)
					{
						ingredientListTemp.remove(ingredientList.getSelectedIndex());
						ingredientList.remove(ingredientList.getSelectedIndex());
					}
				}
			});
			GridBagConstraints gbc_deleteIngredientButton = new GridBagConstraints();
			gbc_deleteIngredientButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_deleteIngredientButton.insets = new Insets(0, 0, 5, 5);
			gbc_deleteIngredientButton.gridx = 0;
			gbc_deleteIngredientButton.gridy = 11;
			contentPanel.add(deleteIngredientButton, gbc_deleteIngredientButton);
		}
		{
			JButton addListButton = new JButton("Add List");
			addListButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					java.util.List<Ingredient> ingredientAddList = new ArrayList<Ingredient>();
					for(Ingredient ingredient : ingredientListTemp){ingredientAddList.add(ingredient);}
					zeroOrOneListTemp.add(new Zeroorone().withList(ingredientAddList));
					
					zeroOrOneList.removeAll();
					for(Zeroorone zeroOrOne : zeroOrOneListTemp)
					{
						String ingredientList = "";
						for(Ingredient ingredient : zeroOrOne.getList())
						{
							ingredientList += 
									"[" +
									(ingredient.getId() != null ? "I: " + ingredient.getId() : "") +
									(ingredient.getCstate() != null ? " C: " + ingredient.getCstate() : "") +
									(ingredient.getPstate() != null ? " P: " + ingredient.getPstate() : "") +
									(ingredient.getMaterial() != null ? " M: " + ingredient.getMaterial() : "") +
									(ingredient.getRealtemplate() != null ? " RT: " + ingredient.getRealtemplate() : "") +
									(ingredient.getDifficulty() != null ? " D: " + ingredient.getDifficulty() : "") +
									(ingredient.getRatio() != null ? " R: " + ingredient.getRatio() : "") +
									(ingredient.getLoss() != null ? " L: " + ingredient.getLoss() : "") +
									(ingredient.getAmount() != null ? " A: " + ingredient.getAmount() : "") +
									"]";
						}
						zeroOrOneList.add(ingredientList);
					}
					ingredientList.removeAll();
					ingredientListTemp.clear();
				}
			});
			GridBagConstraints gbc_addListButton = new GridBagConstraints();
			gbc_addListButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_addListButton.insets = new Insets(0, 0, 5, 5);
			gbc_addListButton.gridx = 0;
			gbc_addListButton.gridy = 12;
			contentPanel.add(addListButton, gbc_addListButton);
		}
		{
			zeroOrOneList = new List();
			GridBagConstraints gbc_zeroOrOneList = new GridBagConstraints();
			gbc_zeroOrOneList.gridwidth = 2;
			gbc_zeroOrOneList.fill = GridBagConstraints.BOTH;
			gbc_zeroOrOneList.insets = new Insets(0, 0, 5, 5);
			gbc_zeroOrOneList.gridx = 0;
			gbc_zeroOrOneList.gridy = 13;
			contentPanel.add(zeroOrOneList, gbc_zeroOrOneList);
		}
		{
			JButton deleteListButton = new JButton("Delete List");
			deleteListButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = zeroOrOneList.getSelectedIndex();
					if(index != -1)
					{
						zeroOrOneListTemp.remove(zeroOrOneList.getSelectedIndex());
						zeroOrOneList.remove(zeroOrOneList.getSelectedIndex());
					}
				}
			});
			GridBagConstraints gbc_deleteListButton = new GridBagConstraints();
			gbc_deleteListButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_deleteListButton.insets = new Insets(0, 0, 0, 5);
			gbc_deleteListButton.gridx = 0;
			gbc_deleteListButton.gridy = 14;
			contentPanel.add(deleteListButton, gbc_deleteListButton);
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
							RecipeEditor.instance.recipe.setIngredients(new Ingredients().withZeroorone(zeroOrOneListTemp));
						}else
						{
							RecipeEditor.instance.recipe.getIngredients().setZeroorone(zeroOrOneListTemp);
						}
						RecipeEditor.instance.updateZeroOrOneData();
						RecipeEditor.instance.zeroOrOneDialog.setVisible(false);
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
						RecipeEditor.instance.zeroOrOneDialog.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
