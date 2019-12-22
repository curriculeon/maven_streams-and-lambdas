package com.zipcodewilmington.streams.conversions;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 * ConversionAgent is responsible for conversion between different object sequent data types
 * Object sequent data types include: collections, arrays, lists, maps, iterators
 *
 * @param <ObjectSequentDataType> some Object sequent data type
 * @param <TypeOfObjectSequence> Type of Object in the object sequence
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */

public abstract class ConversionAgent<ObjectSequentDataType, TypeOfObjectSequence> {
    protected ObjectSequentDataType objectSequence;

    public ConversionAgent(ObjectSequentDataType objectSequence) {
        this.objectSequence = objectSequence;
    }

    /**
     * @return list representation of this object sequence
     */
    abstract public List<TypeOfObjectSequence> toList();

    /**
     * @return stream representation of this object sequence
     */
    abstract public Stream<TypeOfObjectSequence> toStream();

    /**
     * @return array representation of this object sequence
     */
    abstract public TypeOfObjectSequence[] toArray();

    /**
     * @param predicate Represents a predicate (boolean-valued function) of one argument
     * @return stream representation of respectively filtered
     */
    public Stream<TypeOfObjectSequence> filter(Predicate<? super TypeOfObjectSequence> predicate) {
        return toStream().filter(predicate);
    }

    /**
     * @param predicate Represents a predicate (boolean-valued function) of one argument
     * @return stream representation of respectively filtered
     */
    public Stream<TypeOfObjectSequence> flatMap(Function<? super TypeOfObjectSequence, ? extends Stream<TypeOfObjectSequence>> predicate) {
        return toStream().flatMap(predicate);
    }
}
