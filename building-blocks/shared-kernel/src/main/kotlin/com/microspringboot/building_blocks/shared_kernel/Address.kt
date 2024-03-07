package com.microspringboot.building_blocks.shared_kernel

data class Address(
    val province: String,
    val city: String,
    val detail: String) {

    fun changeDetailTo(detail: String): Address {
        return Address(province, city, detail)
    }

    companion object {
        fun of(province: String, city: String, detail: String): Address {
            return Address(province, city, detail)
        }
    }
}
