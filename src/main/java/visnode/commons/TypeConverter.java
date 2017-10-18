package visnode.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Type converter
 */
public class TypeConverter {

    /** Converters */
    private final List<TypeConverterExecutor> converters;

    public TypeConverter() {
        this.converters = new ArrayList<>();
        this.converters.add(new TypeConverterGeneric());
        this.converters.add(new TypeConverterThreshold());
        this.converters.add(new TypeConverterGeneric());
    }

    /**
     * Converts a {@code value} to a value of type {@code <D>} (Destiny)
     *
     * @param <D>
     * @param value
     * @param destinyType
     * @return D
     */
    public <D> D convert(Object value, Class<D> destinyType) {
        if (value == null) {
            return null;
        }
        return convert(value, value.getClass(), destinyType);
    }

    /**
     * Converts a {@code value} to a value of type {@code <D>} (Destiny)
     *
     * @param <D>
     * @param value
     * @param sourceType
     * @param destinyType
     * @return D
     */
    public <D> D convert(Object value, Class sourceType, Class<D> destinyType) {
        try {
            if (value == null) {
                return null;
            }
            return converters.stream().
                    filter((converter) -> converter.can(sourceType, destinyType)).
                    findFirst().get().convert(value, destinyType);
        } catch (NoSuchElementException e) {
            throw new UnsupportedOperationException("Unknown conversion from " + sourceType + " to " + destinyType, e);
        }
    }

    public boolean isValidConvertion(Class sourceType, Class destinyType) {
        return converters.stream().anyMatch((converter) -> converter.can(sourceType, destinyType));
    }

}
