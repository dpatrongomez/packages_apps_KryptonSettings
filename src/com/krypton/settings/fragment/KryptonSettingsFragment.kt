/*
 * Copyright (C) 2021-2022 AOSP-Krypton Project
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

package com.krypton.settings.fragment

import android.os.Bundle

import com.android.internal.util.krypton.KryptonUtils
import com.android.settings.R
import com.android.settings.search.BaseSearchIndexProvider
import com.android.settingslib.search.SearchIndexable

@SearchIndexable
class KryptonSettingsFragment: KryptonDashboardFragment() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        val deviceSettingsInstalled = KryptonUtils.isPackageInstalled(context,
            "com.krypton.settings.device", false /* ignoreState */)
        if (!deviceSettingsInstalled) {
            removePreference(DEVICE_SETTINGS_PREF_KEY)
        }
    }

    override protected fun getPreferenceScreenResId() = R.xml.krypton_settings

    override protected fun getLogTag() = TAG

    companion object {
        private const val TAG = "KryptonSettingsFragment"

        private const val DEVICE_SETTINGS_PREF_KEY = "device_settings"

        @JvmField
        val SEARCH_INDEX_DATA_PROVIDER = BaseSearchIndexProvider(R.xml.krypton_settings)
    }
}
