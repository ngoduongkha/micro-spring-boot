package com.microspringboot.building_blocks.jpa.domain

import java.io.Serializable

/**
 * A value object, as described in the DDD book.
 *
 */
interface ValueObject<T> : Serializable {
    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return `true` if the given value object's and this value object's attributes are the same.
     */
    fun sameValueAs(other: T): Boolean
}
