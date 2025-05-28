package app.views;

import app.interfaces.*;

import java.util.HashMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ViewInterface {

  public View() {
    this.getContentPane().setLayout(new GridBagLayout());
  }

  public void build() {
    this.pack();
    this.revalidate();
    this.repaint();

    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  // Logging methods that display a content tree of the components inside the JPanel Hashmap
  public void logComponentNames() {
    for (JPanel jp : this.panels.values()) {
      System.out.println("<" + jp.getName() + ">");
      for (Component c : jp.getComponents()) {
        System.out.println(" " + c.getName());
      }
      System.out.println();
    }
  }

  public void logComponentInfo() {
    for (JPanel jp : this.panels.values()) {
      System.out.println("<" + jp.getName().toUpperCase() + ">");
      System.out.println("<" + jp + ">");
      for (Component c : jp.getComponents()) {
        System.out.println();
        System.out.println("<" + c.getName().toUpperCase() + ">");
        System.out.println(c);
      }
      System.out.println();
    }
  }

  // GRID BAG CONSTRAINT

  // This method is used to create a GridBagConstraint.
  public GridBagConstraints createGBC(int gapx, int gapy, int fill) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = fill;
    gbc.insets = new Insets(gapy, gapx, gapy, gapx);
    return gbc;
  }

  // These methods are used when adding a GridBagConstraint to the JPanel/JFrame. They modify properties of an already exising GridBagConstraint class and return it.
  public GridBagConstraints initGBC(GridBagConstraints gbc, int gridx, int gridy, double wheightx, double weighty, int gridwidth) {
    gbc.gridx = gridx;
    gbc.gridy = gridy;
    gbc.weightx = wheightx;
    gbc.weighty = weighty;
    gbc.gridwidth = gridwidth;
    return gbc;
  }

  // More properties if needed
  public GridBagConstraints initFullGBC(GridBagConstraints gbc, int gridx, int gridy, double weightx, double weighty, int gridwidth, int ipadx, int ipady) {
    gbc.gridx = gridx;
    gbc.gridy = gridy;
    gbc.ipadx = ipadx;
    gbc.ipady = ipady;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    gbc.gridwidth = gridwidth;
    return gbc;
  }

  // Method overload including (int anchor)
  public GridBagConstraints initFullGBC(GridBagConstraints gbc, int gridx, int gridy, double weightx, double weighty, int gridwidth, int ipadx, int ipady, int anchor) {
    gbc.gridx = gridx;
    gbc.gridy = gridy;
    gbc.ipadx = ipadx;
    gbc.ipady = ipady;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    gbc.gridwidth = gridwidth;
    gbc.anchor = anchor;
    return gbc;
  }
  
  // The callback interface helps to prevent the scope from changing.
  public void setWindowCloseListener(CallbackInterface callback) {
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        callback.execCallback();
      }

      public void windowClosed(java.awt.event.WindowEvent windowEvent) {
        callback.execCallback();
      }
    });
  }

  // PANELS

  private final HashMap<String, JPanel> panels = new HashMap<>();

  public void createPanel(String panel_name) {
    JPanel jp = new JPanel();
    jp.setName(panel_name);
    jp.setLayout(this.getContentPane().getLayout());
    this.panels.put(panel_name, jp);
  }

  public JPanel getPanel(String panel_name) {
    return this.panels.get(panel_name);
  }
  
  // LABELS

  private final HashMap<String, JLabel> labels = new HashMap<>();

  public void createLabel(String label_name) {
    JLabel jl = new JLabel();
    jl.setName(label_name);
    this.labels.put(label_name, jl);
  }

  public JLabel getLabel(String label_name) {
    return this.labels.get(label_name);
  }

  // TEXT AREAS

  private final HashMap<String, JTextArea> text_areas = new HashMap<>();

  public void createTextArea(String text_area_name) {
    JTextArea jta = new JTextArea();
    jta.setName(text_area_name);
    this.text_areas.put(text_area_name, jta);
  }

  public JTextArea getTextArea(String text_area_name) {
    return this.text_areas.get(text_area_name);
  }

  // BUTTONS

  private final HashMap<String, JButton> buttons = new HashMap<>();

  public void createButton(String button_name) {
    JButton jb = new JButton();
    jb.setName(button_name);
    this.buttons.put(button_name, jb);
  }

  public JButton getButton(String button_name) {
    return this.buttons.get(button_name);
  }

  public void setButtonIcon(String button_name, String path) {
    this.getButton(button_name).setIcon(new ImageIcon(path));
  }
  
  // Using this method ensures the use of one action listener, instead of multiple on top of each other.
  public void setButtonActionListener(JButton button, CallbackInterface callback) {
    for( ActionListener al : button.getActionListeners() ) {
      System.out.println("Button: " + button + ". Already possesses an action listener, which will be replaced.");
      button.removeActionListener(al);
    }

    button.addActionListener(e -> callback.execCallback());
  }

  // TEXT FIELDS

  private final HashMap<String, JTextField> text_fields = new HashMap<>();

  public void createTextField(String text_field_name) {
    JTextField jtf = new JTextField();
    jtf.setName(text_field_name);
    this.text_fields.put(text_field_name, jtf);
  }

  public JTextField getTextField(String text_field_name) {
    return this.text_fields.get(text_field_name);
  }

  // PASSWORD FIELDS

  private final HashMap<String, JPasswordField> password_fields = new HashMap<>();

  public void createPasswordField(String password_field_name) {
    JPasswordField jpf = new JPasswordField();
    jpf.setName(password_field_name);
    this.password_fields.put(password_field_name, jpf);
  }

  public JPasswordField getPasswordField(String password_field_name) {
    return this.password_fields.get(password_field_name);
  }

}
