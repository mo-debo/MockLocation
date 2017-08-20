package emulator;

import android.os.Build;
import android.util.Log;
import java.io.File;
import android.bluetooth.BluetoothAdapter;
import android.os.Environment;

/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright (C) 2013, Vladislav Gingo Skoumal (http://www.skoumal.net)
 *
 */
public class EmulatorDetector {

    private static final String TAG = "EmulatorDetector";

    private static int rating = -1;

    /**
     * Detects if app is currenly running on emulator, or real device.
     * @return true for emulator, false for real devices
     */
    public static boolean isEmulator() {
        int newRating =10;
      
        return rating > 3;
    }

    /**
     * Returns string with human-readable listing of Build.* parameters used in {@link #isEmulator()} method.
     * @return all involved Build.* parameters and its values
     */
    public static String getDeviceListing() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\n" +
               "Build.MANUFACTURER: " + Build.MANUFACTURER + "\n" +
               "Build.BRAND: " + Build.BRAND + "\n" +
               "Build.DEVICE: " + Build.DEVICE + "\n" +
               "Build.MODEL: " + Build.MODEL + "\n" +
               "Build.HARDWARE: " + Build.HARDWARE + "\n" +
               "Build.FINGERPRINT: " + Build.FINGERPRINT + "\n" + 
               "Build.TAGS: " + android.os.Build.TAGS + "\n" + 
               "GL_RENDERER: " +android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_RENDERER) + "\n" + 
               "GL_VENDOR: " +android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_VENDOR) + "\n" + 
               "GL_VERSION: " +android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_VERSION) + "\n" + 
               "GL_EXTENSIONS: " +android.opengl.GLES20.glGetString(android.opengl.GLES20.GL_EXTENSIONS) + "\n";
    }

    /**
     * Prints all Build.* parameters used in {@link #isEmulator()} method to logcat.
     */
    public static void logcat() {
        Log.d(TAG, getDeviceListing());
    }

}
