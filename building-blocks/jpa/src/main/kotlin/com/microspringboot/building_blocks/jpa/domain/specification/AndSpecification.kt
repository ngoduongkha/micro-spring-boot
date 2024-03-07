package com.microspringboot.building_blocks.jpa.domain.specification

/**
 * AND specification, used to create a new specification that is the AND of two other specifications.
 */
class AndSpecification<T>(spec1: Specification<T>, spec2: Specification<T>) : AbstractSpecification<T>() {
    private val spec1: Specification<T>
    private val spec2: Specification<T>

    /**
     * Create a new AND specification based on two other spec.
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
        return spec1.isSatisfiedBy(t) && spec2.isSatisfiedBy(t)
    }
}
