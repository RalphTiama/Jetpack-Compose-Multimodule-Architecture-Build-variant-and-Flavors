package com.example.featuremoduled

class NativeLib {

    /**
     * A native method that is implemented by the 'featuremoduled' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'featuremoduled' library on application startup.
        init {
            System.loadLibrary("featuremoduled")
        }
    }
}