package visnode.application;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import visnode.application.parser.NodeNetworkParser;
import visnode.gui.IconFactory;

/**
 * Action for saving the current project
 */
public class ActionSave extends AbstractAction {

    /** Node network parser */
    private final NodeNetworkParser parser;

    /**
     * Creates a new action
     */
    public ActionSave() {
        super("Save", IconFactory.get().create("fa:floppy-o"));
        this.parser = new NodeNetworkParser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save");
        chooser.setApproveButtonText("Save");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(chooser.getSelectedFile(), "UTF-8");) {
                writer.print(parser.toJson(VISNode.get().getModel().getNetwork()));
            } catch (IOException ex) {
                ExceptionHandler.get().handle(ex);
            }
        }
    }

}