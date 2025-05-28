package app.views;

import java.awt.*;
import javax.swing.*;

public class EmailView extends View {

  public EmailView() {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    //===== PANELS =====//

    GridBagConstraints panelGBC = createGBC(15, 5, GridBagConstraints.BOTH);

    this.createPanel("header");
    this.add(this.getPanel("header"), initFullGBC(panelGBC, 0, 0, 1, 0, 1, 0, 5));

    this.createPanel("body");
    this.add(this.getPanel("body"), initGBC(panelGBC, 0, 1, 1, 1, 1));

    this.createPanel("footer");
    this.add(this.getPanel("footer"), initGBC(panelGBC, 0, 2, 1, 0, 1));

    this.createPanel("credits");
    this.add(this.getPanel("credits"), initGBC(panelGBC, 0, 3, 1, 0, 1));


    //===== HEADER =====//

    GridBagConstraints headerGBC = createGBC(5, 5, GridBagConstraints.HORIZONTAL);

    this.createLabel("title");
    this.getLabel("title").setText("Email");
    this.getPanel("header").add(this.getLabel("title"), initGBC(headerGBC, 0, 0, 1, 0, 3));

    this.createLabel("email_recipient");
    this.getLabel("email_recipient").setText("Aan:");
    this.getPanel("header").add(this.getLabel("email_recipient"), initGBC(headerGBC, 0, 1, 0, 0, 1));

    this.createTextField("email_recipient");
    this.getTextField("email_recipient").setColumns(30);
    this.getTextField("email_recipient").setText("voorbeeld@email.com");
    this.getPanel("header").add(this.getTextField("email_recipient"), initGBC(headerGBC, 1, 1, 1, 0, 2));

    this.createLabel("email_subject");
    this.getLabel("email_subject").setText("Onderwerp:");
    this.getPanel("header").add(this.getLabel("email_subject"), initGBC(headerGBC, 0, 2, 0, 0, 1));

    this.createTextField("email_subject");
    this.getTextField("email_subject").setColumns(30);
    this.getTextField("email_subject").setText("Dit is het onderwerp.");
    this.getPanel("header").add(this.getTextField("email_subject"), initGBC(headerGBC, 1, 2, 1, 0, 1));

    this.createButton("send_button");
    this.getButton("send_button").setText("Send");
    this.getPanel("header").add(this.getButton("send_button"), initGBC(headerGBC, 2, 2, 0, 0, 1));

    //===== BODY =====//

    GridBagConstraints bodyGBC = createGBC(5, 5, GridBagConstraints.HORIZONTAL);

    this.createTextArea("email_body");
    this.getTextArea("email_body").setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),  BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    this.getTextArea("email_body").setText(
        "Beste ontvanger," +
        "\n\n" +
        "dit is een voorbeeld e-mail, bedoelt voor het testen van de programma." +
        "\n\n" +
        "Met vriendelijke groet," +
        "\n\n" +
        "Jordan Groothuizen"
    );

    this.getPanel("body").add(this.getTextArea("email_body"), initFullGBC(bodyGBC, 0, 0, 1, 1, 1, 0, 100));

    //===== FOOTER =====//

    GridBagConstraints footerGBC = createGBC(5, 0, GridBagConstraints.HORIZONTAL);

    this.createButton("cancel_button");
    this.getButton("cancel_button").setText("Cancel");
    this.getPanel("footer").add(this.getButton("cancel_button"), initGBC(footerGBC, 0, 0, 0, 0, 1));

    //===== CREDITS =====//

    GridBagConstraints creditsGBC = createGBC(5, 0, GridBagConstraints.HORIZONTAL);

    this.createLabel("credits");
    this.getLabel("credits").setText("Door: Jordan Groothuizen");
    this.getPanel("credits").add(this.getLabel("credits"), initGBC(creditsGBC, 0, 0, 0, 0, 1));

    this.build();
  }
}
