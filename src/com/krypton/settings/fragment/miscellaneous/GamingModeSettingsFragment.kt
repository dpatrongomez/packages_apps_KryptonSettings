/*
 * Copyright (C) 2020 The exTHmUI Open Source Project
 *               2021 AOSP-Krypton Project
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

package com.krypton.settings.fragment.miscellaneous

import android.os.Bundle

import com.android.settings.R
import com.krypton.settings.fragment.KryptonDashboardFragment

class GamingModeSettingsFragment: KryptonDashboardFragment() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        val isPerfModeSupported = context!!.resources.getBoolean(
            com.android.internal.R.bool.config_gamingmode_performance)
        if (!isPerfModeSupported) {
            removePreference(CHANGE_PERF_LEVEL_KEY)
            removePreference(PERF_LEVEL_KEY)
        }
    }

    override protected fun getPreferenceScreenResId() = R.xml.gaming_mode_settings

    override protected fun getLogTag() = TAG

    companion object {
        private const val TAG = "GamingModeSettingsFragment"

        private const val CHANGE_PERF_LEVEL_KEY = "gaming_mode_change_performance_level"
        private const val PERF_LEVEL_KEY = "gaming_mode_performance_level"
    }
}
