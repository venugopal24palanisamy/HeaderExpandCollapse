package com.debduttapanda.motionlayoutwithnestedscrollandswipeable.management

abstract class MiDynamicOffsetScrollFlagState(
    heightRange: IntRange,
    scrollValue: Int
) : MiScrollFlagState(heightRange, scrollValue) {

    protected abstract var scrollOffset: Float

}