package com.microspringboot.building_blocks.jpa.domain.specification

/**
 * Specification interface.
 *
 *
 * Use [AbstractSpecification] as base
 * for creating specifications, and
 * only the method [.isSatisfiedBy] must be implemented.
 */
interface Specification<T> {
    /**
     * Check if `t` is satisfied by the specification.
     *
     * @param t Object to test.
     * @return `true` if `t` satisfies the specification.
     */
    fun isSatisfiedBy(t: T): Boolean

    /**
     * Create a new specification that is the AND operation of `this` specification and another specification.
     * @param specification Specification to AND.
     * @return A new specification.
     */
    fun and(specification: Specification<T>): Specification<T>

    /**
     * Create a new specification that is the OR operation of `this` specification and another specification.
     * @param specification Specification to OR.
     * @return A new specification.
     */
    fun or(specification: Specification<T>): Specification<T>

    /**
     * Create a new specification that is the NOT operation of `this` specification.
     * @param specification Specification to NOT.
     * @return A new specification.
     */
    fun not(specification: Specification<T>): Specification<T>
}
