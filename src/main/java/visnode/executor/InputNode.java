package visnode.executor;

import java.util.ArrayList;
import java.util.List;
import visnode.commons.Image;

/**
 * Input node representation
 */
public class InputNode implements Node {

    /** Input image */
    private final Image imagem;
    /** Node connector */
    private final NodeConnector connector;

    /**
     * Creates a new input node
     *
     * @param imagem
     */
    public InputNode(Image imagem) {
        this.imagem = imagem;
        this.connector = new NodeConnector();
    }

    @Override
    public Object getAttribute(String attribute) {
        if (attribute.equals("image")) {
            return imagem;
        }
        return null;
    }

    @Override
    public List<String> getInputParameters() {
        return new ArrayList<>();
    }

    @Override
    public List<String> getOutputParameters() {
        List<String> list = new ArrayList<>();
        list.add("image");
        return list;
    }

    @Override
    public NodeConnector getConnector() {
        return connector;
    }

}
