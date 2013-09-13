/*
 * Copyright (C) 2013 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cyanogenmod.hardware;

import java.io.File;

import android.util.Log;

public class AppMovingSettings {
    private static final String TAG = "AppMovingSettings";
    private static final String file = "/data/system/no-external-apps";

    public static boolean isEnabled() {
        File f = new File(file);
        if (f.exists()) {
            return false;
        }
        return true;
    }

    private static void removeFile() {
        try {
            File f = new File(file);
            f.delete();
        } catch (Exception e) {
            Log.e(TAG, "Failed to remove " + file + "; " + e.getMessage());
        }
    }

    private static void createFile() {
        try {
            File f = new File(file);
            f.createNewFile();
        } catch (Exception e) {
            Log.e(TAG, "Failed to create " + file + "; " + e.getMessage());
        }
    }

    public static synchronized void setEnabled(boolean status) {
        removeFile();
        if (status == false) {
            createFile();
        }
    }
}
