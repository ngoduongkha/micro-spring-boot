package com.microspringboot.building_blocks.jpa.domain.specification

/**
 * Abstract base implementation of composite [Specification] with default
 * implementations for `and`, `or` and `not`.
 */
abstract class AbstractSpecification<T> : Specification<T> {
    /**
     * {@inheritDoc}
     */
    abstract override fun isSatisfiedBy(t: T): Boolean

    /**
     * {@inheritDoc}
     */
    override fun and(specification: Specification<T>): Specification<T> {
        return AndSpecification(this, specification)
    }

    /**
     * {@inheritDoc}
     */
    override fun or(specification: Specification<T>): Specification<T> {
        return OrSpecification(this, specification)
    }

    /**
     * {@inheritDoc}
     */
    override fun not(specification: Specification<T>): Specification<T> {
        return NotSpecification(specification)
    }
}