package app.controllers;

import app.models.EmailModel;
import app.views.EmailView;
import app.views.LoginView;

import javax.swing.*;

public class EmailController extends Controller {

  public EmailController() {
    LoginView login_view = new LoginView();

    login_view.setButtonActionListener(login_view.getButton("close"), login_view::dispose);

    login_view.setButtonActionListener(login_view.getButton("submit"), () -> {
      login_view.setVisible(false);

      EmailView email_view = new EmailView();
      EmailModel email_model = new EmailModel();

      email_model.setEmailSender(login_view.getTextField("username").getText());
      email_model.setEmailPassword(login_view.getPasswordField("password").getPassword());

      email_view.setButtonActionListener(email_view.getButton("cancel_button"), () -> {
        login_view.setVisible(true);
        email_view.dispose();
      });

      email_view.setWindowCloseListener(() -> {
        login_view.setVisible(true);
      });

      email_view.setButtonActionListener(email_view.getButton("send_button"), () -> {
        email_model.setEmailSender(
            login_view.getTextField("username").getText()
        );
        email_model.setEmailPassword(
            login_view.getPasswordField("password").getPassword()
        );
        email_model.setEmailRecipient(
            email_view.getTextField("email_recipient").getText()
        );
        email_model.setEmailSubject(
            email_view.getTextField("email_subject").getText()
        );
        email_model.setEmailBody(
            email_view.getTextArea("email_body").getText()
        );

        if (email_model.sendEmail()) {
          JOptionPane.showMessageDialog(
            email_view,
            "E-mail sent successfully!",
            "Success",
          JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(
            email_view,
            "Oops, your e-mail could not be sent...",
            "Error",
          JOptionPane.ERROR_MESSAGE);
        }
      });
    });
  }

}