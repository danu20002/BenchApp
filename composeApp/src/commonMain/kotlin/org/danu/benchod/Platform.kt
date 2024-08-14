package org.danu.benchod

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform