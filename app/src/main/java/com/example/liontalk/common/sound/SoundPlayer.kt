package com.example.liontalk.common.sound

import android.content.Context
import android.media.AudioManager
import android.media.AudioManager.FX_FOCUS_NAVIGATION_DOWN
import android.media.AudioManager.FX_FOCUS_NAVIGATION_UP
import android.media.AudioManager.FX_KEYPRESS_RETURN
import android.media.AudioManager.FX_KEY_CLICK

class SoundPlayer(private val context: Context) {

    private val soundMap: Map<SoundType, Int> = mapOf(
        SoundType.MESSAGE_SENT to FX_KEY_CLICK,
        SoundType.MESSAGE_RECEIVED to FX_KEYPRESS_RETURN,
        SoundType.ENTER_ROOM to FX_FOCUS_NAVIGATION_UP,
        SoundType.LEAVE_ROOM to FX_FOCUS_NAVIGATION_DOWN,
    )
    fun play(type: SoundType) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        soundMap.get(type)?.let { audioManager.playSoundEffect(it) }
    }
}