package at.qe.sepm.skeleton.services;

import at.qe.sepm.skeleton.model.User;
import at.qe.sepm.skeleton.model.UserRole;
import at.qe.sepm.skeleton.repositories.UserRepository;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * Service for accessing and manipulating user data.
 *
 * This class is part of the skeleton project provided for students of the
 * courses "Software Architecture" and "Software Engineering" offered by the
 * University of Innsbruck.
 */
@Component
@Scope("application")
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Returns a collection of all users.
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Returns all the cabin staff
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<User> getAllStaff(){
        return userRepository.findByTwoRoles(UserRole.PILOT, UserRole.CABINSTAFF);
    }

    /**
     * Returns all pilots
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<User> getAllPilots(){
        return userRepository.findByRole(UserRole.PILOT);
    }

    /**
     * Returns all pilots
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<User> getAllCrewMembers(){
        return userRepository.findByRole(UserRole.CABINSTAFF);
    }

    public Collection<User> getAllAvailableStaff(UserRole role) {
        return userRepository.findAvailableStaff(role);
    }

    /**
     * Returns a list of all users with the given role
     *
     * @param role
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<User> getAllUsersByRole(String role){
        if (role.equals("Admin")){
            return userRepository.findByRole(UserRole.ADMIN);
        } else if (role.equals("Manager")){
            return userRepository.findByRole(UserRole.MANAGER);
        }
        else if(role.equals("Pilot")){
            return userRepository.findByRole(UserRole.PILOT);
        } else if (role.equals("Cabinstaff")){
            return userRepository.findByRole(UserRole.CABINSTAFF);
        }else {
            return userRepository.findAll();
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<User> getAllUsersByUsername(String username){
        return userRepository.findByUsernamePrefix(username);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public Collection<User> getAllStaffByUsername(String username){
        return userRepository.findStaffByUsernamePrefix(username, UserRole.PILOT, UserRole.CABINSTAFF);
    }

    /**
     * Loads a single user identified by its username.
     *
     * @param username the username to search for
     * @return the user with the given username
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER') or principal.username eq #username")
    public User loadUser(String username) {
        return userRepository.findFirstByUsername(username);
    }

    /**
     * Saves the user. This method will also set {User#createDate} for new
     * entities or {User#updateDate} for updated entities. The user
     * requesting this operation will also be stored as {User#createDate}
     * or {User#updateUser} respectively.
     *
     * @param user the user to save
     * @return the updated user
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public User saveUser(User user) {
        if (user.isNew()) {
            user.setCreateDate(new Date());
            user.setCreateUser(getAuthenticatedUser());
        } else {
            user.setUpdateDate(new Date());
            user.setUpdateUser(getAuthenticatedUser());
        }
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void addNewUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setEnabled(user.isEnabled());
        newUser.setBusinessNumber(user.getBusinessNumber());
        newUser.setRoles(user.getRoles());
        saveUser(newUser);
    }

    /**
     * Deletes the user.
     *
     * @param user the user to delete
     */
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
    public void deleteUser(User user) {
        userRepository.delete(user);
        logger.info(user + " is permanently deleted");
    }

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findFirstByUsername(auth.getName());
    }

}
