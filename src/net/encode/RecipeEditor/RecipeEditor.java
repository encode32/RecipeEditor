package net.encode.RecipeEditor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URISyntaxException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.encode.Recipes.Any;
import net.encode.Recipes.Container;
import net.encode.Recipes.Cooker;
import net.encode.Recipes.Ingredient;
import net.encode.Recipes.Lootable;
import net.encode.Recipes.Mandatory;
import net.encode.Recipes.Oneof;
import net.encode.Recipes.Oneormore;
import net.encode.Recipes.Optional;
import net.encode.Recipes.Recipe;
import net.encode.Recipes.Zeroorone;
import net.encode.Util.Util;

import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RecipeEditor {

	public static RecipeEditor instance = null;
	
	public Recipe recipe;
	
	private JFrame frmWurmUnlimitedRecipe;
	private final JFileChooser fc = new JFileChooser();
	private JTextField nameField;
	private JTextField recipeIdField;
	private JTextField skillField;
	private JTextField triggerField;
	
	private List cookersList;
	private List mandatoryList;
	private List containersList;
	private List zeroOrOneList;
	private List activeList;
	private List oneOfList;
	private List targetList;
	private List oneOrMoreList;
	private List resultList;
	private List anyList;
	private List optionalList;
	
	public ActiveDialog activeDialog = new ActiveDialog(frmWurmUnlimitedRecipe, "Edit Active");
	public AnyDialog anyDialog = new AnyDialog(frmWurmUnlimitedRecipe, "Edit Any");
	public ContainersDialog containersDialog = new ContainersDialog(frmWurmUnlimitedRecipe, "Edit Containers");
	public CookersDialog cookersDialog = new CookersDialog(frmWurmUnlimitedRecipe, "Edit Cookers");
	public MandatoryDialog mandatoryDialog = new MandatoryDialog(frmWurmUnlimitedRecipe, "Edit Mandatory");
	public OneOfDialog oneOfDialog = new OneOfDialog(frmWurmUnlimitedRecipe, "Edit One of");
	public OneOrMoreDialog oneOrMoreDialog = new OneOrMoreDialog(frmWurmUnlimitedRecipe, "Edit One or More");
	public OptionalDialog optionalDialog = new OptionalDialog(frmWurmUnlimitedRecipe, "Edit Optional");
	public ResultDialog resultDialog = new ResultDialog(frmWurmUnlimitedRecipe, "Edit Result");
	public TargetDialog targetDialog = new TargetDialog(frmWurmUnlimitedRecipe, "Edit Target");
	public ZeroOrOneDialog zeroOrOneDialog = new ZeroOrOneDialog(frmWurmUnlimitedRecipe, "Edit Zero or One");

	private Choice lootableCreatureChoice;
	private Choice lootableRarityChoice;
	private JCheckBox knownCheckBox;
	private JCheckBox nameableCheckBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipeEditor window = new RecipeEditor();
					window.frmWurmUnlimitedRecipe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecipeEditor() {
		initialize();
		RecipeEditor.instance = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		recipe = new Recipe();
		
		File jarFile;
		try {
			jarFile = new File(RecipeEditor.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			
			fc.setCurrentDirectory(jarFile);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		frmWurmUnlimitedRecipe = new JFrame();
		frmWurmUnlimitedRecipe.setTitle("Wurm Unlimited Recipe Editor");
		frmWurmUnlimitedRecipe.setResizable(false);
		frmWurmUnlimitedRecipe.setBounds(100, 100, 630, 800);
		frmWurmUnlimitedRecipe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmWurmUnlimitedRecipe.setJMenuBar(menuBar);
		
		JButton btnImport = new JButton("Import");
		menuBar.add(btnImport);
		
		JButton btnExport = new JButton("Export");
		menuBar.add(btnExport);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 150, 150, 10, 150, 150,10};
		gridBagLayout.rowHeights = new int[]{20, 20, 21, 21, 14, 20, 20, 20, 23, 21, 23, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmWurmUnlimitedRecipe.getContentPane().setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel("Name");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		frmWurmUnlimitedRecipe.getContentPane().add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.NORTH;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 0;
		frmWurmUnlimitedRecipe.getContentPane().add(nameField, gbc_nameField);
		nameField.setColumns(10);
		Util.addChangeListener(nameField, new ChangeListener()
				{
					@Override
					public void stateChanged(ChangeEvent e) {
						recipe.setName(nameField.getText());
					}
				});
		
		JLabel lootableLabel = new JLabel("Lootable");
		GridBagConstraints gbc_lootableLabel = new GridBagConstraints();
		gbc_lootableLabel.anchor = GridBagConstraints.NORTH;
		gbc_lootableLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lootableLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lootableLabel.gridx = 4;
		gbc_lootableLabel.gridy = 0;
		frmWurmUnlimitedRecipe.getContentPane().add(lootableLabel, gbc_lootableLabel);
		
		JLabel recipeidLabel = new JLabel("RecipeId");
		GridBagConstraints gbc_recipeidLabel = new GridBagConstraints();
		gbc_recipeidLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_recipeidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_recipeidLabel.gridx = 1;
		gbc_recipeidLabel.gridy = 1;
		frmWurmUnlimitedRecipe.getContentPane().add(recipeidLabel, gbc_recipeidLabel);
		
		recipeIdField = new JTextField();
		GridBagConstraints gbc_recipeIdField = new GridBagConstraints();
		gbc_recipeIdField.anchor = GridBagConstraints.NORTH;
		gbc_recipeIdField.fill = GridBagConstraints.HORIZONTAL;
		gbc_recipeIdField.insets = new Insets(0, 0, 5, 5);
		gbc_recipeIdField.gridx = 2;
		gbc_recipeIdField.gridy = 1;
		frmWurmUnlimitedRecipe.getContentPane().add(recipeIdField, gbc_recipeIdField);
		recipeIdField.setColumns(10);
		Util.addChangeListener(recipeIdField, new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e) {
				recipe.setRecipeid(recipeIdField.getText());
			}
		});
		
		lootableCreatureChoice = new Choice();
		lootableCreatureChoice.add("");
		lootableCreatureChoice.add("anaconda");
		lootableCreatureChoice.add("bison");
		lootableCreatureChoice.add("black bear");
		lootableCreatureChoice.add("black dragon");
		lootableCreatureChoice.add("black dragon hatchling");
		lootableCreatureChoice.add("black wolf");
		lootableCreatureChoice.add("blue dragon");
		lootableCreatureChoice.add("blue dragon hatchling");
		lootableCreatureChoice.add("blue whale");
		lootableCreatureChoice.add("brown bear");
		lootableCreatureChoice.add("bull");
		lootableCreatureChoice.add("calf");
		lootableCreatureChoice.add("cave bug");
		lootableCreatureChoice.add("chicken");
		lootableCreatureChoice.add("cobra king");
		lootableCreatureChoice.add("cow");
		lootableCreatureChoice.add("crab");
		lootableCreatureChoice.add("crocodile");
		lootableCreatureChoice.add("deathcrawler minion");
		lootableCreatureChoice.add("deer");
		lootableCreatureChoice.add("dog");
		lootableCreatureChoice.add("dolphin");
		lootableCreatureChoice.add("drakespirit");
		lootableCreatureChoice.add("eaglespirit");
		lootableCreatureChoice.add("foal");
		lootableCreatureChoice.add("fog Spider");
		lootableCreatureChoice.add("forest giant");
		lootableCreatureChoice.add("goblin");
		lootableCreatureChoice.add("goblin leader");
		lootableCreatureChoice.add("green dragon");
		lootableCreatureChoice.add("green dragon hatchling");
		lootableCreatureChoice.add("hell horse");
		lootableCreatureChoice.add("hell hound");
		lootableCreatureChoice.add("hell scorpious");
		lootableCreatureChoice.add("hen");
		lootableCreatureChoice.add("horse");
		lootableCreatureChoice.add("huge spider");
		lootableCreatureChoice.add("kyklops");
		lootableCreatureChoice.add("lamb");
		lootableCreatureChoice.add("large rat");
		lootableCreatureChoice.add("lava fiend");
		lootableCreatureChoice.add("lava spider");
		lootableCreatureChoice.add("mountain gorilla");
		lootableCreatureChoice.add("mountain lion");
		lootableCreatureChoice.add("octopus");
		lootableCreatureChoice.add("pheasant");
		lootableCreatureChoice.add("pig");
		lootableCreatureChoice.add("rabid hyena");
		lootableCreatureChoice.add("ram");
		lootableCreatureChoice.add("red dragon");
		lootableCreatureChoice.add("red dragon hatchling");
		lootableCreatureChoice.add("rooster");
		lootableCreatureChoice.add("santa Claus");
		lootableCreatureChoice.add("scorpion");
		lootableCreatureChoice.add("sea serpent");
		lootableCreatureChoice.add("seal");
		lootableCreatureChoice.add("seal cub");
		lootableCreatureChoice.add("shark");
		lootableCreatureChoice.add("sheep");
		lootableCreatureChoice.add("sol Demon");
		lootableCreatureChoice.add("son of Nogump");
		lootableCreatureChoice.add("spawn of Uttacha");
		lootableCreatureChoice.add("spirit templar");
		lootableCreatureChoice.add("tortoise");
		lootableCreatureChoice.add("tower guard");
		lootableCreatureChoice.add("troll");
		lootableCreatureChoice.add("troll king");
		lootableCreatureChoice.add("unicorn");
		lootableCreatureChoice.add("white dragon");
		lootableCreatureChoice.add("white dragon hatchling");
		lootableCreatureChoice.add("wild boar");
		lootableCreatureChoice.add("wild cat");
		lootableCreatureChoice.add("worg");
		lootableCreatureChoice.add("zombie");
		lootableCreatureChoice.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	        	if(lootableRarityChoice.getSelectedIndex() == 0 && lootableCreatureChoice.getSelectedIndex() == 0)
	        	{
	        		recipe.setLootable(null);
	        	}else if(lootableRarityChoice.getSelectedIndex() != 0 && lootableCreatureChoice.getSelectedIndex() != 0)
	        	{
	        		Lootable lootable = new Lootable().withCreature(lootableCreatureChoice.getSelectedItem()).withRarity(lootableRarityChoice.getSelectedItem());
		        	recipe.setLootable(lootable);
	        	}
	        }
	    });
		
		GridBagConstraints gbc_lootableCreatureChoice = new GridBagConstraints();
		gbc_lootableCreatureChoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lootableCreatureChoice.anchor = GridBagConstraints.SOUTH;
		gbc_lootableCreatureChoice.insets = new Insets(0, 0, 5, 5);
		gbc_lootableCreatureChoice.gridx = 4;
		gbc_lootableCreatureChoice.gridy = 1;
		frmWurmUnlimitedRecipe.getContentPane().add(lootableCreatureChoice, gbc_lootableCreatureChoice);
		
		lootableRarityChoice = new Choice();
		lootableRarityChoice.add("");
		lootableRarityChoice.add("rare");
		lootableRarityChoice.add("supreme");
		lootableRarityChoice.add("fantastic");
		lootableRarityChoice.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	        	if(lootableRarityChoice.getSelectedIndex() == 0 && lootableCreatureChoice.getSelectedIndex() == 0)
	        	{
	        		recipe.setLootable(null);
	        	}else if(lootableRarityChoice.getSelectedIndex() != 0 && lootableCreatureChoice.getSelectedIndex() != 0)
	        	{
	        		Lootable lootable = new Lootable().withCreature(lootableCreatureChoice.getSelectedItem()).withRarity(lootableRarityChoice.getSelectedItem());
		        	recipe.setLootable(lootable);
	        	}
	        }
	    });
		
		GridBagConstraints gbc_lootableRarityChoice = new GridBagConstraints();
		gbc_lootableRarityChoice.anchor = GridBagConstraints.SOUTH;
		gbc_lootableRarityChoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lootableRarityChoice.insets = new Insets(0, 0, 5, 5);
		gbc_lootableRarityChoice.gridx = 5;
		gbc_lootableRarityChoice.gridy = 1;
		frmWurmUnlimitedRecipe.getContentPane().add(lootableRarityChoice, gbc_lootableRarityChoice);
		
		knownCheckBox = new JCheckBox("Known");
		knownCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					recipe.setKnown(true);
				}else
				{
					recipe.setKnown(null);
				}
			}
		});
		GridBagConstraints gbc_knownCheckBox = new GridBagConstraints();
		gbc_knownCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_knownCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_knownCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_knownCheckBox.gridx = 1;
		gbc_knownCheckBox.gridy = 2;
		frmWurmUnlimitedRecipe.getContentPane().add(knownCheckBox, gbc_knownCheckBox);
		
		JLabel skillLabel = new JLabel("Skill");
		GridBagConstraints gbc_skillLabel = new GridBagConstraints();
		gbc_skillLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_skillLabel.insets = new Insets(0, 0, 5, 5);
		gbc_skillLabel.gridx = 4;
		gbc_skillLabel.gridy = 2;
		frmWurmUnlimitedRecipe.getContentPane().add(skillLabel, gbc_skillLabel);
		
		skillField = new JTextField();
		GridBagConstraints gbc_skillField = new GridBagConstraints();
		gbc_skillField.anchor = GridBagConstraints.NORTH;
		gbc_skillField.fill = GridBagConstraints.HORIZONTAL;
		gbc_skillField.insets = new Insets(0, 0, 5, 5);
		gbc_skillField.gridx = 5;
		gbc_skillField.gridy = 2;
		frmWurmUnlimitedRecipe.getContentPane().add(skillField, gbc_skillField);
		skillField.setColumns(10);
		Util.addChangeListener(skillField, new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e) {
				recipe.setSkill(skillField.getText());
			}
		});
		
		nameableCheckBox = new JCheckBox("Nameable");
		nameableCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					recipe.setNameable(true);
				}else
				{
					recipe.setNameable(null);
				}
			}
		});
		GridBagConstraints gbc_nameableCheckBox = new GridBagConstraints();
		gbc_nameableCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_nameableCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameableCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_nameableCheckBox.gridx = 1;
		gbc_nameableCheckBox.gridy = 3;
		frmWurmUnlimitedRecipe.getContentPane().add(nameableCheckBox, gbc_nameableCheckBox);
		
		JLabel triggerLabel = new JLabel("Trigger");
		GridBagConstraints gbc_triggerLabel = new GridBagConstraints();
		gbc_triggerLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_triggerLabel.insets = new Insets(0, 0, 5, 5);
		gbc_triggerLabel.gridx = 4;
		gbc_triggerLabel.gridy = 3;
		frmWurmUnlimitedRecipe.getContentPane().add(triggerLabel, gbc_triggerLabel);
		
		triggerField = new JTextField();
		GridBagConstraints gbc_triggerField = new GridBagConstraints();
		gbc_triggerField.anchor = GridBagConstraints.NORTH;
		gbc_triggerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_triggerField.insets = new Insets(0, 0, 5, 5);
		gbc_triggerField.gridx = 5;
		gbc_triggerField.gridy = 3;
		frmWurmUnlimitedRecipe.getContentPane().add(triggerField, gbc_triggerField);
		triggerField.setColumns(10);
		Util.addChangeListener(triggerField, new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e) {
				recipe.setTrigger(triggerField.getText());
			}
		});
		
		JLabel cookersLabel = new JLabel("Cookers");
		GridBagConstraints gbc_cookersLabel = new GridBagConstraints();
		gbc_cookersLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cookersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cookersLabel.gridx = 1;
		gbc_cookersLabel.gridy = 5;
		frmWurmUnlimitedRecipe.getContentPane().add(cookersLabel, gbc_cookersLabel);
		
		JButton editCookersButton = new JButton("Edit Cookers");
		editCookersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cookersDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editCookersButton = new GridBagConstraints();
		gbc_editCookersButton.anchor = GridBagConstraints.NORTH;
		gbc_editCookersButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editCookersButton.insets = new Insets(0, 0, 5, 5);
		gbc_editCookersButton.gridx = 2;
		gbc_editCookersButton.gridy = 5;
		frmWurmUnlimitedRecipe.getContentPane().add(editCookersButton, gbc_editCookersButton);
		
		JLabel mandatoryLabel = new JLabel("Mandatory Ingredients");
		GridBagConstraints gbc_mandatoryLabel = new GridBagConstraints();
		gbc_mandatoryLabel.anchor = GridBagConstraints.WEST;
		gbc_mandatoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mandatoryLabel.gridx = 4;
		gbc_mandatoryLabel.gridy = 5;
		frmWurmUnlimitedRecipe.getContentPane().add(mandatoryLabel, gbc_mandatoryLabel);
		
		JButton editMandatoryButton = new JButton("Edit Mandatory");
		editMandatoryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mandatoryDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editMandatoryButton = new GridBagConstraints();
		gbc_editMandatoryButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editMandatoryButton.insets = new Insets(0, 0, 5, 5);
		gbc_editMandatoryButton.gridx = 5;
		gbc_editMandatoryButton.gridy = 5;
		frmWurmUnlimitedRecipe.getContentPane().add(editMandatoryButton, gbc_editMandatoryButton);
		
		cookersList = new List();
		GridBagConstraints gbc_cookersList = new GridBagConstraints();
		gbc_cookersList.anchor = GridBagConstraints.NORTH;
		gbc_cookersList.fill = GridBagConstraints.HORIZONTAL;
		gbc_cookersList.insets = new Insets(0, 0, 5, 5);
		gbc_cookersList.gridwidth = 2;
		gbc_cookersList.gridx = 1;
		gbc_cookersList.gridy = 6;
		frmWurmUnlimitedRecipe.getContentPane().add(cookersList, gbc_cookersList);
		
		mandatoryList = new List();
		GridBagConstraints gbc_mandatoryList = new GridBagConstraints();
		gbc_mandatoryList.fill = GridBagConstraints.HORIZONTAL;
		gbc_mandatoryList.gridwidth = 2;
		gbc_mandatoryList.insets = new Insets(0, 0, 5, 5);
		gbc_mandatoryList.gridx = 4;
		gbc_mandatoryList.gridy = 6;
		frmWurmUnlimitedRecipe.getContentPane().add(mandatoryList, gbc_mandatoryList);
		
		JLabel containersLabel = new JLabel("Containers");
		GridBagConstraints gbc_containersLabel = new GridBagConstraints();
		gbc_containersLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_containersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_containersLabel.gridx = 1;
		gbc_containersLabel.gridy = 7;
		frmWurmUnlimitedRecipe.getContentPane().add(containersLabel, gbc_containersLabel);
		
		JButton editContainersButton = new JButton("Edit Containers");
		editContainersButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				containersDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editContainersButton = new GridBagConstraints();
		gbc_editContainersButton.anchor = GridBagConstraints.NORTH;
		gbc_editContainersButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editContainersButton.insets = new Insets(0, 0, 5, 5);
		gbc_editContainersButton.gridx = 2;
		gbc_editContainersButton.gridy = 7;
		frmWurmUnlimitedRecipe.getContentPane().add(editContainersButton, gbc_editContainersButton);
		
		JLabel zeroOrOneLabel = new JLabel("Zero or One Ingredients");
		GridBagConstraints gbc_zeroOrOneLabel = new GridBagConstraints();
		gbc_zeroOrOneLabel.anchor = GridBagConstraints.WEST;
		gbc_zeroOrOneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_zeroOrOneLabel.gridx = 4;
		gbc_zeroOrOneLabel.gridy = 7;
		frmWurmUnlimitedRecipe.getContentPane().add(zeroOrOneLabel, gbc_zeroOrOneLabel);
		
		JButton editZeroOrOneButton = new JButton("Edit Zero or One");
		editZeroOrOneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				zeroOrOneDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editZeroOrOneButton = new GridBagConstraints();
		gbc_editZeroOrOneButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editZeroOrOneButton.insets = new Insets(0, 0, 5, 5);
		gbc_editZeroOrOneButton.gridx = 5;
		gbc_editZeroOrOneButton.gridy = 7;
		frmWurmUnlimitedRecipe.getContentPane().add(editZeroOrOneButton, gbc_editZeroOrOneButton);
		
		containersList = new List();
		GridBagConstraints gbc_containersList = new GridBagConstraints();
		gbc_containersList.insets = new Insets(0, 0, 5, 5);
		gbc_containersList.anchor = GridBagConstraints.NORTH;
		gbc_containersList.fill = GridBagConstraints.HORIZONTAL;
		gbc_containersList.gridwidth = 2;
		gbc_containersList.gridx = 1;
		gbc_containersList.gridy = 8;
		frmWurmUnlimitedRecipe.getContentPane().add(containersList, gbc_containersList);
		
		zeroOrOneList = new List();
		GridBagConstraints gbc_zeroOrOneList = new GridBagConstraints();
		gbc_zeroOrOneList.fill = GridBagConstraints.HORIZONTAL;
		gbc_zeroOrOneList.gridwidth = 2;
		gbc_zeroOrOneList.insets = new Insets(0, 0, 5, 5);
		gbc_zeroOrOneList.gridx = 4;
		gbc_zeroOrOneList.gridy = 8;
		frmWurmUnlimitedRecipe.getContentPane().add(zeroOrOneList, gbc_zeroOrOneList);
		
		JLabel activeLabel = new JLabel("Active");
		GridBagConstraints gbc_activeLabel = new GridBagConstraints();
		gbc_activeLabel.anchor = GridBagConstraints.WEST;
		gbc_activeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_activeLabel.gridx = 1;
		gbc_activeLabel.gridy = 9;
		frmWurmUnlimitedRecipe.getContentPane().add(activeLabel, gbc_activeLabel);
		
		JButton editActiveButton = new JButton("Edit Active");
		editActiveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				activeDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editActiveButton = new GridBagConstraints();
		gbc_editActiveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editActiveButton.insets = new Insets(0, 0, 5, 5);
		gbc_editActiveButton.gridx = 2;
		gbc_editActiveButton.gridy = 9;
		frmWurmUnlimitedRecipe.getContentPane().add(editActiveButton, gbc_editActiveButton);
		
		JLabel oneOfLabel = new JLabel("One of Ingredients");
		GridBagConstraints gbc_oneOfLabel = new GridBagConstraints();
		gbc_oneOfLabel.anchor = GridBagConstraints.WEST;
		gbc_oneOfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_oneOfLabel.gridx = 4;
		gbc_oneOfLabel.gridy = 9;
		frmWurmUnlimitedRecipe.getContentPane().add(oneOfLabel, gbc_oneOfLabel);
		
		JButton editOneOfButton = new JButton("Edit One of");
		editOneOfButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				oneOfDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editOneOfButton = new GridBagConstraints();
		gbc_editOneOfButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editOneOfButton.insets = new Insets(0, 0, 5, 5);
		gbc_editOneOfButton.gridx = 5;
		gbc_editOneOfButton.gridy = 9;
		frmWurmUnlimitedRecipe.getContentPane().add(editOneOfButton, gbc_editOneOfButton);
		
		activeList = new List();
		GridBagConstraints gbc_activeList = new GridBagConstraints();
		gbc_activeList.fill = GridBagConstraints.HORIZONTAL;
		gbc_activeList.gridwidth = 2;
		gbc_activeList.insets = new Insets(0, 0, 5, 5);
		gbc_activeList.gridx = 1;
		gbc_activeList.gridy = 10;
		frmWurmUnlimitedRecipe.getContentPane().add(activeList, gbc_activeList);
		
		oneOfList = new List();
		GridBagConstraints gbc_oneOfList = new GridBagConstraints();
		gbc_oneOfList.fill = GridBagConstraints.HORIZONTAL;
		gbc_oneOfList.gridwidth = 2;
		gbc_oneOfList.insets = new Insets(0, 0, 5, 5);
		gbc_oneOfList.gridx = 4;
		gbc_oneOfList.gridy = 10;
		frmWurmUnlimitedRecipe.getContentPane().add(oneOfList, gbc_oneOfList);
		
		JLabel targetLabel = new JLabel("Target");
		GridBagConstraints gbc_targetLabel = new GridBagConstraints();
		gbc_targetLabel.anchor = GridBagConstraints.WEST;
		gbc_targetLabel.insets = new Insets(0, 0, 5, 5);
		gbc_targetLabel.gridx = 1;
		gbc_targetLabel.gridy = 11;
		frmWurmUnlimitedRecipe.getContentPane().add(targetLabel, gbc_targetLabel);
		
		JButton editTargetButton = new JButton("Edit Target");
		editTargetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editTargetButton = new GridBagConstraints();
		gbc_editTargetButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editTargetButton.insets = new Insets(0, 0, 5, 5);
		gbc_editTargetButton.gridx = 2;
		gbc_editTargetButton.gridy = 11;
		frmWurmUnlimitedRecipe.getContentPane().add(editTargetButton, gbc_editTargetButton);
		
		JLabel oneOrMoreLabel = new JLabel("One or More Ingredients");
		GridBagConstraints gbc_oneOrMoreLabel = new GridBagConstraints();
		gbc_oneOrMoreLabel.anchor = GridBagConstraints.WEST;
		gbc_oneOrMoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_oneOrMoreLabel.gridx = 4;
		gbc_oneOrMoreLabel.gridy = 11;
		frmWurmUnlimitedRecipe.getContentPane().add(oneOrMoreLabel, gbc_oneOrMoreLabel);
		
		JButton editOneOrMoreButton = new JButton("Edit One or More");
		editOneOrMoreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				oneOrMoreDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editOneOrMoreButton = new GridBagConstraints();
		gbc_editOneOrMoreButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editOneOrMoreButton.insets = new Insets(0, 0, 5, 5);
		gbc_editOneOrMoreButton.gridx = 5;
		gbc_editOneOrMoreButton.gridy = 11;
		frmWurmUnlimitedRecipe.getContentPane().add(editOneOrMoreButton, gbc_editOneOrMoreButton);
		
		targetList = new List();
		GridBagConstraints gbc_targetList = new GridBagConstraints();
		gbc_targetList.fill = GridBagConstraints.HORIZONTAL;
		gbc_targetList.gridwidth = 2;
		gbc_targetList.insets = new Insets(0, 0, 5, 5);
		gbc_targetList.gridx = 1;
		gbc_targetList.gridy = 12;
		frmWurmUnlimitedRecipe.getContentPane().add(targetList, gbc_targetList);
		
		oneOrMoreList = new List();
		GridBagConstraints gbc_oneOrMoreList = new GridBagConstraints();
		gbc_oneOrMoreList.fill = GridBagConstraints.HORIZONTAL;
		gbc_oneOrMoreList.gridwidth = 2;
		gbc_oneOrMoreList.insets = new Insets(0, 0, 5, 5);
		gbc_oneOrMoreList.gridx = 4;
		gbc_oneOrMoreList.gridy = 12;
		frmWurmUnlimitedRecipe.getContentPane().add(oneOrMoreList, gbc_oneOrMoreList);
		
		JLabel resultLabel = new JLabel("Result");
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.anchor = GridBagConstraints.WEST;
		gbc_resultLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultLabel.gridx = 1;
		gbc_resultLabel.gridy = 13;
		frmWurmUnlimitedRecipe.getContentPane().add(resultLabel, gbc_resultLabel);
		
		JButton editResultButton = new JButton("Edit Result");
		editResultButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resultDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editResultButton = new GridBagConstraints();
		gbc_editResultButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editResultButton.insets = new Insets(0, 0, 5, 5);
		gbc_editResultButton.gridx = 2;
		gbc_editResultButton.gridy = 13;
		frmWurmUnlimitedRecipe.getContentPane().add(editResultButton, gbc_editResultButton);
		
		JLabel anyIngredientsLabel = new JLabel("Any Ingredients");
		GridBagConstraints gbc_anyIngredientsLabel = new GridBagConstraints();
		gbc_anyIngredientsLabel.anchor = GridBagConstraints.WEST;
		gbc_anyIngredientsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_anyIngredientsLabel.gridx = 4;
		gbc_anyIngredientsLabel.gridy = 13;
		frmWurmUnlimitedRecipe.getContentPane().add(anyIngredientsLabel, gbc_anyIngredientsLabel);
		
		JButton editAnyButton = new JButton("Edit Any");
		editAnyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anyDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editAnyButton = new GridBagConstraints();
		gbc_editAnyButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editAnyButton.insets = new Insets(0, 0, 5, 5);
		gbc_editAnyButton.gridx = 5;
		gbc_editAnyButton.gridy = 13;
		frmWurmUnlimitedRecipe.getContentPane().add(editAnyButton, gbc_editAnyButton);
		
		resultList = new List();
		GridBagConstraints gbc_resultList = new GridBagConstraints();
		gbc_resultList.gridheight = 3;
		gbc_resultList.fill = GridBagConstraints.BOTH;
		gbc_resultList.gridwidth = 2;
		gbc_resultList.insets = new Insets(0, 0, 5, 5);
		gbc_resultList.gridx = 1;
		gbc_resultList.gridy = 14;
		frmWurmUnlimitedRecipe.getContentPane().add(resultList, gbc_resultList);
		
		anyList = new List();
		GridBagConstraints gbc_anyList = new GridBagConstraints();
		gbc_anyList.fill = GridBagConstraints.HORIZONTAL;
		gbc_anyList.gridwidth = 2;
		gbc_anyList.insets = new Insets(0, 0, 5, 5);
		gbc_anyList.gridx = 4;
		gbc_anyList.gridy = 14;
		frmWurmUnlimitedRecipe.getContentPane().add(anyList, gbc_anyList);
		
		JLabel optionalLabel = new JLabel("Optional Ingredients");
		GridBagConstraints gbc_optionalLabel = new GridBagConstraints();
		gbc_optionalLabel.anchor = GridBagConstraints.WEST;
		gbc_optionalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_optionalLabel.gridx = 4;
		gbc_optionalLabel.gridy = 15;
		frmWurmUnlimitedRecipe.getContentPane().add(optionalLabel, gbc_optionalLabel);
		
		JButton editOptionalButton = new JButton("Edit Optional");
		editOptionalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionalDialog.setVisible(true);
			}
		});
		GridBagConstraints gbc_editOptionalButton = new GridBagConstraints();
		gbc_editOptionalButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_editOptionalButton.insets = new Insets(0, 0, 5, 5);
		gbc_editOptionalButton.gridx = 5;
		gbc_editOptionalButton.gridy = 15;
		frmWurmUnlimitedRecipe.getContentPane().add(editOptionalButton, gbc_editOptionalButton);
		
		optionalList = new List();
		GridBagConstraints gbc_optionalList = new GridBagConstraints();
		gbc_optionalList.fill = GridBagConstraints.HORIZONTAL;
		gbc_optionalList.gridwidth = 2;
		gbc_optionalList.insets = new Insets(0, 0, 5, 5);
		gbc_optionalList.gridx = 4;
		gbc_optionalList.gridy = 16;
		frmWurmUnlimitedRecipe.getContentPane().add(optionalList, gbc_optionalList);
		
		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recipe = Util.importRecipe(fc, frmWurmUnlimitedRecipe.getContentPane());
				if(recipe != null)
				{
					clearData();
					if(recipe.getName() != null){nameField.setText(recipe.getName());}
					if(recipe.getRecipeid() != null){recipeIdField.setText(recipe.getRecipeid());}
					if(recipe.getKnown() != null){knownCheckBox.setSelected(recipe.getKnown());}
					if(recipe.getNameable() != null){nameableCheckBox.setSelected(recipe.getNameable());}
					if(recipe.getSkill() != null){skillField.setText(recipe.getSkill());}
					if(recipe.getTrigger() != null){triggerField.setText(recipe.getTrigger());}
					
					if(recipe.getActive() != null){updateActiveData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getAny() != null){updateAnyData();}
					if(recipe.getContainers() != null){updateContainersData();}
					if(recipe.getCookers() != null){updateCookersData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getMandatory() != null){updateMandatoryData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getOneof() != null){updateOneOfData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getOneormore() != null){updateOneOrMoreData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getOptional() != null){updateOptionalData();}
					if(recipe.getResult() != null){updateResultData();}
					if(recipe.getTarget() != null){updateTargetData();}
					if(recipe.getIngredients() != null && recipe.getIngredients().getZeroorone() != null){updateZeroOrOneData();}
				}
			}
		});
		
		btnExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.exportRecipe(fc, frmWurmUnlimitedRecipe.getContentPane(), recipe);
			}
		});
	}
	
	public void clearData()
	{
		nameField.setText("");
		recipeIdField.setText("");
		knownCheckBox.setSelected(false);
		nameableCheckBox.setSelected(false);
		skillField.setText("");
		triggerField.setText("");
		
		activeList.removeAll();
		anyList.removeAll();
		containersList.removeAll();
		cookersList.removeAll();
		mandatoryList.removeAll();
		oneOfList.removeAll();
		oneOrMoreList.removeAll();
		optionalList.removeAll();
		resultList.removeAll();
		targetList.removeAll();
		zeroOrOneList.removeAll();
	}
	
	public void updateActiveData()
	{
		activeList.removeAll();
		if(recipe.getActive().getId() != null){activeList.add("Id: " + recipe.getActive().getId());}
		if(recipe.getActive().getCstate() != null){activeList.add("Cstate: " + recipe.getActive().getCstate());}
		if(recipe.getActive().getPstate() != null){activeList.add("Pstate:" + recipe.getActive().getPstate());}
		if(recipe.getActive().getMaterial() != null){activeList.add("Material: " + recipe.getActive().getMaterial());}
		if(recipe.getActive().getRealtemplate() != null){activeList.add("Real Template:" + recipe.getActive().getRealtemplate());}
		if(recipe.getActive().getDifficulty() != null){activeList.add("Difficulty: " + recipe.getActive().getDifficulty().toString());}
		if(recipe.getActive().getLoss() != null){activeList.add("Loss: " + recipe.getActive().getLoss().toString());}
		if(recipe.getActive().getRatio() != null){activeList.add("Ratio: " + recipe.getActive().getRatio().toString());}
	}
	
	public void updateAnyData()
	{
		anyList.removeAll();
		for(Any any : recipe.getIngredients().getAny())
		{
			anyList.add(
					(any.getId() != null ? "I: " + any.getId() : "") +
					(any.getCstate() != null ? " C: " + any.getCstate() : "") +
					(any.getPstate() != null ? " P: " + any.getPstate() : "") +
					(any.getMaterial() != null ? " M: " + any.getMaterial() : "") +
					(any.getRealtemplate() != null ? " RT: " + any.getRealtemplate() : "") +
					(any.getDifficulty() != null ? " D: " + any.getDifficulty() : "") +
					(any.getRatio() != null ? " R: " + any.getRatio() : "") +
					(any.getLoss() != null ? " L: " + any.getLoss() : "") +
					(any.getAmount() != null ? " A: " + any.getAmount() : ""));
		}
	}
	public void updateContainersData()
	{
		containersList.removeAll();
		for(Container container : recipe.getContainers())
		{
			containersList.add(
					(container.getId() != null ? "I: " + container.getId() : "") +
					(container.getDifficulty() != null ? " D: " + container.getDifficulty() : ""));
		}
	}
	
	public void updateCookersData()
	{
		cookersList.removeAll();
		for(Cooker cooker : recipe.getCookers())
		{
			cookersList.add(
					(cooker.getId() != null ? "I: " + cooker.getId() : "") +
					(cooker.getDifficulty() != null ? " D: " + cooker.getDifficulty() : ""));
		}
	}
	
	public void updateMandatoryData()
	{
		mandatoryList.removeAll();
		for(Mandatory mandatory : recipe.getIngredients().getMandatory())
		{
			mandatoryList.add(
					(mandatory.getId() != null ? "I: " + mandatory.getId() : "") +
					(mandatory.getCstate() != null ? " C: " + mandatory.getCstate() : "") +
					(mandatory.getPstate() != null ? " P: " + mandatory.getPstate() : "") +
					(mandatory.getMaterial() != null ? " M: " + mandatory.getMaterial() : "") +
					(mandatory.getRealtemplate() != null ? " RT: " + mandatory.getRealtemplate() : "") +
					(mandatory.getDifficulty() != null ? " D: " + mandatory.getDifficulty() : "") +
					(mandatory.getRatio() != null ? " R: " + mandatory.getRatio() : "") +
					(mandatory.getLoss() != null ? " L: " + mandatory.getLoss() : "") +
					(mandatory.getAmount() != null ? " A: " + mandatory.getAmount() : ""));
		}
	}
	
	public void updateOneOfData()
	{
		oneOfList.removeAll();
		for(Oneof oneOf : recipe.getIngredients().getOneof())
		{
			String ingredientList = "";
			for(Ingredient ingredient : oneOf.getList())
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
			oneOfList.add(ingredientList);
		}
	}
	
	public void updateOneOrMoreData()
	{
		oneOrMoreList.removeAll();
		for(Oneormore oneOrMore : recipe.getIngredients().getOneormore())
		{
			String ingredientList = "";
			for(Ingredient ingredient : oneOrMore.getList())
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
			oneOrMoreList.add(ingredientList);
		}
	}
	
	public void updateOptionalData()
	{
		optionalList.removeAll();
		for(Optional optional : recipe.getIngredients().getOptional())
		{
			optionalList.add(
					(optional.getId() != null ? "I: " + optional.getId() : "") +
					(optional.getCstate() != null ? " C: " + optional.getCstate() : "") +
					(optional.getPstate() != null ? " P: " + optional.getPstate() : "") +
					(optional.getMaterial() != null ? " M: " + optional.getMaterial() : "") +
					(optional.getRealtemplate() != null ? " RT: " + optional.getRealtemplate() : "") +
					(optional.getDifficulty() != null ? " D: " + optional.getDifficulty() : "") +
					(optional.getRatio() != null ? " R: " + optional.getRatio() : "") +
					(optional.getLoss() != null ? " L: " + optional.getLoss() : "") +
					(optional.getAmount() != null ? " A: " + optional.getAmount() : ""));
		}
	}
	
	public void updateResultData()
	{
		resultList.removeAll();
		if(recipe.getResult().getId() != null){resultList.add("Id: " + recipe.getResult().getId());}
		if(recipe.getResult().getName() != null){resultList.add("Name: " + recipe.getResult().getName());}
		if(recipe.getResult().getCstate() != null){resultList.add("Cstate: " + recipe.getResult().getCstate());}
		if(recipe.getResult().getPstate() != null){resultList.add("Pstate:" + recipe.getResult().getPstate());}
		if(recipe.getResult().getMaterial() != null){resultList.add("Material: " + recipe.getResult().getMaterial());}
		if(recipe.getResult().getRealtemplate() != null){resultList.add("Real Template:" + recipe.getResult().getRealtemplate());}
		if(recipe.getResult().getRefmaterial() != null){resultList.add("Ref Material: " + recipe.getResult().getRefmaterial());}
		if(recipe.getResult().getRefrealtemplate() != null){resultList.add("Ref Real Template: " + recipe.getResult().getRefrealtemplate());}
		if(recipe.getResult().getDifficulty() != null){resultList.add("Difficulty: " + recipe.getResult().getDifficulty().toString());}
		if(recipe.getResult().getDescription() != null){resultList.add("Description: " + recipe.getResult().getDescription());}
		if(recipe.getResult().getAchievement() != null){resultList.add("Achievement: " + recipe.getResult().getAchievement());}
		if(recipe.getResult().getUsetemplateweight() != null){resultList.add("Id: " + recipe.getResult().getUsetemplateweight().toString());}
		if(recipe.getResult().getIcon() != null){resultList.add("Id: " + recipe.getResult().getIcon());}
	}
	
	public void updateTargetData()
	{
		targetList.removeAll();
		if(recipe.getTarget().getId() != null){targetList.add("Id: " + recipe.getTarget().getId());}
		if(recipe.getTarget().getCstate() != null){targetList.add("Cstate: " + recipe.getTarget().getCstate());}
		if(recipe.getTarget().getPstate() != null){targetList.add("Pstate:" + recipe.getTarget().getPstate());}
		if(recipe.getTarget().getMaterial() != null){targetList.add("Material: " + recipe.getTarget().getMaterial());}
		if(recipe.getTarget().getRealtemplate() != null){targetList.add("Real Template:" + recipe.getTarget().getRealtemplate());}
		if(recipe.getTarget().getDifficulty() != null){targetList.add("Difficulty: " + recipe.getTarget().getDifficulty().toString());}
		if(recipe.getTarget().getLoss() != null){targetList.add("Loss: " + recipe.getTarget().getLoss().toString());}
		if(recipe.getTarget().getRatio() != null){targetList.add("Ratio: " + recipe.getTarget().getRatio().toString());}
		if(recipe.getTarget().getCreature() != null){targetList.add("Ratio: " + recipe.getTarget().getCreature().toString());}
	}
	
	public void updateZeroOrOneData()
	{
		zeroOrOneList.removeAll();
		for(Zeroorone zeroOrOne : recipe.getIngredients().getZeroorone())
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
	}
	
	public void showErrorMessage(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }

}
