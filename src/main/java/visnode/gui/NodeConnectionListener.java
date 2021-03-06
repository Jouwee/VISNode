package visnode.gui;

import java.util.EventListener;

/**
 * Connection listener 
 */
public interface NodeConnectionListener extends EventListener {

    /**
     * Connection created
     * 
     * @param evt 
     */
    public void connectionCreated(NodeConnectionEvent evt);

    /**
     * Connection removed
     * 
     * @param evt 
     */
    public void connectionRemoved(NodeConnectionEvent evt);
    
}
