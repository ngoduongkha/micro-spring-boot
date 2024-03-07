package com.microspringboot.building_blocks.jpa.domain.specification

/**
 * NOT decorator, used to create a new specification that is the inverse (NOT) of the given spec.
 */
class NotSpecification<T>(spec1: Specification<T>) : AbstractSpecification<T>() {
    private val spec1: Specification<T>

    /**
     * Create a new NOT specification based on another spec.
     *
     * @param spec1 Specification instance to not.
     */
    init {
        this.spec1 = spec1
    }

    /**
     * {@inheritDoc}
     */
    override fun isSatisfiedBy(t: T): Boolean {
        return !spec1.isSatisfiedBy(t)
    }
}
