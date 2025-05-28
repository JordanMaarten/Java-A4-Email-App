package app.views;

import java.awt.*;
import javax.swing.*;

public class LoginView extends View {

  public LoginView() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //===== PANELS =====//

    GridBagConstraints panelGBC = createGBC(15, 10, GridBagConstraints.HORIZONTAL);

    this.createPanel("header");
    this.getContentPane().add(this.getPanel("header"), initGBC(panelGBC, 0, 0, 1, 0, 1));

    this.createPanel("body");
    this.getContentPane().add(this.getPanel("body"), initGBC(panelGBC, 0, 1, 1, 0, 1));

    this.createPanel("footer");
    this.getContentPane().add(this.getPanel("footer"), initGBC(panelGBC, 0, 2, 1, 0, 1));

    // ===== HEADER =====//

    GridBagConstraints headerGBC = createGBC(5, 5, GridBagConstraints.HORIZONTAL);

    this.createLabel("title");
    this.getLabel("title").setText("Login");
    this.getPanel("header").add(this.getLabel("title"), initGBC(headerGBC, 0, 0, 1, 0, 1));

    //===== BODY =====//

    GridBagConstraints bodyGBC = createGBC(5, 5, GridBagConstraints.HORIZONTAL);

    this.createLabel("username_label");
    this.getLabel("username_label").setText("Gebruikersnaam:");
    this.getPanel("body").add(this.getLabel("username_label"), initGBC(bodyGBC, 0, 0, 0, 0, 1));

    this.createTextField("username");
    this.getTextField("username").setColumns(20);
    this.getTextField("username").setText("jordan@email.com");
    this.getPanel("body").add(this.getTextField("username"), initGBC(bodyGBC, 1, 0, 1, 0, 1));


    this.createLabel("password_label");
    this.getLabel("password_label").setText("Wachtwoord:");
    this.getPanel("body").add(this.getLabel("password_label"), initGBC(bodyGBC, 0, 1, 0, 0, 1));

    this.createPasswordField("password");
    this.getPasswordField("password").setColumns(20);
    this.getPasswordField("password").setText("wachtwoord");
    this.getPanel("body").add(this.getPasswordField("password"), initGBC(bodyGBC, 1, 1, 1, 0, 1));

    //===== FOOTER =====//

    GridBagConstraints footerGBC = createGBC(5, 5, GridBagConstraints.HORIZONTAL);

    this.createButton("close");
    this.getButton("close").setText("Close");
    this.getPanel("footer").add(this.getButton("close"), initGBC(footerGBC, 0, 0, 0, 0, 1));

    this.createButton("submit");
    this.getButton("submit").setText("Login");
    this.getPanel("footer").add(this.getButton("submit"), initGBC(footerGBC, 1, 0, 0, 0, 1));

    this.build();
  }
}
