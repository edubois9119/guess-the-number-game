package com.ericadubois;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Indicates the context in which an annotation type is applicable. Ex Annotation MaxNumber can be added to
// fields, parameters and methods.
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })

// Indicates how long annotations with the annotated type are to be retained.
@Retention(RetentionPolicy.RUNTIME)

//used to annotated custom annotations that can be used as qualifers
@Qualifier
//This is a new annotation not really an interface
public @interface MaxNumber {
}
