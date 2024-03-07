package com.microspringboot.building_blocks.shared_kernel.exceptions

class LockAlreadyOccupiedException(lockKey: String) :
    AppException(CommonErrorCode.LOCK_OCCUPIED, mapOf("lockKey" to lockKey))
