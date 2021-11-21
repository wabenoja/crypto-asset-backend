package com.liverton.crypto.viewer.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.immutables.value.Value;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
    allParameters = true,
    privateNoargConstructor = true,
    typeAbstract= "*Def",
    typeImmutable = "*",
    defaults = @Value.Immutable(builder = false, copy = false))
public @interface ImmutableType {}