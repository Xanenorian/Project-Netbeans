/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
package login.addressbook;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.model.DataModel;
import jakarta.faces.model.ListDataModel;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.tutorial.addressbook.ejb.ContactFacade;
import jakarta.tutorial.addressbook.entity.Contact;
import jakarta.tutorial.addressbook.web.util.JsfUtil;
import jakarta.tutorial.addressbook.web.util.PaginationHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import jakarta.faces.application.FacesMessage;

/**
 *
 * @author brend
 *//*
@Named
@SessionScoped
public class loginHelper implements Serializable{
    // Existing properties and methods...

    private String loginUserName;
    private String loginPassword;

    // Getter and setter methods for loginUserName and loginPassword...

    public String login() {
        // Check if the entered username and password exist in the database
        boolean validCredentials = checkCredentials(loginUserName, loginPassword);

        if (validCredentials) {
            // Login successful, navigate to a success page
            return "/showandtell.xhtml?faces-redirect=true";
        } else {
            // Invalid credentials, show an error message
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
            return null; // Stay on the same page
        }
    }

    private boolean checkCredentials(String username, String password) {

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if user with given credentials exists
                }
            }
        } catch (SQLException e) {
            // Handle SQLException (log, throw, etc.)
            e.printStackTrace();
        }

        return false; // Return false if an error occurs or no matching user is found
    }

}
*/