package visnode.gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * Node container
 */
public class JNodeContainer extends JComponent {

    /** Selection of nodes */
    private final Selection<JNode> selection;
    /** Select listener */
    private final SelectListener selectListener;
    
    /**
     * Creates a new NodeContainer
     */
    public JNodeContainer() {
        super();
        this.selection = new Selection<>();
        this.selectListener = new SelectListener();
        initGui();
        registerListeners();
    }

    /**
     * Inititalizes the interface
     */
    private void initGui() {
        setLayout(null);
        setupDragSupport();
    }

    /**
     * Sets up the drag support
     */
    private void setupDragSupport() {
        DragSupport dragSupport = new DragSupport(this);
        dragSupport.setAllowDragPredicate((component) -> component instanceof JNode || component instanceof JConnectorPoint);
    }

    /**
     * Register the listeners
     */
    private void registerListeners() {
        addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                if (e.getChild() instanceof JNode) {
                    e.getChild().addMouseListener(selectListener);
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (e.getChild() instanceof JNode) {
                    e.getChild().removeMouseListener(selectListener);
                }
            }
        });
    }
    
    /** 
     * Starts a connection
     * 
     * @param connectorPoint
     * @param e 
     */
    public void startConnection(JConnectorPoint connectorPoint, MouseEvent e) {
        add(new JNodeToMouseConnection(this, connectorPoint));
    }

    /**
     * Returns the connector point in a specified position
     * 
     * @param point
     * @return JConnectorPoint
     */
    public JConnectorPoint getConnectorPointAt(Point point) {
        return getConnectorPointAtRecursive(this, point);
    }

    /**
     * Returns the connector point in a specified position
     * 
     * @param point
     * @return JConnectorPoint
     */
    private JConnectorPoint getConnectorPointAtRecursive(Component parent, Point point) {
        point = new Point(point);
        point.translate(-parent.getX(), -parent.getY());
        Component at = parent.getComponentAt(point);
        if (at instanceof JConnectorPoint) {
            return (JConnectorPoint) at;
        }
        if (at instanceof JNode || at instanceof JNodeConnector) {
            return getConnectorPointAtRecursive(at, point);
        }
        return null;
    }

    /**
     * Returns the connection between two connector points, or {@code null} if
     * none.
     * 
     * @param start
     * @param end
     * @return JNodeConnection
     */
    public JNodeConnection getConnection(JConnectorPoint start, JConnectorPoint end) {
        for (int i = 0; i < getComponentCount(); i++) {
            Component child = getComponent(i);
            if (child instanceof JNodeConnection) {
                JNodeConnection connection = (JNodeConnection) child;
                if ((connection.getFirst() == start || connection.getSecond() == start) && 
                    (connection.getFirst() == end || connection.getSecond() == end)) {
                    return connection;
                }
            }
        }
        return null;
    }

    /**
     * Removes a connection
     * 
     * @param connection 
     */
    public void removeConnection(JNodeConnection connection) {
        remove(connection);
    }
    
    /**
     * Adds a connection listener
     * 
     * @param listener 
     */
    public void addNodeConnectionListener(NodeConnectionListener listener) {
       listenerList.add(NodeConnectionListener.class, listener);
    }
    
    /**
     * Fires the event of a connection created
     * 
     * @param connection
     */
    public void fireConnectionCreated(JNodeConnection connection) {
        for (NodeConnectionListener listener : listenerList.getListeners(NodeConnectionListener.class)) {
            listener.connectionCreated(new NodeConnectionEvent(connection));
        }
    }
    
    /**
     * Fires the event of a connection removed
     * 
     * @param connection
     */
    public void fireConnectionRemoved(JNodeConnection connection) {
        for (NodeConnectionListener listener : listenerList.getListeners(NodeConnectionListener.class)) {
            listener.connectionRemoved(new NodeConnectionEvent(connection));
        }
    }

    /**
     * Returns the selection
     * 
     * @return {@code Selection<JNode>}
     */
    public Selection<JNode> getSelection() {
        return selection;
    }
    
    /**
     * Select listener
     */
    private class SelectListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() instanceof JNode) {
                JNode node = (JNode) e.getSource();
                Selection<JNode> oldSelection = selection.copy();
                for (JNode oldNode : oldSelection) {
                    oldNode.repaint();
                }
                selection.set(node);
                node.repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }

}
