package visnode.executor;

import visnode.commons.Input;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import visnode.commons.Output;
import visnode.pdi.Process;
import visnode.pdi.ImageProcess;

/**
 * Process node representation
 */
public class ProcessNode implements Node, AttacherNode {

    /** Process class */
    private final Class<ImageProcess> process;
    /** Process input */
    private final List<String> processInput;
    /** Process output */
    private final Map<String, Method> processOutput;
    /** Node connector */
    private final NodeConnector connector;
    /** Node parameter */
    private final Map<String, Object> parameters;

    /**
     * Creates a new process node
     *
     * @param process
     */
    public ProcessNode(Class process) {
        this.process = process;
        this.processInput = buildProcessInput();
        this.processOutput = buildProcessOutput();
        this.connector = new NodeConnector();
        this.parameters = new HashMap<>();
    }

    /**
     * Builds inputs attributes
     *
     * @return List
     */
    private List buildProcessInput() {
        Constructor constructor = process.getConstructors()[0];
        List<String> inputs = new ArrayList<>();
        for (Annotation[] t : constructor.getParameterAnnotations()) {
            if (t.length != 0 && t[0] instanceof Input) {
                inputs.add(((Input) t[0]).value());
            }
        }
        return inputs;
    }

    /**
     * Builds outputs attributes
     *
     * @return Map
     */
    private Map buildProcessOutput() {
        Map outputs = new HashMap<>();
        Method[] methods = process.getDeclaredMethods();
        Arrays.stream(methods).filter((method) -> {
            return method.getAnnotation(Output.class) != null;
        }).forEach((method) -> {
            String name = method.getAnnotation(Output.class).value();
            outputs.put(name, method);
        });
        return outputs;
    }

    @Override
    public Object getAttribute(String attribute) {
        try {
            Process prc = buildProcess();
            prc.process();
            return processOutput.get(attribute).invoke(prc);
        } catch (IllegalArgumentException | ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Adds a new parameter
     *
     * @param parameter
     * @param value
     */
    public void addParameter(String parameter, Object value) {
        parameters.put(parameter, value);
    }

    /**
     * Returns a node property
     *
     * @param parameter
     * @return Object
     */
    private Object getProperty(String parameter) {
        if (parameters.containsKey(parameter)) {
            return parameters.get(parameter);
        }
        NodeConnection connection = connector.getConnection(parameter);
        return connection.getNode().getAttribute(connection.getAttribute());
    }

    /**
     * Builds a new process
     *
     * @return ImageProcess
     */
    private Process buildProcess() {
        try {
            Constructor constructor = process.getConstructors()[0];
            List<Object> list = new ArrayList<>();
            processInput.forEach((input) -> {
                list.add(getProperty(input));
            });
            return (Process) constructor.newInstance(list.toArray());
        } catch (IllegalArgumentException | ReflectiveOperationException ex) {
            throw new RuntimeException("Process build fail", ex);
        }
    }

    @Override
    public void addConnection(String attribute, Node node, String attributeNode) {
        connector.addConnection(attribute, node, attributeNode);
    }

    /**
     * Returns inputs parameters
     *
     * @return List
     */
    public List<String> getInputParameters() {
        return Collections.unmodifiableList(processInput);
    }

    /**
     * Returns outputs parameters
     *
     * @return List
     */
    public List<String> getOutputParameters() {
        return new ArrayList(processOutput.keySet());
    }

    /**
     * Returns the connector
     * 
     * @return NodeConnector
     */
    public NodeConnector getConnector() {
        return connector;
    }

}
