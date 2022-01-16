package com.jb15613.themechooser.model

import android.graphics.drawable.Drawable


class NavObject {
    var iD: String? = null
    var title: String? = null
    var icon: Drawable? = null
    var viewType = 0

    constructor() {}
    constructor(id: String?, data: String?, icon: Drawable?, type: Int) {
        iD = id
        title = data
        this.icon = icon
        viewType = type
    }

    constructor(data: String?, icon: Drawable?, type: Int) {
        title = data
        this.icon = icon
        viewType = type
    }

}