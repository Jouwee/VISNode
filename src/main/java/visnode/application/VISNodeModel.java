package visnode.application;

import java.io.File;
import visnode.application.mvc.Model;
import visnode.application.mvc.PropertyEvent;

/**
 * Model of the application
 */
public class VISNodeModel implements Model {

    /** Node network */
    private NodeNetwork network;
    /** File linked to the current project */
    private File linkedFile;
    /** User preferences */
    private UserPreferences userPreferences;
    
    /**
     * Returns the node network
     * 
     * @return NodeNetwork
     */
    public NodeNetwork getNetwork() {
        if (network == null) {
            network = NodeNetworkFactory.create();
        }
        return network;
    }

    /**
     * Sets the node network
     * 
     * @param network 
     */
    public void setNetwork(NodeNetwork network) {
        NodeNetwork oldValue = this.network;
        this.network = network;
        oldValue.dispose();
        fireEvent(new PropertyEvent("network", oldValue, network));
    }

    /**
     * Returns the linked file
     * 
     * @return File
     */
    public File getLinkedFile() {
        return linkedFile;
    }

    /**
     * Sets the linked file
     * 
     * @param linkedFile 
     */
    public void setLinkedFile(File linkedFile) {
        File oldValue = this.linkedFile;
        this.linkedFile = linkedFile;
        fireEvent(new PropertyEvent("linkedFile", oldValue, linkedFile));
    }

    /**
     * Returns the user preferences
     * 
     * @return UserPreferences
     */
    public UserPreferences getUserPreferences() {
        if (userPreferences == null) {
            userPreferences = new UserPreferences();
        }
        return userPreferences;
    }

    /**
     * Sets the user preferences
     * 
     * @param userPreferences 
     */
    public void setUserPreferences(UserPreferences userPreferences) {
        UserPreferences oldValue = this.userPreferences;
        this.userPreferences = userPreferences;
        fireEvent(new PropertyEvent("userPreferences", oldValue, userPreferences));
    }
    
}
