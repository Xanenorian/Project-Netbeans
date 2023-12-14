/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jakarta.tutorial.addressbook.web.util;

import jakarta.ejb.Stateless;
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
import jakarta.tutorial.addressbook.web.ContactController;
import jakarta.tutorial.addressbook.web.util.JsfUtil;
import jakarta.tutorial.addressbook.web.util.PaginationHelper;

@Stateless
public class AuthenticationManager {

    @EJB
    private ContactFacade contactFacade;
    private void init() {
        if (contactFacade == null) {
            contactFacade = new ContactFacade(); // You might need to adjust instantiation based on your actual ContactFacade class
            // You can also set other properties or dependencies here
        }
    }
    public Contact authenticateUser(String username, String password) {  
        init();
        try {
            Contact authenticatedUser = contactFacade.findByUsernameAndPassword(username, password);

            // Return the authenticated user or null if authentication fails
            return authenticatedUser;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., NoResultException for non-existing user)
            return null;
        }
    }
}

