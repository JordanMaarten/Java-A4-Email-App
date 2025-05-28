package app.interfaces;

import java.util.HashMap;

import java.awt.GridBagConstraints;

import javax.swing.*;

public interface ViewInterface {

  void build();

  void logComponentInfo();

  void logComponentNames();

  GridBagConstraints createGBC(int gapx, int gapy, int fill);

  GridBagConstraints initGBC(GridBagConstraints gbc, int gridx, int gridy, double wheightx, double weighty, int gridwidth);

  GridBagConstraints initFullGBC(GridBagConstraints gbc, int gridx, int gridy, double weightx, double weighty, int gridwidth, int ipadx, int ipady);

  GridBagConstraints initFullGBC(GridBagConstraints gbc, int gridx, int gridy, double weightx, double weighty, int gridwidth, int ipadx, int ipady, int anchor);

  void setWindowCloseListener(CallbackInterface callback);

  // PANELS

  HashMap<String, JPanel> panels = new HashMap<>();

  void createPanel(String panel_name);

  JPanel getPanel(String panel_name);

  // LABELS

  HashMap<String, JLabel> labels = new HashMap<>();

  void createLabel(String label_name);

  JLabel getLabel(String label_name);

  // TEXT AREAS

  HashMap<String, JTextArea> text_areas = new HashMap<>();

  void createTextArea(String text_area_name);

  JTextArea getTextArea(String text_area_name);

  // BUTTONS

  HashMap<String, JButton> buttons = new HashMap<>();

  void createButton(String button_name);

  JButton getButton(String button_name);

  void setButtonIcon(String button_name, String path);

  void setButtonActionListener(JButton button, CallbackInterface callback);

  // TEXT FIELDS

  HashMap<String, JTextField> text_fields = new HashMap<>();

  void createTextField(String text_field_name);

  JTextField getTextField(String text_field_name);

  // PASSWORD FIELDS

  HashMap<String, JPasswordField> password_fields = new HashMap<>();

  void createPasswordField(String password_field_name);

  JPasswordField getPasswordField(String password_field_name);
}
