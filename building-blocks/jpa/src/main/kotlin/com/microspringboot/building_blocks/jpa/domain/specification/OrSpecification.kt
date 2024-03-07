package com.microspringboot.building_blocks.jpa.domain.specification

/**
 * OR specification, used to create a new specification that is the OR of two other specifications.
 */
class OrSpecification<T>(spec1: Specification<T>, spec2: Specification<T>) : AbstractSpecification<T>() {
    private val spec1: Specification<T>
    private val spec2: Specification<T>

    /**
     * Create a new OR specification based on two other spec.
     *
     * @param spec1 Specification one.
     * @param spec2 Specification two.
     */
    init {
        this.spec1 = spec1
        this.spec2 = spec2
    }

    /**
     * {@inheritDoc}
     */
    override fun isSatisfiedBy(t: T): Boolean {
        return spec1.isSatisfiedBy(t) || spec2.isSatisfiedBy(t)
    }
}
