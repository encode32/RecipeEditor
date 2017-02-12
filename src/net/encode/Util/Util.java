package net.encode.Util;

import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Objects;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.encode.RecipeEditor.RecipeEditor;
import net.encode.Recipes.Recipe;

public class Util {
	public static Recipe importRecipe(JFileChooser fc, Container container)
	{
		Recipe recipe = new Recipe();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter filter = new FileNameExtensionFilter("JSON Files", "json");
		fc.setFileFilter(filter);
		int returnVal = fc.showSaveDialog(container);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			Gson gson = new Gson();
			
			FileInputStream fip = null;
			File file;
			try {
				File fileT = fc.getSelectedFile();
				String path = fileT.getPath();
				String decodedPath = URLDecoder.decode(path, "UTF-8");
				
				file = new File(decodedPath);
				fip = new FileInputStream(file);
				
				if (!file.exists()) {
					RecipeEditor.instance.showErrorMessage("Error: File not found.", "File Error");
					return recipe;
				}
				
				byte[] contentInBytes = new byte[(int) file.length()];
				
				fip.read(contentInBytes);
				fip.close();
				
				recipe = gson.fromJson(new String(contentInBytes), recipe.getClass());
				
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if (fip != null) {
						fip.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return recipe;
	}
	
	public static void exportRecipe(JFileChooser fc, Container container, Recipe recipe)
	{
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showSaveDialog(container);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String jsonString = gson.toJson(recipe);
			
			FileOutputStream fop = null;
			File file;
			try {
				File folder = fc.getSelectedFile();
				String path = folder.getPath();
				String decodedPath = URLDecoder.decode(path, "UTF-8");
				
				file = new File(decodedPath+"/recipe"+recipe.getRecipeid().toString()+".json");
				fop = new FileOutputStream(file);
				
				if (!file.exists()) {
					file.createNewFile();
				}
				
				byte[] contentInBytes = jsonString.getBytes();

				fop.write(contentInBytes);
				fop.flush();
				fop.close();

				System.out.println("Done");

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fop != null) {
						fop.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else
		{
			RecipeEditor.instance.showErrorMessage("File Error", "File Error");
		}
	}
	
	public static void addChangeListener(JTextComponent text, ChangeListener changeListener) {
	    Objects.requireNonNull(text);
	    Objects.requireNonNull(changeListener);
	    DocumentListener dl = new DocumentListener() {
	        private int lastChange = 0, lastNotifiedChange = 0;

	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            changedUpdate(e);
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            changedUpdate(e);
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            lastChange++;
	            SwingUtilities.invokeLater(() -> {
	                if (lastNotifiedChange != lastChange) {
	                    lastNotifiedChange = lastChange;
	                    changeListener.stateChanged(new ChangeEvent(text));
	                }
	            });
	        }
	    };
	    text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
	        Document d1 = (Document)e.getOldValue();
	        Document d2 = (Document)e.getNewValue();
	        if (d1 != null) d1.removeDocumentListener(dl);
	        if (d2 != null) d2.addDocumentListener(dl);
	        dl.changedUpdate(null);
	    });
	    Document d = text.getDocument();
	    if (d != null) d.addDocumentListener(dl);
	}
}
