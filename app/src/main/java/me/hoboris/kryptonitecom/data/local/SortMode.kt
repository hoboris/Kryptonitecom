package me.hoboris.kryptonitecom.data.local

enum class SortMode {
    ASCENDANT,
    DESCENDANT;

    val next: SortMode
        get() = values()[(ordinal + 1) % values().size]
}